package servlets;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.entidades.Pedido;
import modelo.entidades.Pizza;
import modelo.entidades.TamanioPizza;
import modelo.entidades.Usuario;
import modelo.negocio.GestorPedidos;
import modelo.negocio.GestorPizzas;

/**
 * Servlet implementation class ServletPedido
 */
@WebServlet("/ServletPedido")
public class ServletPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPedido() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String telefono = request.getParameter("telefono");
		String direccion = request.getParameter("direccion");
		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setTelefono(telefono);
		usuario.setDireccion(direccion);
		
		Pizza pizza = new Pizza();
		String tamanio = request.getParameter("tamanio");
		if(tamanio.equals("pequenia")) {
			pizza.setTamanio(TamanioPizza.PEQUENIA);
		} else if(tamanio.equals("mediana")) {
			pizza.setTamanio(TamanioPizza.MEDIANA);
		} else if(tamanio.equals("grande")) {
			pizza.setTamanio(TamanioPizza.GRANDE);
		}
		String[] ingredientes = request.getParameterValues("ingrediente");			
		List<String> listaIngredientes = Arrays.asList(ingredientes);
		if(!listaIngredientes.isEmpty()) {
			pizza.setIngredientes(listaIngredientes);
		}
		
		GestorPizzas gestorPizzas = new GestorPizzas();			
		double precio = gestorPizzas.calcularPrecio(pizza);
		
		GestorPedidos gestorPedidos = new GestorPedidos();
		Pedido pedido = gestorPedidos.crearPedido(usuario, pizza, precio);
		
		if(!gestorPedidos.validarPedido(pedido)) {		

			request.setAttribute("error", "error");
			RequestDispatcher rd = request.getRequestDispatcher("pedido.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("pedido", pedido);
			RequestDispatcher rd = request.getRequestDispatcher("resumenPedido.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
