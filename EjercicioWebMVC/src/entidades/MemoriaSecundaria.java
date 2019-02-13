package entidades;

public enum MemoriaSecundaria {
	HDD500(25),
	HDD1000(40),
	HDD2000(60),
	SSD256(60),
	SSD512(90);
	
	private double precio;
	
	private MemoriaSecundaria(double precio) {
		this.precio = precio;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
}
