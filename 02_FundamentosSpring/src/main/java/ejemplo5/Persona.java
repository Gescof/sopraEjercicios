package ejemplo5;

public class Persona {
	private String nombre;
	private int edad;
	private double peso;
	private Direccion direccion;
	
	public Persona(String nombre, int edad, double peso, Direccion direccion) {
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
		this.direccion = direccion;
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
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	@Override
	public String toString() {
		return "\n{\"Persona\": {\"nombre\":\"" + nombre + "\", \"edad\":" + edad + ", \"peso\":" + peso + ", \"direccion\":{" + direccion + "}}}";
	}
	
}
