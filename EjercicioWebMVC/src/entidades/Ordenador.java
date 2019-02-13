package entidades;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Ordenador {
	private Procesador procesador;
	private MemoriaPrincipal memoriaRam;
	private List<MemoriaSecundaria> almacenamiento = new ArrayList<>();
	
	public Procesador getProcesador() {
		return procesador;
	}
	public void setProcesador(Procesador procesador) {
		this.procesador = procesador;
	}
	public MemoriaPrincipal getMemoriaRam() {
		return memoriaRam;
	}
	public void setMemoriaRam(MemoriaPrincipal memoriaRam) {
		this.memoriaRam = memoriaRam;
	}
	public List<MemoriaSecundaria> getAlmacenamiento() {
		return almacenamiento;
	}
	public void setAlmacenamiento(List<MemoriaSecundaria> almacenamiento) {
		this.almacenamiento = almacenamiento;
	}
	
	@Override
	public String toString() {
		return "[procesador=" + procesador + ", memoriaRam=" + memoriaRam + ", almacenamiento="
				+ almacenamiento + "]";
	}
	
}
