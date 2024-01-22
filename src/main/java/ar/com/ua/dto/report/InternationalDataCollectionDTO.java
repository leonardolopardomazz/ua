package ar.com.ua.dto.report;

public class InternationalDataCollectionDTO {

	private String estadoActivo;
	private String estadoInactivo;
	private String estadoBaja;
	private String fechaDesde;
	private String fechaHasta;

	public String getEstadoActivo() {
		return estadoActivo;
	}

	public void setEstadoActivo(String estadoActivo) {
		this.estadoActivo = estadoActivo;
	}

	public String getEstadoInactivo() {
		return estadoInactivo;
	}

	public void setEstadoInactivo(String estadoInactivo) {
		this.estadoInactivo = estadoInactivo;
	}

	public String getEstadoBaja() {
		return estadoBaja;
	}

	public void setEstadoBaja(String estadoBaja) {
		this.estadoBaja = estadoBaja;
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
