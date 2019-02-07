package modelo.negocio;

import modelo.entidades.Pelicula;
import modelo.persistencia.DAOPelicula;

public class GestorPeliculas {
	private DAOPelicula daoPelicula;

	public DAOPelicula getDaoPelicula() {
		return daoPelicula;
	}

	public void setDaoPelicula(DAOPelicula daoPelicula) {
		this.daoPelicula = daoPelicula;
	}
	
	public boolean insertar(Pelicula pelicula) {
		boolean result = false;
		if(!pelicula.getTitulo().equals("")) {
			result = daoPelicula.insertar(pelicula);
		}
		return result;
	}

}
