package ejemplo2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ejemplo1.Mensaje;

public class SpringMain2 {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");
		System.out.println("Contexto cargado");
		
		Imprimible imp = context.getBean("imprimible", Imprimible.class);
		imp.imprimir("Imprimido");
	}

}
