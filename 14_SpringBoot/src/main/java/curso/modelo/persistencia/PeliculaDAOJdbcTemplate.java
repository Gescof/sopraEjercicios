package curso.modelo.persistencia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import curso.modelo.entidades.Pelicula;

@Repository("daoPelicula")
public class PeliculaDAOJdbcTemplate implements PeliculaDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private PeliculaDAORowMapper peliculaMapper;

	@Override
	public void insertar(Pelicula pelicula) {
		String query = "INSERT INTO Peliculas (titulo, director, genero, year)"
					+ " VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(query,
				pelicula.getTitulo(),
				pelicula.getDirector(),
				pelicula.getGenero(),
				pelicula.getYear());
	}

	@Override
	public void modificar(Pelicula pelicula) {
		String query = "UPDATE Peliculas SET titulo = ?, director = ?, genero = ?, year = ?"
				+ " WHERE id = ?";
		jdbcTemplate.update(query,
			pelicula.getTitulo(),
			pelicula.getDirector(),
			pelicula.getGenero(),
			pelicula.getYear(),
			pelicula.getId());
	}

	@Override
	public void borrar(Pelicula pelicula) {
		String query = "DELETE FROM Peliculas WHERE id = ?";
		jdbcTemplate.update(query, pelicula.getId());
	}

	@Override
	public Pelicula buscar(Integer id) {
		String query = "SELECT * FROM Peliculas WHERE id = ?";
		Pelicula pelicula = jdbcTemplate.queryForObject(query, peliculaMapper, id);
		return pelicula;
	}

	@Override
	public List<Pelicula> listarPeliculas() {
		String query = "SELECT * FROM Peliculas";
		List<Pelicula> listaPeliculas  = jdbcTemplate.query(query, peliculaMapper);
		return listaPeliculas;
	}

}
