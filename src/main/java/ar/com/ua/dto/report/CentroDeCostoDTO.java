package ar.com.ua.dto.report;

public class CentroDeCostoDTO {

	/**
	 * Permitir seleccionar Dirección, Centro de Costo por Dirección, Estado
	 * (selección múltiple: Activo (default), inactivo) Recuperar datos de la tabla
	 * “Empleado” para Cod_Centro_de_costo = selección (si null seleccionar todos);
	 * Estado_empleado = selección. Tabla “Parámetros” para tipo_parámetro = 6
	 * (dirección), 12 (gerencia) y 4 (centro de costo)
	 */

	private String idDireccion;
	private String idCentroDeCosto;
	private String idGerencia;
	private String estado;

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

	public String getIdGerencia() {
		return idGerencia;
	}

	public void setIdGerencia(String idGerencia) {
		this.idGerencia = idGerencia;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
