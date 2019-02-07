package ejercicioPortalCasas;

public class Direccion {
	private String tipoVia;
	private String nombreVia;
	private String codPostal;
	private String pais;
	
	public String getTipoVia() {
		return tipoVia;
	}
	public void setTipoVia(String tipoVia) {
		this.tipoVia = tipoVia;
	}
	public String getNombreVia() {
		return nombreVia;
	}
	public void setNombreVia(String nombreVia) {
		this.nombreVia = nombreVia;
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
		return "\"Direccion\": {\"tipoVia\":\"" + tipoVia + "\", \"nombreVia\":\"" + nombreVia + "\", \"codPostal\":\"" + codPostal + "\", \"pais\":\""
				+ pais + "\"}";
	}
		
}
