package ar.com.ua.dto.report;

import java.util.List;

public class LicenciasDTO {

	private List<String> estadoEmpleado;
	private String pais;
	private String direccion;
	private List<String> estadoLicencia;

	public List<String> getEstadoEmpleado() {
		return estadoEmpleado;
	}

	public void setEstadoEmpleado(List<String> estadoEmpleado) {
		this.estadoEmpleado = estadoEmpleado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<String> getEstadoLicencia() {
		return estadoLicencia;
	}

	public void setEstadoLicencia(List<String> estadoLicencia) {
		this.estadoLicencia = estadoLicencia;
	}

}
