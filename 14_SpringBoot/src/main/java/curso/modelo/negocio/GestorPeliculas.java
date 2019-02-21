package curso.modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import curso.modelo.entidades.Pelicula;
import curso.modelo.persistencia.PeliculaDAO;

@Service("gestorPeliculas")
public class GestorPeliculas {
	
	@Autowired
	private PeliculaDAO daoPelicula;
	
	@Transactional
	public void insertar(Pelicula pelicula) throws RuntimeException {
		if(pelicula.getTitulo() != null) {
			daoPelicula.insertar(pelicula);
		} else {
			throw new RuntimeException("Pelicula incorrecta");
		}
	}
	
	public List<Pelicula> listar() {
		return daoPelicula.listarPeliculas();
	}
}
