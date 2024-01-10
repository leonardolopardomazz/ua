package ar.com.ua.dto.report;

public class HistorialLaboralDTO {

	private String idPais;
	private String idDireccion;
	private String estado;
	private String fechaIngresoDesde;
	private String fechaIngresoHasta;

	public String getIdPais() {
		return idPais;
	}

	public void setIdPais(String idPais) {
		this.idPais = idPais;
	}

	public String getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(String idDireccion) {
		this.idDireccion = idDireccion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFechaIngresoDesde() {
		return fechaIngresoDesde;
	}

	public void setFechaIngresoDesde(String fechaIngresoDesde) {
		this.fechaIngresoDesde = fechaIngresoDesde;
	}

	public String getFechaIngresoHasta() {
		return fechaIngresoHasta;
	}

	public void setFechaIngresoHasta(String fechaIngresoHasta) {
		this.fechaIngresoHasta = fechaIngresoHasta;
	}

}
