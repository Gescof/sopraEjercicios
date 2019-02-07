package modelo.persistencia;

import java.util.List;

import modelo.entidades.Pelicula;

public class DAOPelicula {
	private List<Pelicula> listaPeliculas;
	private int maximoPeliculas;
	
	public List<Pelicula> getListaPeliculas() {
		return listaPeliculas;
	}

	public void setListaPeliculas(List<Pelicula> listaPeliculas) {
		this.listaPeliculas = listaPeliculas;
	}

	public int getMaximoPeliculas() {
		return maximoPeliculas;
	}

	public void setMaximoPeliculas(int maximoPeliculas) {
		this.maximoPeliculas = maximoPeliculas;
	}

	/**
	 * Método que inserta un elemento
	 * en la lista.
	 * @param pelicula
	 * @return true: en caso correcto; false: lista completa.
	 */
	public boolean insertar(Pelicula pelicula) {
		boolean result = false;
		if(listaPeliculas.size() <= maximoPeliculas) {
			listaPeliculas.add(pelicula);
			result = true;
		}
		return result;
	}
}
