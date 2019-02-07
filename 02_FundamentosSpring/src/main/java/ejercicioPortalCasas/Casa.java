package ejercicioPortalCasas;

import java.util.List;

public class Casa {
	private double precio;
	private Direccion direccion;
	private List<Habitacion> habitaciones;
	private List<Persona> inquilinos;
	private Persona propietario;
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	public List<Habitacion> getHabitaciones() {
		return habitaciones;
	}
	public void setHabitaciones(List<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}
	public List<Persona> getInquilinos() {
		return inquilinos;
	}
	public void setInquilinos(List<Persona> inquilinos) {
		this.inquilinos = inquilinos;
	}
	public Persona getPropietario() {
		return propietario;
	}
	public void setPropietario(Persona propietario) {
		this.propietario = propietario;
	}

	@Override
	public String toString() {
		return "{\"Casa\": {\"precio\":" + precio + ",\n\"direccion\":{" + direccion + "},\n\"habitaciones\":\n" + habitaciones
				+ ",\n\"inquilinos\":\n" + inquilinos + ",\n\"propietario\":\n" + propietario + "}}";
	}
			
}
