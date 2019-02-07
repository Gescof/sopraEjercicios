package ejemplo3;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain3 {
	public static ApplicationContext context;
	
	static {
		context = new ClassPathXmlApplicationContext("beans3.xml");
	}

	public static void main(String[] args) {
		System.out.println("Contexto cargado");
		
		Persona paco = context.getBean("director", Persona.class);
		System.out.println(paco.getNombre());
		
		Persona p1 = context.getBean("personaBean", Persona.class);
		Persona p2 = context.getBean("personaBean", Persona.class);
		Persona p3 = context.getBean("personaBean", Persona.class);
		
		List<Persona> listaPersonas = context.getBean("listaPersonas", List.class);
		
		listaPersonas.add(p1);
		listaPersonas.add(p2);
		listaPersonas.add(p3);
		
		mostrarLista();
		
	}
	
	private static void mostrarLista() {
		List<Persona> listaPersonas = context.getBean("listaPersonas", List.class);
		listaPersonas.forEach(persona->System.out.println(persona.toString()));
	}

}
