package entidades;

public enum MemoriaPrincipal {
	_4GB(30),
	_8GB(60),
	_16GB(100),
	_32GB(200);
	
	private double precio;
	
	private MemoriaPrincipal(double precio) {
		this.precio = precio;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
}
