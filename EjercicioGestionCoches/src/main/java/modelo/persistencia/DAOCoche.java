package modelo.persistencia;

import java.util.List;

import modelo.entidades.Coche;

public class DAOCoche {
	private List<Coche> listaCoches;
	
	public List<Coche> getListaCoches() {
		return listaCoches;
	}

	public void setListaCoches(List<Coche> listaCoches) {
		this.listaCoches = listaCoches;
	}

	/**
	 * M�todo que inserta un elemento
	 * en la lista.
	 * @param Coche
	 * @return true: en caso correcto; false: error.
	 */
	public boolean insertar(Coche Coche) {
		boolean result = false;
		listaCoches.add(Coche);
		result = true;
		return result;
	}
	
}
