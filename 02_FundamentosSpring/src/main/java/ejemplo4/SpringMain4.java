package ejemplo4;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain4 {
	public static ApplicationContext context;
	
	static {
		context = new ClassPathXmlApplicationContext("beans4.xml");
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		System.out.println("Contexto cargado");
		
		Persona paco = context.getBean("director", Persona.class);
		System.out.println(paco.getNombre());
		
		Persona dir = context.getBean("director", Persona.class);
		Persona p2 = context.getBean("personaBean", Persona.class);
		Persona marta = context.getBean("marta", Persona.class);
		
		List<Persona> listaPersonas = context.getBean("listaPersonas", List.class);
		
		listaPersonas.add(dir);
		listaPersonas.add(p2);
		listaPersonas.add(marta);
		
		mostrarLista();
		
	}
	
	@SuppressWarnings("unchecked")
	private static void mostrarLista() {
		List<Persona> listaPersonas = context.getBean("listaPersonas", List.class);
		listaPersonas.forEach(persona->System.out.println(persona.toString()));
	}

}
