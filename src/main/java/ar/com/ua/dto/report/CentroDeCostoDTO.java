package ar.com.ua.dto.report;

import java.util.List;

public class CentroDeCostoDTO {

	private String idDireccion;
	private String idCentroDeCosto;
	private List<String> estado;

	public String getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(String idDireccion) {
		this.idDireccion = idDireccion;
	}

	public String getIdCentroDeCosto() {
		return idCentroDeCosto;
	}

	public void setIdCentroDeCosto(String idCentroDeCosto) {
		this.idCentroDeCosto = idCentroDeCosto;
	}

	public List<String> getEstado() {
		return estado;
	}

	public void setEstado(List<String> estado) {
		this.estado = estado;
	}

}
