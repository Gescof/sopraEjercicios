package controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entidades.Usuario;
import negocio.GestorUsuarios;

@Controller
@Scope("request")
public class ControladorUsuarios {
	
	@Autowired
	private GestorUsuarios gUsuarios;

	@RequestMapping("ingresarFormularioPedido")
	public ModelAndView ingresarUsuario(HttpServletRequest request, HttpSession session)
	{
		ModelAndView mav;
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setPassword(password);
		session.setAttribute("usuario", usuario);
		gUsuarios = new GestorUsuarios();
		if(gUsuarios.buscarUsuario(usuario)) {
			mav = new ModelAndView("pedidoOrdenador");
			mav.addObject("usuario", usuario);
		} else {
			mav = new ModelAndView("redirect:/index.html");
			mav.addObject("errorUsuario", "error");
		}
		return mav;
	}
	
}
