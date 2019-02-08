package modelo.persistencia;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import modelo.entidades.Coche;

public class DAOCocheJdbcTemplate implements DAOCoche {
	private static ApplicationContext context;
	private static JdbcTemplate jdbcTemplate;
	private static DAOCocheRowMapper cocheMapper;
	
	static {
		context = new ClassPathXmlApplicationContext("beans.xml");
		jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
		cocheMapper = context.getBean("cocheMapper", DAOCocheRowMapper.class);
	}

	@Override
	public boolean insertar(Coche coche) {
		boolean result = false;
		jdbcTemplate.execute("SET autocommit = 0");
		String query = "INSERT INTO Coches (matricula, marca, modelo, kilometraje)"
						+ " VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(query,
				coche.getMatricula(),
				coche.getMarca(),
				coche.getModelo(),
				coche.getKilometraje());
		jdbcTemplate.execute("COMMIT");
		result = true;
		return result;
	}

	@SuppressWarnings("finally")
	@Override
	public Coche buscar(Integer id) {
		String query = "SELECT sql_no_cache * FROM Coches WHERE id = ?";
		Coche coche = null;
		try {
			coche = jdbcTemplate.queryForObject(query, cocheMapper, id);
		} catch(EmptyResultDataAccessException e) {}
		finally {
			return coche;
		}
	}
	
	@Override
	public List<Coche> getListaCoches() {
		String query = "SELECT sql_no_cache * FROM Coches";
		List<Coche> listaCoches  = jdbcTemplate.query(query, cocheMapper);
		return listaCoches;
	}

	@Override
	public boolean borrar(Coche coche) {
		boolean result = false;
		jdbcTemplate.execute("SET autocommit = 0");
		String query = "DELETE FROM Coches WHERE id = ?";
		int numFilasMod = jdbcTemplate.update(query, coche.getId());
		if(numFilasMod == 1) {
			jdbcTemplate.execute("COMMIT");
			result = true;
		}
		return result;
	}

	@Override
	public boolean modificar(Coche coche) {
		boolean result = false;
		jdbcTemplate.execute("SET autocommit = 0");
		String query = "UPDATE Coches SET matricula = ?, marca = ?, modelo = ?, kilometraje = ?"
				+ " WHERE id = ?";
		int numFilasMod = jdbcTemplate.update(query,
				coche.getMatricula(),
				coche.getMarca(),
				coche.getModelo(),
				coche.getKilometraje(),
				coche.getId());
		if(numFilasMod == 1) {
			jdbcTemplate.execute("COMMIT");
			result = true;
		}
		return result;
	}

}
