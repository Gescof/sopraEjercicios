package controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import entidades.Persona;
import entidades.Saludos;

@Controller
@Scope("request")
public class ControladorSaludos {
	
	@Autowired
	private Saludos saludos;
	
	@RequestMapping("verFormularioSaludo")
	public ModelAndView verFormulario() {
		ModelAndView mav = new ModelAndView("formularioSaludo");
		return mav;
	}
	
	@RequestMapping("saludo")
	public ModelAndView mandarSaludo(@RequestParam("nombre") String nombre, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("saludo");
		String saludo = "Yo te saludo: " + nombre;
		System.out.println(nombre);
		// nombreAux va a tener el mismo contenido que nombre
		String nombreAux = request.getParameter("nombre");
		System.out.println(nombreAux);
		
		Persona p = new Persona();
		p.setNombre(nombre);
		
		saludos.getListaSaludos().add(saludo);
		
		mav.addObject("saludo", saludo);
		mav.addObject("persona", p);
		mav.addObject("listaSaludos", saludos.getListaSaludos());
		return mav;
	}
	
}
