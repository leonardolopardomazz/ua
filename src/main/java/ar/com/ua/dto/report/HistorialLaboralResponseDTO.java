package ar.com.ua.dto.report;

public class HistorialLaboralResponseDTO {

	private String numeroLegajo;
	private String apellido;
	private String nombre;
	private String puesto;
	private String fechaInicioPuesto;
	private String fechaFinPuesto;
	private String direccion;

	public String getNumeroLegajo() {
		return numeroLegajo;
	}

	public void setNumeroLegajo(String numeroLegajo) {
		this.numeroLegajo = numeroLegajo;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public String getFechaInicioPuesto() {
		return fechaInicioPuesto;
	}

	public void setFechaInicioPuesto(String fechaInicioPuesto) {
		this.fechaInicioPuesto = fechaInicioPuesto;
	}

	public String getFechaFinPuesto() {
		return fechaFinPuesto;
	}

	public void setFechaFinPuesto(String fechaFinPuesto) {
		this.fechaFinPuesto = fechaFinPuesto;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
