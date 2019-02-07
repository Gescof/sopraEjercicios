package ejemplo1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain1 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans1.xml");
		System.out.println("Contexto cargado");
		
		Mensaje mensaje = context.getBean("mensajeBean", Mensaje.class);
		System.out.println(mensaje.getCuerpo());
		System.out.println(mensaje.getFirma());
		
	}

}
