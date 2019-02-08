package modelo.persistencia;

import java.util.List;

import modelo.entidades.Pelicula;

public interface PeliculaDAO {
	void insertar(Pelicula pelicula);
	void modificar(Pelicula pelicula);
	void borrar(Pelicula pelicula);
	Pelicula buscar(Integer id);
//	Pelicula buscar(String titulo);
	List<Pelicula> listarPeliculas();
}
