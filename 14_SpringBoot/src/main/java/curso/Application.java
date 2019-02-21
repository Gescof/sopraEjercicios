package curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

import curso.modelo.entidades.Pelicula;
import curso.modelo.negocio.GestorPeliculas;

/**
 * 
 * @SpringBootApplication engloba 3 anotaciones:
 * 1- @Configuration, decimos que esta clase va a tener Beans
 * de configuracion.
 * 
 * 2- @ComponentScan, busca anotaciones de Spring. En concreto,
 * anotaciones @Component, en todos los paquetes dentro
 * de "curso".
 * 
 * 3- @EnableAutoConfiguration, decimos a Spring que arranque
 * la aplicacion añadiendo beans basados en la configuracion
 * del classpath. Ademas, añadimos otros beans y varias
 * propiedades para que se autoconfigure el proyecto.
 * 
 */
@SpringBootApplication
@ImportResource({"classpath:beans.xml"})
public class Application {
	
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		
		Pelicula p1 = context.getBean("pelicula", Pelicula.class);
		Pelicula p2 = context.getBean("peliculaSingleton", Pelicula.class);
		
		GestorPeliculas gPeliculas = context.getBean("gestorPeliculas", GestorPeliculas.class);
		p1.setTitulo("Star Wars");
		p1.setDirector("George");
		p1.setGenero("Sci-Fi");
		p1.setYear(2019);
		gPeliculas.insertar(p1);
		p2.setTitulo("Superlopez");
		p2.setDirector("Alejandro");
		p2.setGenero("comedia");
		p2.setYear(2018);
		gPeliculas.insertar(p2);
		
		gPeliculas.listar().forEach(pelicula->System.out.println(pelicula));
	}

}
