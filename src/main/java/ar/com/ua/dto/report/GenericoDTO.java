package ar.com.ua.dto.report;

import java.util.List;

public class GenericoDTO {

	private List<String> estadoEmpleado;
	private String idDireccion;
	private String idGerencia;

	public List<String> getEstadoEmpleado() {
		return estadoEmpleado;
	}

	public void setEstadoEmpleado(List<String> estadoEmpleado) {
		this.estadoEmpleado = estadoEmpleado;
	}

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

}
