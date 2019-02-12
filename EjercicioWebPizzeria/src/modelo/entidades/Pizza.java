package modelo.entidades;

import java.util.List;

public class Pizza {	
	private TamanioPizza tamanio;
	private List<String> ingredientes;

	public TamanioPizza getTamanio() {
		return tamanio;
	}
	public void setTamanio(TamanioPizza tamanio) {
		this.tamanio = tamanio;
	}
	public List<String> getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(List<String> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
}
