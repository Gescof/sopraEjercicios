package ejemplo5;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain5 {
	public static ApplicationContext context;
	
	static {
		context = new ClassPathXmlApplicationContext("beans5.xml");
	}
	
	public static void main(String[] args) {
		System.out.println("Contexto cargado");
		
		List<Persona> listaPersonas = context.getBean("listaPersonas", List.class);
		listaPersonas.forEach(persona->System.out.println(persona.toString()));
	}

}
