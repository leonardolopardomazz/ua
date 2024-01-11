package ar.com.ua.dto.report;

import java.util.List;

public class VueltaAlColegioDTO {

	private List<String> pais;
	private String estadoEmpleado;

	public List<String> getPais() {
		return pais;
	}

	public void setPais(List<String> pais) {
		this.pais = pais;
	}

	public String getEstadoEmpleado() {
		return estadoEmpleado;
	}

	public void setEstadoEmpleado(String estadoEmpleado) {
		this.estadoEmpleado = estadoEmpleado;
	}
}
