package modelo.persistencia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import modelo.entidades.Pelicula;

@Repository("daoPelicula")
public class PeliculaDAOJdbcTemplate implements PeliculaDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private PeliculaDAORowMapper peliculaMapper;

	@Override
	public void insertar(Pelicula pelicula) {
		jdbcTemplate.execute("SET autocommit = 0");
		String query = "INSERT INTO Peliculas (titulo, director, genero, year)"
					+ " VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(query,
				pelicula.getTitulo(),
				pelicula.getDirector(),
				pelicula.getGenero(),
				pelicula.getYear());
		jdbcTemplate.execute("COMMIT");
	}

	@Override
	public void modificar(Pelicula pelicula) {
		jdbcTemplate.execute("SET autocommit = 0");
		String query = "UPDATE Peliculas SET titulo = ?, director = ?, genero = ?, year = ?"
				+ " WHERE id = ?";
		jdbcTemplate.update(query,
			pelicula.getTitulo(),
			pelicula.getDirector(),
			pelicula.getGenero(),
			pelicula.getYear(),
			pelicula.getId());
		jdbcTemplate.execute("COMMIT");
	}

	@Override
	public void borrar(Pelicula pelicula) {
		jdbcTemplate.execute("SET autocommit = 0");
		String query = "DELETE FROM Peliculas WHERE id = ?";
		jdbcTemplate.update(query, pelicula.getId());
		jdbcTemplate.execute("COMMIT");
	}

	@Override
	public Pelicula buscar(Integer id) {
		String query = "SELECT sql_no_cache * FROM Peliculas WHERE id = ?";
//		BeanPropertyRowMapper<Pelicula> beanMapper = new BeanPropertyRowMapper<>();
		Pelicula pelicula = jdbcTemplate.queryForObject(query, peliculaMapper, id);
		return pelicula;
	}
	
//	@Override
//	public Pelicula buscar(String titulo) {
//		String query = "SELECT sql_no_cache * FROM Peliculas WHERE titulo = :titulo";
////	BeanPropertyRowMapper<Pelicula> beanMapper = new BeanPropertyRowMapper<>();
//		Pelicula pelicula = jdbcTemplate.queryForObject(query, peliculaMapper, titulo);
//		return pelicula;
//	}

	@Override
	public List<Pelicula> listarPeliculas() {
		String query = "SELECT sql_no_cache * FROM Peliculas";
//		BeanPropertyRowMapper<Pelicula> beanMapper = new BeanPropertyRowMapper<>();
		List<Pelicula> listaPeliculas  = jdbcTemplate.query(query, peliculaMapper);
		return listaPeliculas;
	}

}
