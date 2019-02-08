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
		try {
			String query = "INSERT INTO Peliculas (titulo, director, genero, year)"
						+ " VALUES (?, ?, ?, ?)";
			jdbcTemplate.update(query,
					pelicula.getTitulo(),
					pelicula.getDirector(),
					pelicula.getGenero(),
					pelicula.getYear());
		} catch(EmptyResultDataAccessException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modificar(Pelicula pelicula) {
		try {
			String query = "UPDATE Peliculas SET titulo = ?, director = ?, genero = ?, year = ?"
					+ " WHERE id = ?";
			jdbcTemplate.update(query,
				pelicula.getTitulo(),
				pelicula.getDirector(),
				pelicula.getGenero(),
				pelicula.getYear(),
				pelicula.getId());
		} catch(EmptyResultDataAccessException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void borrar(Pelicula pelicula) {
		try {
			String query = "DELETE FROM Peliculas WHERE id = ?";
			jdbcTemplate.update(query, pelicula.getId());
		} catch(EmptyResultDataAccessException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Pelicula buscar(Integer id) {
		try {
			String query = "SELECT * FROM Peliculas WHERE id = ?";
//			BeanPropertyRowMapper<Pelicula> beanMapper = new BeanPropertyRowMapper<>();
			Pelicula pelicula = jdbcTemplate.queryForObject(query, peliculaMapper, id);
			return pelicula;
		} catch(EmptyResultDataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public Pelicula buscar(String titulo) {
		try {
			String query = "SELECT * FROM Peliculas WHERE titulo = ?";
//			BeanPropertyRowMapper<Pelicula> beanMapper = new BeanPropertyRowMapper<>();
			Pelicula pelicula = jdbcTemplate.queryForObject(query, peliculaMapper, titulo);
			return pelicula;
		} catch(EmptyResultDataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Pelicula> listarPeliculas() {
		try {
			String query = "SELECT * FROM Peliculas";
//			BeanPropertyRowMapper<Pelicula> beanMapper = new BeanPropertyRowMapper<>();
			List<Pelicula> listaPeliculas  = jdbcTemplate.query(query, peliculaMapper);
			return listaPeliculas;
		} catch(EmptyResultDataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}

}
