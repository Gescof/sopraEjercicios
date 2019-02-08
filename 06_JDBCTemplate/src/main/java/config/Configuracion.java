package config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import modelo.entidades.Pelicula;

@Configuration
@ComponentScan(basePackages={"modelo"})
public class Configuracion {

	@Bean("dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		// Hay que pasar a la fuente de datos 
		// la configuracion para conectarse con la BBDD.
		// En este caso, a MySQL 8.
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/cursospring_esquema?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}
	
	@Bean("jdbcTemplate")
	public JdbcTemplate getTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	
	@Bean("pelicula")
	@Scope("prototype")
	public Pelicula getPelicula() {
		return new Pelicula();
	}

}
