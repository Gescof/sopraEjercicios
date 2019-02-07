
public class Direccion {
	private String nombreVia;
	private String tipoVia;
	private String codPostal;
	private String pais;
	
	public Direccion() {}
	
	public Direccion(String nombreVia, String tipoVia, String codPostal, String pais) {
		this.nombreVia = nombreVia;
		this.tipoVia = tipoVia;
		this.codPostal = codPostal;
		this.pais = pais;
	}

	public String getNombreVia() {
		return nombreVia;
	}
	
	public void setNombreVia(String nombreVia) {
		this.nombreVia = nombreVia;
	}
	
	public String getTipoVia() {
		return tipoVia;
	}
	
	public void setTipoVia(String tipoVia) {
		this.tipoVia = tipoVia;
	}
	
	public String getCodPostal() {
		return codPostal;
	}
	
	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}
	
	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "Direccion [nombreVia=" + nombreVia + ", tipoVia=" + tipoVia + ", codPostal=" + codPostal + "]";
	}
	
	
	
}
