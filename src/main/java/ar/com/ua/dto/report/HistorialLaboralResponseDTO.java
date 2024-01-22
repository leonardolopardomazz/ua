package ar.com.ua.dto.report;

public class HistorialLaboralResponseDTO {

	private String numeroLegajo;
	private String apellido;
	private String nombre;
	private String puesto;
	private String fechaIngresoReconocida;
	private String fechaEgreso;
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

	public String getFechaIngresoReconocida() {
		return fechaIngresoReconocida;
	}

	public void setFechaIngresoReconocida(String fechaIngresoReconocida) {
		this.fechaIngresoReconocida = fechaIngresoReconocida;
	}

	public String getFechaEgreso() {
		return fechaEgreso;
	}

	public void setFechaEgreso(String fechaEgreso) {
		this.fechaEgreso = fechaEgreso;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
