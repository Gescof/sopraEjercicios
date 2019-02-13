package entidades;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class Saludos {
	private List<String> listaSaludos = new ArrayList<>();

	public List<String> getListaSaludos() {
		return listaSaludos;
	}

	public void setListaSaludos(List<String> listaSaludos) {
		this.listaSaludos = listaSaludos;
	}
	
}
