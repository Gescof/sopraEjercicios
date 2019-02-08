package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.Configuracion;
import modelo.entidades.Pelicula;
import modelo.persistencia.PeliculaDAO;

public class Main {
	private static ApplicationContext context;
	
	static {
		context = new AnnotationConfigApplicationContext(Configuracion.class);
	}

	public static void main(String[] args) {
		PeliculaDAO daoPelicula = context.getBean("daoPelicula", PeliculaDAO.class);

		Pelicula p1 = context.getBean("pelicula", Pelicula.class);
		p1.setTitulo("Star Wars 9");
		p1.setGenero("Ciencia ficcion");
		p1.setDirector("JJ Abrams");
		p1.setYear(2019);
		daoPelicula.insertar(p1);
		
		System.out.println(daoPelicula.buscar("Star Wars 9"));
		
		daoPelicula.borrar(p1);
		
		Pelicula p2 = context.getBean("pelicula", Pelicula.class);
		p2.setTitulo("El Padrino");
		p2.setGenero("Drama");
		p2.setDirector("Francis Ford Copola");
		p2.setYear(1972);
		daoPelicula.insertar(p2);
		
		Pelicula p3 = context.getBean("pelicula", Pelicula.class);
		p3.setTitulo("Avatar");
		p3.setGenero("Ciencia ficcion");
		p3.setDirector("James Cameron");
		p3.setYear(2007);
		daoPelicula.insertar(p3);
		System.out.println(daoPelicula.buscar(p3.getId()));
		
		Pelicula pAux = daoPelicula.buscar("Avatar");
		pAux.setYear(2009);
		daoPelicula.modificar(pAux);
		
		daoPelicula.listarPeliculas().forEach(pelicula->System.out.println(pelicula));
		
	}

}
