package modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import modelo.entidades.Pelicula;
import modelo.persistencia.PeliculaDAO;

@Service
public class GestorPeliculas {
	
	@Autowired
	private PeliculaDAO daoPelicula;
	
	@Transactional
	public void insertarPelicula(Pelicula pelicula) {
		daoPelicula.insertar(pelicula);
	}
	
	@Transactional
	public void modificarPelicula(Pelicula pelicula) {
		daoPelicula.modificar(pelicula);
	}
	
	@Transactional
	public void borrarPelicula(Pelicula pelicula) {
		daoPelicula.borrar(pelicula);
	}
	
	public Pelicula buscarPelicula(Integer id) {
		return daoPelicula.buscar(id);
	}
	
	public List<Pelicula> getListaPeliculas() {
		return daoPelicula.listarPeliculas();
	}
	
}
