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
				buscarCoche();
				break;
			case "3":
				borrarCoche();
				break;
			case "4":
				modificarCoche();
				break;
			case "5":
				listarCoches();
				break;
			case "6":
				getOrdenadaPorMatr();
				break;
			case "7":
				getOrdenadaPorKm();
				break;
			case "8":
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
		System.out.println("2. Buscar coche por ID.");
		System.out.println("3. Borrar coche.");
		System.out.println("4. Modificar coche.");
		System.out.println("5. Mostrar lista de coches introducidos.");
		System.out.println("6. Ordenar lista de coches por matricula.");
		System.out.println("7. Ordenar lista de coches por kilometraje.");
		System.out.println("8. Ordenar lista de coches por marca.");
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
		
		if(gestorCoches.insertar(coche)) {
			System.out.println("Coche insertado.");
		} else {
			System.out.println("No se ha podido insertar el coche.");
		}
	}
	
	private static void buscarCoche() {
		Coche coche = context.getBean("coche", Coche.class);
		System.out.println("Introduzca el ID para buscar el coche: ");
		String idStr = sc.nextLine();
		int id = Integer.parseInt(idStr);
		coche.setId(id);
		Coche cocheResult = gestorCoches.buscarCoche(coche);
		if(cocheResult == null) {
			System.out.println("No se ha encontrado un coche con ese ID.");
		} else {
			System.out.println(gestorCoches.buscarCoche(coche));
		}
	}
	
	private static void borrarCoche() {
		Coche coche = context.getBean("coche", Coche.class);
		System.out.println("Introduzca el ID para borrar el coche: ");
		String idStr = sc.nextLine();
		int id = Integer.parseInt(idStr);
		coche.setId(id);
		if(gestorCoches.borrarCoche(coche)) {
			System.out.println("Coche borrado con exito.");
		} else {
			System.out.println("No se ha podido borrar el coche. No existe un coche con ese ID en la base de datos.");
		}
	}
	
	private static void modificarCoche() {
		System.out.println("Introduzca el ID del coche a modificar: ");
		String idStr = sc.nextLine();
		int id = Integer.parseInt(idStr);
		Coche coche = context.getBean("coche", Coche.class);
		coche.setId(id);
		
		Coche cocheMod = gestorCoches.buscarCoche(coche);
		
		System.out.println("Introduzca la nueva matricula: ");
		String matricula = sc.nextLine();
		cocheMod.setMatricula(matricula);
		
		System.out.println("Introduzca la nueva marca: ");
		String marca = sc.nextLine();
		cocheMod.setMarca(marca);
		
		System.out.println("Introduzca el nuevo modelo: ");
		String modelo = sc.nextLine();
		cocheMod.setModelo(modelo);
		
		System.out.println("Introduzca el nuevo valor de kilometraje: ");
		String kmStr = sc.nextLine();
		int kilometraje = Integer.parseInt(kmStr);
		cocheMod.setKilometraje(kilometraje);
		
		if(gestorCoches.modificarCoche(cocheMod)) {
			System.out.println("Coche modificado con exito.");
		} else {
			System.out.println("No se ha podido modificar el coche. No existe un coche con ese ID en la base de datos.");
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
