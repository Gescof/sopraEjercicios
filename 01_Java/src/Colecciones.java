import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class Colecciones {
		
	public static void main(String[] args) {
		List<String> arrayStrings = new ArrayList<>();
		arrayStrings.add("guillermo");
		arrayStrings.add("ana");
		arrayStrings.add("marcos");
		
		System.out.println("arrayStrings.get(0): " + arrayStrings.get(0));
		System.out.println("Foreach basico:");
		for(String string : arrayStrings) {
			System.out.println(string);
		}
		System.out.println("Foreach landa:");
		arrayStrings.forEach(string->System.out.println(string));
		
		Vector<String> vector = new Vector<>();
		LinkedList<String> linkedList = new LinkedList<>();
		
		recorrer(arrayStrings);
		recorrer(vector);
		recorrer(linkedList);
		
		Map<Integer, String> mapaPersonas = new HashMap<>();
		mapaPersonas.put(new Integer(0), "pepe");
		mapaPersonas.put(new Integer(1), "Bud spencer");
		mapaPersonas.put(2, "Luis Ramon");
		System.out.println("mapaPersonas.get(1): " + mapaPersonas.get(1));
		
		List<Persona> listaPersonas = new ArrayList<>();
		Persona p = new Persona("Pedro", "el Cruel", 23, 89);
		listaPersonas.add(p);
		
		p = new Persona();
		p.setNombre("ana");
		p.setApellidos("el Cruel");
		p.setEdad(23);
		p.setPeso(89);
		
		listaPersonas.add(p);
		
		System.out.println("listaPersonas.contains(p): " + listaPersonas.contains(p));
		
		for (Persona pAux : listaPersonas) {
			System.out.println(pAux);
		}
		
		// Ordenaciones.
		Collections.sort(arrayStrings);
		Collections.sort(listaPersonas);
		// Hay que implementar la interfaz de ordenación en la clase.
				
		for (Persona pAux : listaPersonas) {
			System.out.println(pAux);
		}
		
		Collections.sort(listaPersonas, new CompararPorNombre());
		
		
		for (Persona pAux : listaPersonas) {
			System.out.println(pAux);
		}
		
	}
	
	public static void recorrer(List<String> lista) {
		for(String string : lista) {
			// Lo que sea.
		}
	}
	
}