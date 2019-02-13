package entidades;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Pedido {
	private Usuario usuario;
	private List<Ordenador> ordenadores = new ArrayList<>();
	private double precio;
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<Ordenador> getOrdenadores() {
		return ordenadores;
	}
	public void setOrdenadores(List<Ordenador> ordenador) {
		this.ordenadores = ordenador;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	@Override
	public String toString() {
		return "Pedido [usuario=" + usuario + ", ordenadores=" + ordenadores + ", precio=" + precio + "]";
	}
	
}
