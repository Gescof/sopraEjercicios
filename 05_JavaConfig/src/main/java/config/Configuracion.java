package config;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import modelo.entidades.Director;
import modelo.entidades.Pelicula;
import modelo.negocio.GestorPeliculas;
import modelo.persistencia.DAOPelicula;

// Esta anotacion indica que esta clase va a llevar la
// configuracion de nuestro poryecto de Spring
// como si fuera un beans.xml
@Configuration
public class Configuracion {
	
	@Bean
	@Scope("prototype")
	public Director director() {
		Director director = new Director();
		director.setNombre("George Lucas");
		return director;
	}
	
	// Si no se escribe un identificador, por defecto
	// obtiene el del nombre del metodo
	@Bean("pelicula")
	@Scope("prototype")
	public Pelicula pelicula() {
		Pelicula pelicula = new Pelicula();
		// Todos los beans por defecto que se llamen
		// tendran los valores indicados
		pelicula.setTitulo("Star Wars");
		pelicula.setDirector(director());
		return pelicula;
	}
	
/* De esta forma, el director se inyecta como un autowired
 * de algun "director" que exista en esta clase como byType
	@Bean("pelicula")
	@Scope("prototype")
	public Pelicula pelicula(Director director) {
		Pelicula pelicula = new Pelicula();
		pelicula.setTitulo("Star Wars");
		pelicula.setDirector(director);
		return pelicula;
	}
*/
	
/* De esta forma, el director se inyecta como un autowired
 * de algun "director" que exista en esta clase como byName
	@Bean("pelicula")
	@Scope("prototype")
	public Pelicula pelicula(@Qualifier("director") Director director) {
		Pelicula pelicula = new Pelicula();
		pelicula.setTitulo("Star Wars");
		pelicula.setDirector(director);
		return pelicula;
	}
*/

	@Bean("listaPeliculas")
	@Resource
	public List<Pelicula> getListaPeliculas() {
		return new ArrayList<Pelicula>();
	}
	
	// Funciona byType
	@Bean("daoPelicula")
	public DAOPelicula getDaoPelicula(List<Pelicula> listaPeliculas) {
		DAOPelicula daoPelicula = new DAOPelicula();
		daoPelicula.setListaPeliculas(listaPeliculas);
		daoPelicula.setMaximoPeliculas(4);
		return daoPelicula;
	}
	
	// Funciona byType
	@Bean("gestorPeliculas")
	public GestorPeliculas getGestorPeliculas(DAOPelicula daoPelicula) {
		GestorPeliculas gp = new GestorPeliculas();
		gp.setDaoPelicula(daoPelicula);
		return gp;
	}
	
}
