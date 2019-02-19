package controladores;

import javax.servlet.http.HttpSession;
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

import modelo.entidades.Usuario;
import modelo.negocio.GestorUsuarios;

@Controller
@Scope("request")
@RequestMapping("usuarios")
public class ControladorUsuarios {
	
	@Autowired
	private GestorUsuarios gUsuarios;
	
	@Autowired
	private Usuario usuario;

/*	@RequestMapping(path="index", method=RequestMethod.POST)
	public ModelAndView login(HttpSession session) {
		String mensajeError = "Error, el nombre de usuario o la contraseña no son correctos.";
		session.setAttribute("error", mensajeError);
		return new ModelAndView("redirect:/");
	}*/
	
	@RequestMapping(path="ingresarListadoVideojuegos", method=RequestMethod.POST)
	public ModelAndView ingresarUsuario(@Valid @ModelAttribute Usuario usuario,
										BindingResult br,
//										@Valid @RequestParam("nombre") String nombre,
//										@Valid @RequestParam("password") String password,
										HttpSession session)
	{
		ModelAndView mav;
		if(br.hasErrors()) {
			mav = new ModelAndView("redirect:/");
			String mensajeError = "";
			for(FieldError error : br.getFieldErrors()) {
				mensajeError += error.getField() + " " + error.getDefaultMessage();
			}
			mav.addObject("error", mensajeError);
		} else {
			session.setAttribute("usuario", usuario);
			mav = new ModelAndView("redirect:/mvc/videojuegos/verListado");
			mav.addObject(this.usuario);
		}
/*		if(!gUsuarios.buscar(usuario.getNombre(), usuario.getPassword())) {
			mav = new ModelAndView("redirect:/mvc/usuarios/index");
		} else {
			Usuario usuario = new Usuario();
			usuario.setNombre(nombre);
			usuario.setPassword(password);
			session.setAttribute("usuario", usuario);
			mav = new ModelAndView("redirect:/mvc/videojuegos/verListado");
		}*/
		return mav;
	}
	
	@RequestMapping(path="altaUsuario", method=RequestMethod.GET) 
	public ModelAndView altaUsuario() {
		ModelAndView mav = new ModelAndView("creacionUsuario");
		return mav;
	}
	
	@RequestMapping(path="insertarUsuario", method=RequestMethod.POST) 
	public ModelAndView insertarUsuario(@Valid @ModelAttribute Usuario usuario,
										BindingResult br
//										@Valid @RequestParam("nombre") String nombre,
//										@Valid @RequestParam("password") String password
										) 
	{
		ModelAndView mav;
//		Usuario usuario = new Usuario();
//		usuario.setNombre(nombre);
//		usuario.setPassword(password);
		if(br.hasErrors()) {
			mav = new ModelAndView("redirect:creacionUsuario");
			String mensajeError = "";
			for(FieldError error : br.getFieldErrors()) {
				mensajeError += error.getField() + " " + error.getDefaultMessage();
			}
			mav.addObject("error", mensajeError);
		} else {
			gUsuarios.insertar(usuario);
			mav = new ModelAndView("redirect:/");
		}
		return mav;
	}
	
}
