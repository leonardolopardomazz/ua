package ar.com.ua.dto.report;

import java.util.List;

public class HistorialLaboralDTO {
	
	private List<String> pais;
	private String idDireccion;
	private List<String> estado;
	private String fechaIngresoDesde;
	private String fechaIngresoHasta;

	public List<String> getPais() {
		return pais;
	}

	public void setPais(List<String> pais) {
		this.pais = pais;
	}

	public String getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(String idDireccion) {
		this.idDireccion = idDireccion;
	}

	public List<String> getEstado() {
		return estado;
	}

	public void setEstado(List<String> estado) {
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
