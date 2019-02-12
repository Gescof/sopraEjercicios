package modelo.negocio;

import modelo.entidades.Pedido;
import modelo.entidades.Pizza;
import modelo.entidades.Usuario;

public class GestorPedidos {
	public Pedido crearPedido(Usuario usuario, Pizza pizza, double precio) {
		Pedido pedido = new Pedido();
		pedido.setUsuario(usuario);
		pedido.setPizza(pizza);
		pedido.setPrecio(precio);
		return pedido;
	}
	
	public boolean validarPedido(Pedido pedido) {
		boolean result = false;
		if(pedido.getUsuario().getTelefono() != null) {
			if(pedido.getUsuario().getDireccion() != null) {
				if(!pedido.getPizza().getIngredientes().isEmpty())
					result = true;
			}
		}
		return result;
	}
	
}
