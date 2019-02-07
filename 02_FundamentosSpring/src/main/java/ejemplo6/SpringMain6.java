package ejemplo6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain6 {
	public static ApplicationContext context;
	
	static {
		context = new ClassPathXmlApplicationContext("beans6.xml");
	}
	
	public static void main(String[] args) {
		System.out.println("Contexto cargado");
		
		Persona p1 = context.getBean("personaBean", Persona.class);
		System.out.println(p1);
		
		Persona p2 = context.getBean("personaBean", Persona.class);
		System.out.println(p2);
		
		// Para destruir los objetos del contexto, se usa lo siguiente
		AbstractApplicationContext aac = (AbstractApplicationContext) context;
		aac.close();
	}

}
