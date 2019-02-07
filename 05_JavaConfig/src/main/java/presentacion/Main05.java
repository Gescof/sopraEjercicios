package presentacion;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.Configuracion;
import modelo.entidades.Director;
import modelo.entidades.Pelicula;

public class Main05 {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Configuracion.class);
		
		Pelicula peli = context.getBean("pelicula", Pelicula.class);
		System.out.println(peli);
		
		Director dir = context.getBean("director", Director.class);
		System.out.println(dir);
		
		
	}
}
