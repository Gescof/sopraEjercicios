package modelo.entidades;

public enum TamanioPizza {
	PEQUENIA(5),
	MEDIANA(10),
	GRANDE(15);
	private int precio;

	private TamanioPizza(int precio) {
		this.precio = precio;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
}
