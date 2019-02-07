package ejemplo7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain7 {
	public static ApplicationContext context;
	
	static {
		context = new ClassPathXmlApplicationContext("beans7.xml");
	}
	
	public static void main(String[] args) {
		System.out.println("Contexto cargado");
		
		Colecciones colecciones = context.getBean("colecciones", Colecciones.class);
		colecciones.getListaPersonas().forEach(nombre->System.out.println(nombre));
		colecciones.getConjuntoCadenas().forEach(cadena->System.out.println(cadena));
		colecciones.getMapaPersonas().forEach((key, persona)->System.out.println(("{\"" + key + "\":" + persona + "}")));
	}

}
