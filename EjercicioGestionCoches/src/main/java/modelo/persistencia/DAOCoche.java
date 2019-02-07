package modelo.persistencia;

import java.util.List;

import modelo.entidades.Coche;

public class DAOCoche {
	private List<Coche> listaCoches;
	private int contcoches;
	
	public List<Coche> getListaCoches() {
		return listaCoches;
	}

	public void setListaCoches(List<Coche> listaCoches) {
		this.listaCoches = listaCoches;
	}

	/**
	 * Metodo que inserta un elemento
	 * en la lista.
	 * @param Coche
	 * @return true: en caso correcto; false: error.
	 */
	public boolean insertar(Coche coche) {
		boolean result = false;
		listaCoches.add(coche);
		coche.setId(++this.contcoches);
		result = true;
		return result;
	}
	
}
