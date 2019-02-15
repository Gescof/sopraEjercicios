package Main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cfg.Configuracion;
import modelo.entidades.Pelicula;
import modelo.negocio.GestorPeliculas;

public class MainJPA {
	
	private static ApplicationContext context;
	private static GestorPeliculas gPeliculas;
	
	static {
		context = new AnnotationConfigApplicationContext(Configuracion.class);
		gPeliculas = context.getBean(GestorPeliculas.class);
	}

	public static void main(String[] args) {
		System.out.println("Inicializando BBDD...");
		Pelicula pelicula = new Pelicula();
		pelicula.setTitulo("Death Note");
		pelicula.setGenero("Animacion");
		pelicula.setDirector("Akira Toriyama");
		pelicula.setYear(1992);
		
//		gPeliculas.insertarPelicula(pelicula);

		System.out.println(gPeliculas.getListaPeliculas());
		
	}

}
