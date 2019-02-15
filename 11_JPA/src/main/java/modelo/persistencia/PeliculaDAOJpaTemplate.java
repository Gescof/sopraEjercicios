package modelo.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import modelo.entidades.Pelicula;

@Repository
public class PeliculaDAOJpaTemplate implements PeliculaDAO {

	@PersistenceContext
	EntityManager eManager;
	
	@Override
	public void insertar(Pelicula pelicula) {
		eManager.persist(pelicula);
	}

	@Override
	public void modificar(Pelicula pelicula) {
		eManager.merge(pelicula);
	}

	@Override
	public void borrar(Pelicula pelicula) {
		eManager.remove(pelicula);
	}

	@Override
	public Pelicula buscar(Integer id) {
		return eManager.find(Pelicula.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pelicula> listarPeliculas() {
		// Esto no es SQL, es JPQL
		return eManager.createQuery("select p from Pelicula p").getResultList();
	}

}
