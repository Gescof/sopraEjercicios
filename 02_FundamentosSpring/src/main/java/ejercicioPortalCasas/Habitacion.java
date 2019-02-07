package ejercicioPortalCasas;

public class Habitacion {
	private TipoHabitaciones tipoHabitacion;
	private double superficie;
	private boolean tieneVentanas;
	
	public TipoHabitaciones getTipoHabitacion() {
		return tipoHabitacion;
	}
	public void setTipoHabitacion(TipoHabitaciones tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}
	public double getSuperficie() {
		return superficie;
	}
	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}
	public boolean isTieneVentanas() {
		return tieneVentanas;
	}
	public void setTieneVentanas(boolean tieneVentanas) {
		this.tieneVentanas = tieneVentanas;
	}
	
	@Override
	public String toString() {
		return "\n{\"Habitacion\": {\"tipoHabitacion\":\"" + tipoHabitacion + "\", \"superficie\":" + superficie + ", \"tieneVentanas\":"
				+ tieneVentanas + "}}";
	}
		
}
