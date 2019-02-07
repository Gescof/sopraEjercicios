
public class Prueba {

	// Bloque estático para inicializar variables o atributos estáticos.
	static {
		Persona p = new Persona();
	}
	
	public static void main(String[] args) {
		getString();
		// Aquí muere el objeto String("guillermo")
		
		int cont = 0;
		
		Object obj = new Object();
		Object obj2 = new Object();
		System.out.println(++cont + " obj.equals(obj2);\n" + obj.equals(obj2));
		obj = obj2;
		System.out.println(++cont + " obj = obj2;\n" + (++cont) + " obj.equals(obj2);\n" + obj.equals(obj2));
		System.out.println(++cont + " obj == obj2;\n" + obj == obj2);
		
		String s1 = "guillermo"; 
		String s2 = "guillermo";
		// La referencia se crea por el contenido.
		
		String s3 = new String("guillermo");
		String s4 = new String("guillermo");
		
		System.out.println(++cont + " s1 == s2;\n" + (s1 == s2));
		System.out.println(++cont + " s3 == s4;\n" + (s3 == s4));
		// Aquí se comparan las referencias.
		
		System.out.println(++cont + " s1.equals(s2);\n" + s1.equals(s2));
		System.out.println(++cont + " s3.equals(s4);\n" + s3.equals(s4));
		// String.equals(String) está sobreescrito 
		// y no compara las referencias, sino el valor.
		
		s1 = "ana";
		System.out.println(++cont + " s1 == s2;\n" + (s1 == s2));
		System.out.println(++cont + " s1.equals(s2);\n" + s1.equals(s2));
		// Al cambiar el valor a s1 se crea una nueva referencia.
		
		Persona p1 = new Persona();
		p1.setNombre("guillermo");
		p1.setEdad(23);
		p1.setPeso(60);
		p1.setApellidos("escolar fernandez");
		
		System.out.println("Edad: " + p1.getEdad());
		System.out.println("Nombre: " + p1.getNombre());
		
		Persona p2 = new Persona("guillermo", "escolar fernandez", 23, 60);
		
		System.out.println(++cont + " p1 == p2;\n" + (p1 == p2));
		System.out.println(++cont + " p1.equals(p2);\n" + p1.equals(p2));
		
		p1 = p2;
		p1.setEdad(25);
		System.out.println(++cont + " p1.getEdad(): " + p1.getEdad());
		System.out.println(++cont + " p2.getEdad(): " + p2.getEdad());
		// Se cambia la referencia de p1, 
		// apuntando al contenido del objeto que también apunta p2.
		
		cambiarEdad(p1);
		// Aquí se crea un nuevo objeto local en el bloque del método.
		System.out.println(++cont + " p1.getEdad(): " + p1.getEdad());
		// Se ha cambiado el valor de p1 porque el objeto se pasa por valor.
		
		int numero = 10;
		cambiarNumero(numero);
		System.out.println(++cont + " numero: " + numero);
		
		int octal = 07051;
		int hexa = 0xA001B;
		int binario = 0b01010;
		
		numero = 10_000_000;
		
		p1.setDireccion(new Direccion("rio corrientes", "calle", "28018", "España"));
		System.out.println("sysout(p1): " + p1);
		
		Direccion d = new Direccion("prueba", "avenida", "01234", "España");
		p1.setDireccion(d);
		p1.getDireccion().setPais("Italia");
		System.out.println(++cont + " d.getPais(): " + d.getPais());
		// Se cambia también el valor del pais del objeto d.
		
		System.out.println(++cont + " numPersonas: " + Persona.numPersonas);
		Persona.incrementarPersonas();
		System.out.println(++cont + " numPersonas: " + Persona.numPersonas);
		// Para acceder a atributos o métodos estático
		// se debe acceder a través de la clase (Persona).
		
		// hola(); 
		// No es posible acceder a este método así, puesto que no es estático.
		Prueba prueba = new Prueba();
		prueba.hola();
		
		final Persona p3 = new Persona("Ana", "Gomez", 29, 67);
		p3.setNombre("Pepa");
		// p3 = new Persona();
		// No es posible puesto que la referencia del objeto p3 es constante.
		
		Persona p4;
		p4 = p3;
		System.out.println(++cont + " p4.getNombre(): " + p4.getNombre());
		
		int[] array = new int[10];
		
		
	}
	
	private void hola() {
		System.out.println("hola");
	}
	
	public static void cambiarEdad(Persona p) {
		p.setEdad(27);
		System.out.println("cambiarEdad(p1); p.setEdad(27): " + p.getEdad());
	}
	
	public static void cambiarNumero(int num) {
		num = 55;
		System.out.println("cambiarNumero(numero); num: " + num);
	}
	
	public static String getString() {
		String s = new String("guillermo");
		return s;
	}
	
//	Tienen el mismo nombre 
//	que el anterior y argumentos.
//	Por tanto, la firma es la misma 
//	(Error compilación).
//	public static void getString() {
//		
//	}

	
	
}
