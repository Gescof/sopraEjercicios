package negocio;

import org.springframework.stereotype.Service;

import entidades.MemoriaSecundaria;
import entidades.Ordenador;
import entidades.Pedido;

@Service
public class GestorPedidos {
	private Pedido pedido;
	
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public boolean validarOrdenador(Ordenador ordenador) {
		boolean result = false;
		if(ordenador.getProcesador() != null
			&& ordenador.getMemoriaRam() != null
			&& ordenador.getAlmacenamiento() != null) {
			result = true;
		}
		return result;
	}
	
	public double calcularPrecio(Ordenador ordenador) {
		double precio = 0;
		precio += ordenador.getProcesador().getPrecio()
				+ ordenador.getMemoriaRam().getPrecio();
		for(MemoriaSecundaria disco : ordenador.getAlmacenamiento()) {
			precio += disco.getPrecio();
		}
		return precio;
	}
	
	public double calcularPrecio(Pedido pedido) {
		double precio = 0;
		for(Ordenador ordenador : pedido.getOrdenadores()) {
			precio += ordenador.getProcesador().getPrecio()
					+ ordenador.getMemoriaRam().getPrecio();
			for(MemoriaSecundaria disco : ordenador.getAlmacenamiento()) {
				precio += disco.getPrecio();
			}
		}
		return precio;
	}
	
}
