package modelo.negocio;

import java.util.Collections;
import java.util.List;

import modelo.entidades.Coche;
import modelo.entidades.CompararPorKm;
import modelo.entidades.CompararPorMarca;
import modelo.entidades.CompararPorMatricula;
import modelo.persistencia.DAOCoche;

public class GestorCoches {
	private DAOCoche daoCoche;

	public DAOCoche getDAOCoche() {
		return daoCoche;
	}

	public void setDAOCoche(DAOCoche daoCoche) {
		this.daoCoche = daoCoche;
	}
	
	public boolean insertar(Coche coche) {
		boolean result = false;
		if(coche.getMatricula().length() == 7) {
			if(!daoCoche.getListaCoches().contains(coche)) {
				result = daoCoche.insertar(coche);
			} else {
				System.out.println("Ya existe un coche con la misma matricula.");
			}
		} else {
			System.out.println("La matricula debe tener 7 caracteres.");
		}
		return result;
	}
	
	public List<Coche> ordenarListaPorMatricula() {
		List<Coche> listaCoches = daoCoche.getListaCoches();
		Collections.sort(listaCoches, new CompararPorMatricula());
		return listaCoches;
	}
	
	public List<Coche> ordenarListaPorKm() {
		List<Coche> listaCoches = daoCoche.getListaCoches();
		Collections.sort(listaCoches, new CompararPorKm());
		return listaCoches;
	}
	
	public List<Coche> ordenarListaPorMarca() {
		List<Coche> listaCoches = daoCoche.getListaCoches();
		Collections.sort(listaCoches, new CompararPorMarca());
		return listaCoches;
	}
	
}
