package presentacion;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import modelo.entidades.Director;
import modelo.entidades.Pelicula;
import modelo.negocio.GestorPeliculas;

public class VistaPeliculas {
	private static ApplicationContext context;
	private static GestorPeliculas gestorPeliculas;
	private static Scanner sc;
	
	static {
		context = new ClassPathXmlApplicationContext("beans.xml");
		gestorPeliculas = context.getBean("gestorPeliculas", GestorPeliculas.class);
		sc = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		String continuar = "y";
		int cont = 0;
		do {
			System.out.println("Rellene campos: (titulo, genero, director): ");
			String titulo = sc.nextLine();
			String genero = sc.nextLine();
			String nombreDirector = sc.nextLine();
			
			Director director = context.getBean("directorBean", Director.class);
			director.setId(++cont);
			director.setNombre(nombreDirector);
			
			Pelicula pelicula = context.getBean("pelicula", Pelicula.class);
			pelicula.setId(cont);
			pelicula.setDirector(director);
			pelicula.setTitulo(titulo);
			pelicula.setGenero(genero);
			
			if(gestorPeliculas.insertar(pelicula)) {
				System.out.println("Pelicula insertada.");
			} else {
				System.out.println("No se ha podido insertar la pelicula. Maximo alcanzado.");
				break;
			}
			System.out.println("¿Desea continuar? (y/n): ");
			continuar = sc.nextLine();
		} while(continuar.equals("y"));
//		List<Pelicula> listaPeliculas = context.getBean("listaPeliculas", List.class);
//		listaPeliculas.forEach(pelicula->System.out.println(pelicula));
		gestorPeliculas.getDaoPelicula().getListaPeliculas().forEach(pelicula->System.out.println(pelicula));
	}
}
