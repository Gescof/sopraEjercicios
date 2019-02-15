package modelo.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import modelo.entidades.Pelicula;

@Component
public class PeliculaDAORowMapper implements RowMapper<Pelicula> {

	@Override
	public Pelicula mapRow(ResultSet rs, int rowNum) throws SQLException {
		Pelicula pelicula = new Pelicula();
		pelicula.setId(rs.getInt("id"));
		pelicula.setDirector(rs.getString("director"));
		pelicula.setGenero(rs.getString("genero"));
		pelicula.setTitulo(rs.getString("titulo"));
		pelicula.setYear(rs.getInt("year"));
		return pelicula;
	}
	
}
