package herencia;

public abstract class Animal {
	protected int id;
	protected String nombre;
	protected int edad;
	protected TipoAlimentacion tipoAlim;
	
	public Animal() {
		super();
	}
	
	public Animal(int id, String nombre, int edad, TipoAlimentacion tipoAlim) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.tipoAlim = tipoAlim;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
	
	public TipoAlimentacion getTipoAlim() {
		return tipoAlim;
	}
	
	public void setTipoAlim(TipoAlimentacion tipoAlim) {
		this.tipoAlim = tipoAlim;
	}
	
	public abstract void comer(Object comida);

}
