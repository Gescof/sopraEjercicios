package presentacion;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import modelo.entidades.Coche;
import modelo.entidades.comparadores.CompararPorKm;
import modelo.entidades.comparadores.CompararPorMarca;
import modelo.negocio.GestorCoches;

public class VistaCoches {
	private static ApplicationContext context;
	private static GestorCoches gestorCoches;
	private static final Scanner sc = new Scanner(System.in);
	
	static {
		context = new ClassPathXmlApplicationContext("beans.xml");
		gestorCoches = context.getBean("gestorCoches", GestorCoches.class);
	}
	
	public static void main(String[] args) {
		String opcionStr;
		do {
			mostrarMenu();
			opcionStr = sc.nextLine();
			switch (opcionStr) {
			case "1":
				introducirCoche();
				break;
			case "2":
				listarCoches();
				break;
			case "3":
				getOrdenadaPorMatr();
				break;
			case "4":
				getOrdenadaPorKm();
				break;
			case "5":
				getOrdenadaPorMarca();
				break;
			case "0":
				System.out.println("Fin del programa.");
				break;
			default:
				System.out.println("Entrada no valida.");
			}	
		} while(!opcionStr.equals("0"));
		sc.close();
	}
	
	private static void mostrarMenu() {
		System.out.println("\nSeleccione una opcion...");
		System.out.println("1. Introducir coche.");
		System.out.println("2. Mostrar lista de coches introducidos.");
		System.out.println("3. Ordenar lista de coches por matricula.");
		System.out.println("4. Ordenar lista de coches por kilometraje.");
		System.out.println("5. Ordenar lista de coches por marca.");
		System.out.println("0. Salir.");
	}
	
	private static void introducirCoche() {
		Coche coche = context.getBean("coche", Coche.class);
		
		System.out.println("Especifique la matricula (7 caracteres): ");
		String matricula = sc.nextLine();
		coche.setMatricula(matricula);
		
		System.out.println("Especifique la marca: ");
		String marca = sc.nextLine();
		coche.setMarca(marca);
		
		System.out.println("Especifique el modelo: ");
		String modelo = sc.nextLine();
		coche.setModelo(modelo);
		
		System.out.println("Especifique el kilometraje (numero entero): ");
		String kmStr = sc.nextLine();
		int kilometraje = Integer.parseInt(kmStr);
		coche.setKilometraje(kilometraje);
		
		GestorCoches gestorCoches = context.getBean("gestorCoches", GestorCoches.class);
		if(gestorCoches.insertar(coche)) {
			System.out.println("Coche insertado.");
		} else {
			System.out.println("No se ha podido insertar el coche.");
		}
	}
	
	private static void listarCoches() {
		List<Coche> listaCoches = gestorCoches.getDAOCoche().getListaCoches();
		if(listaCoches.isEmpty()) {
			System.out.println("Lista de coches vacia.");
		} else {
			listaCoches.forEach(cocheAux->System.out.println(cocheAux));
		}
	}
	
	private static void getOrdenadaPorMatr() {
		if(gestorCoches.getDAOCoche().getListaCoches().isEmpty()) {
			System.out.println("Lista de coches vacia.");
		} else {
			System.out.println("Lista ordenada por matricula:");
			gestorCoches.ordenarCoches(null).forEach(coche->System.out.println(coche));
		}
	}
	
	private static void getOrdenadaPorKm() {
		if(gestorCoches.getDAOCoche().getListaCoches().isEmpty()) {
			System.out.println("Lista de coches vacia.");
		} else {
			System.out.println("Lista ordenada por kilometraje:");
			gestorCoches.ordenarCoches(context.getBean("comparadorKms", CompararPorKm.class)).forEach(coche->System.out.println(coche));
		}
	}
	
	private static void getOrdenadaPorMarca() {
		if(gestorCoches.getDAOCoche().getListaCoches().isEmpty()) {
			System.out.println("Lista de coches vacia.");
		} else {
			System.out.println("Lista ordenada por marca:");
			gestorCoches.ordenarCoches(context.getBean("comparadorMarcas", CompararPorMarca.class)).forEach(coche->System.out.println(coche));
		}
	}
	
}
