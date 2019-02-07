package ejemplo7;

public class Persona {
	private String nombre;
	private int edad;
	
	public Persona() {}
	
	public Persona(String nombre, int edad, double peso) {
		this.nombre = nombre;
		this.edad = edad;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	@Override
	public String toString() {
		return "{\"Persona\": {\"nombre\":\"" + nombre + "\", \"edad\":" + edad + "}}";
	}
	
	// El nombre no es relevante
	public void inicializar() {
		// conexion a bbdd
		System.out.println("Inicializando...");
		this.nombre = "";
		this.edad = 0;
	}
	
	public void destruir() {
		System.out.println("Soy\n" + this + "\ny me destruyo.");
	}
	
}
