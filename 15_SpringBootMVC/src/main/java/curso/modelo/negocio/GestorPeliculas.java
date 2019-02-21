package curso.modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import curso.modelo.entidades.Pelicula;
import curso.modelo.persistencia.PeliculaDAO;

@Service
public class GestorPeliculas {
	
	@Autowired
	private PeliculaDAO daoPeliculas;
	
	public List<Pelicula> getListaPeliculas() {
		return daoPeliculas.listarPeliculas();
	}

	@Transactional
	public void insertar(Pelicula pelicula) {
		daoPeliculas.insertar(pelicula);
	}
	
	public Pelicula buscar(Integer id) {
		return daoPeliculas.buscar(id);
	}
	
	@Transactional
	public void borrar(Pelicula pelicula) {
		daoPeliculas.borrar(pelicula);
	}
	
	@Transactional
	public void modificar(Pelicula pelicula) {
		daoPeliculas.modificar(pelicula);
	}
	
}
