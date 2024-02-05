package ar.com.ua.dto.report;

import java.util.List;

public class DirectoresDTO {

	private String idDireccion;
	private String idGerencia;
	private List<String> estado;
	private String idPais;

	public String getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(String idDireccion) {
		this.idDireccion = idDireccion;
	}

	public String getIdGerencia() {
		return idGerencia;
	}

	public void setIdGerencia(String idGerencia) {
		this.idGerencia = idGerencia;
	}

	public List<String> getEstado() {
		return estado;
	}

	public void setEstado(List<String> estado) {
		this.estado = estado;
	}

	public String getIdPais() {
		return idPais;
	}

	public void setIdPais(String idPais) {
		this.idPais = idPais;
	}

}
