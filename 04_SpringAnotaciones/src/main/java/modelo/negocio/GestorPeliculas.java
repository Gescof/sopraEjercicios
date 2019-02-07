package modelo.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import modelo.entidades.Pelicula;
import modelo.persistencia.DAOPelicula;

@Service
public class GestorPeliculas {
	
	@Autowired
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
