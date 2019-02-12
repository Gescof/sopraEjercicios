package modelo.negocio;

import modelo.entidades.Pizza;

public class GestorPizzas {
	public double calcularPrecio(Pizza pizza) {
		double precio = 0;
		precio += pizza.getTamanio().getPrecio();
		int numIngredientes = pizza.getIngredientes().size();
		for(int i = 0; i < numIngredientes; i++) {
			precio += 0.5;
		}
		return precio;
	}
}
