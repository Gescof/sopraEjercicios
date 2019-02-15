package modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import modelo.entidades.Pelicula;
import modelo.persistencia.PeliculaDAO;

@Service
public class GestorPeliculas {
	
	@Autowired
	private PeliculaDAO daoPeliculas;
	
	public PeliculaDAO getDaoPelicula() {
		return daoPeliculas;
	}

	public void setDaoPelicula(PeliculaDAO daoPelicula) {
		this.daoPeliculas = daoPelicula;
	}

	public List<Pelicula> getListaPeliculas() {
		return daoPeliculas.listarPeliculas();
	}

	public void insertar(Pelicula pelicula) {
		daoPeliculas.insertar(pelicula);
	}
	
	public Pelicula buscar(Integer id) {
		return daoPeliculas.buscar(id);
	}
	
	public void borrar(Pelicula pelicula) {
		daoPeliculas.borrar(pelicula);
	}
	
	public void modificar(Pelicula pelicula) {
		daoPeliculas.modificar(pelicula);
	}
	
}
