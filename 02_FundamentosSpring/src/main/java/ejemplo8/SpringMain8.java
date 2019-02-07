package ejemplo8;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain8 {
	public static ApplicationContext context;
	
	static {
		context = new ClassPathXmlApplicationContext("beans8.xml");
	}
	
	public static void main(String[] args) {
		System.out.println("Contexto cargado");
		
		Persona p1 = context.getBean("persona", Persona.class);
		System.out.println(p1);
	}

}
