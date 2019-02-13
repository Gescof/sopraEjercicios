package entidades;

public enum Procesador {
	INTELI3(250),
	INTELI5(350),
	INTELI7(500),
	AMDRYZEN3(150),
	AMDRYZEN5(250),
	AMDRYZEN7(350);
	
	private double precio;
	
	private Procesador(double precio) {
		this.precio = precio;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
}
