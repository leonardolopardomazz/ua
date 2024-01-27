package ar.com.ua.dto.report;

import java.util.List;

public class HistorialLaboralDTO {

	private List<String> pais;
	private String idDireccion;
	private List<String> estado;
	private String fechaDesde;
	private String fechaHasta;

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

	public String getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(String fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public String getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(String fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

}
