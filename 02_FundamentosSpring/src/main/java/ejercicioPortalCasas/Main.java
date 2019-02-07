package ejercicioPortalCasas;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static ApplicationContext context;
	
	static {
		context = new ClassPathXmlApplicationContext("beansEjercicio.xml");
	}
	
	public static void main(String[] args) {
		System.out.println("Contexto cargado");
		
		Casa casaGrande = context.getBean("casaGrande", Casa.class);
		System.out.println(casaGrande.toString());
	}

}
