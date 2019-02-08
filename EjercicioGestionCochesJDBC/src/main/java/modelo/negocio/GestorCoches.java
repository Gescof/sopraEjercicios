package modelo.negocio;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import modelo.entidades.Coche;
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
	
	public Coche buscarCoche(Coche coche) {
		return daoCoche.buscar(coche.getId());
	}
	
	public boolean borrarCoche(Coche coche) {
		return daoCoche.borrar(coche);
	}
	
	public boolean modificarCoche(Coche coche) {
		return daoCoche.modificar(coche);
	}
	
	public List<Coche> ordenarCoches(Comparator<Coche> comparador) {
		List<Coche> listaCoches = daoCoche.getListaCoches();
		Collections.sort(listaCoches, comparador);
		return listaCoches;
	}
	
}
