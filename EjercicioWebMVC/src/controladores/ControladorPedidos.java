package controladores;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entidades.MemoriaPrincipal;
import entidades.MemoriaSecundaria;
import entidades.Ordenador;
import entidades.Pedido;
import entidades.Procesador;
import entidades.Usuario;
import negocio.GestorPedidos;

@Controller
@Scope("request")
public class ControladorPedidos {
	
	@Autowired
	private GestorPedidos gPedidos;

	@RequestMapping("agregarOrdenador")
	public ModelAndView agregarOrdenador(HttpServletRequest request, HttpSession session) 
	{
		ModelAndView mav = new ModelAndView();
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		
		String procesador = request.getParameter("procesador");
		String memoriaRam = request.getParameter("memoriaRam");
		String[] discos = request.getParameterValues("discos");
		if(discos != null) {
			Ordenador ordenador = new Ordenador();
			if(procesador.equals("intelI3")) {
				ordenador.setProcesador(Procesador.INTELI3);
			} else if(procesador.equals("intelI5")) {
				ordenador.setProcesador(Procesador.INTELI5);
			} else if(procesador.equals("intelI7")) {
				ordenador.setProcesador(Procesador.INTELI7);
			} else if(procesador.equals("amdR3")) {
				ordenador.setProcesador(Procesador.AMDRYZEN3);
			} else if(procesador.equals("amdR5")) {
				ordenador.setProcesador(Procesador.AMDRYZEN5);
			} else if(procesador.equals("amdR7")) {
				ordenador.setProcesador(Procesador.AMDRYZEN7);
			}
			
			if(memoriaRam.equals("_4gb")) {
				ordenador.setMemoriaRam(MemoriaPrincipal._4GB);
			} else if(memoriaRam.equals("_8gb")) {
				ordenador.setMemoriaRam(MemoriaPrincipal._8GB);
			} else if(memoriaRam.equals("_16gb")) {
				ordenador.setMemoriaRam(MemoriaPrincipal._16GB);
			} else if(memoriaRam.equals("_32gb")) {
				ordenador.setMemoriaRam(MemoriaPrincipal._32GB);
			}
			
			List<String> listaDiscosStr = Arrays.asList(discos);
			List<MemoriaSecundaria> listaDiscos = new ArrayList<>();
			for(String disco : listaDiscosStr) {
				if(disco.equals("hdd500")) {
					listaDiscos.add(MemoriaSecundaria.HDD500);
				} else if(disco.equals("hdd1000")) {
					listaDiscos.add(MemoriaSecundaria.HDD1000);
				} else if(disco.equals("hdd2000")) {
					listaDiscos.add(MemoriaSecundaria.HDD2000);
				} else if(disco.equals("ssd256")) {
					listaDiscos.add(MemoriaSecundaria.SSD256);
				} else if(disco.equals("ssd512")) {
					listaDiscos.add(MemoriaSecundaria.SSD512);
				}
			}
			ordenador.setAlmacenamiento(listaDiscos);
			
			if(gPedidos.validarOrdenador(ordenador)) {
				mav = new ModelAndView("pedidoOrdenador");
				
				Pedido pedido = gPedidos.getPedido();
				if(pedido == null) {
					pedido = new Pedido();
					pedido.setUsuario(usuario);
				} 
				pedido.getOrdenadores().add(ordenador);
				double precio = gPedidos.calcularPrecio(ordenador);
				precio += gPedidos.calcularPrecio(pedido);
				pedido.setPrecio(precio);
				gPedidos.setPedido(pedido);
				mav.addObject("pedido", pedido);
			}
		} else {
			mav = new ModelAndView("pedidoOrdenador");
			mav.addObject("errorOrdenador", "error");
		}
		return mav;
	}
	
	@RequestMapping("hacerPedido")
	public ModelAndView hacerPedido() {
		ModelAndView mav;
		if(gPedidos.getPedido() != null) {
			mav = new ModelAndView("resumenPedido");
			mav.addObject("pedido", gPedidos.getPedido());
		} else {
			mav = new ModelAndView("pedidoOrdenador");
			mav.addObject("errorPedido", "error");
		}
		return mav;
	}
	
}
