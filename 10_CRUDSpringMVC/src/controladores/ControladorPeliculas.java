package controladores;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import modelo.entidades.Pelicula;
import modelo.negocio.GestorPeliculas;

@Controller
@Scope("request")
@RequestMapping("peliculas")
public class ControladorPeliculas {
	
	@Autowired
	private GestorPeliculas gestorPeliculas;
	
	public GestorPeliculas getGestorPeliculas() {
		return gestorPeliculas;
	}

	public void setGestorPeliculas(GestorPeliculas gestorPeliculas) {
		this.gestorPeliculas = gestorPeliculas;
	}

	@RequestMapping("verListado")
	public ModelAndView verListadoPeliculas() {
		List<Pelicula> listaPeliculas = gestorPeliculas.getListaPeliculas();		
		ModelAndView mav = new ModelAndView("listadoPeliculas");
		mav.addObject("listaPeliculas", listaPeliculas);
		return mav;
	}
	
	@RequestMapping("verFormulario")
	public ModelAndView verFormulario() {
		ModelAndView mav= new ModelAndView("formularioPeliculas");
		mav.addObject("pelicula", new Pelicula());
		return mav;
	}
	
	// Siempre que hacemos un insertar (POST), 
	// siempre hay que hacer un redirect
	@RequestMapping(path="insertar", method=RequestMethod.POST)
	public ModelAndView insertarPelicula(@Valid @ModelAttribute Pelicula pelicula, BindingResult br) {
		if(br.hasErrors()) {
			ModelAndView mav = new ModelAndView("formularioPeliculas");
			String mensajeError = "";
			for(FieldError error : br.getFieldErrors()) {
				mensajeError += error.getField() + " " + error.getDefaultMessage();
			}
			mav.addObject("errores", mensajeError);
			return mav;
		} else {
			gestorPeliculas.insertar(pelicula);
			return new ModelAndView("redirect:verListado");
		}
	}
	
	@RequestMapping(path="seleccionar", method=RequestMethod.GET)
	public ModelAndView seleccionarPelicula(@RequestParam("id") Integer id) {
		ModelAndView mav = new ModelAndView("formularioPeliculas");
		Pelicula pelicula = gestorPeliculas.buscar(id);
		mav.addObject("pelicula", pelicula);
		return mav;
	}
	
	@RequestMapping(path="eliminar", method=RequestMethod.POST)
	public ModelAndView borrarPelicula(@ModelAttribute Pelicula pelicula) {
		ModelAndView mav = new ModelAndView("redirect:verListado");
		gestorPeliculas.borrar(pelicula);
		return mav;
	}
	
	@RequestMapping(path="actualizar", method=RequestMethod.POST)
	public ModelAndView actualizarPelicula(@ModelAttribute Pelicula pelicula) {
		ModelAndView mav = new ModelAndView("redirect:verListado");
		gestorPeliculas.modificar(pelicula);
		return mav;
	}
	
}
