package modelo.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.RowMapper;

import modelo.entidades.Coche;

public class DAOCocheRowMapper implements RowMapper<Coche> {
	private static ApplicationContext context;
	
	static {
		context = new ClassPathXmlApplicationContext("beans.xml");
	}

	@Override
	public Coche mapRow(ResultSet rs, int rowNum) throws SQLException {
		Coche coche = context.getBean("coche", Coche.class);
		coche.setId(rs.getInt("id"));
		coche.setMatricula(rs.getString("matricula"));
		coche.setMarca(rs.getString("marca"));
		coche.setModelo(rs.getString("modelo"));
		coche.setKilometraje(rs.getInt("kilometraje"));
		return coche;
	}

}
