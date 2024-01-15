package ar.com.ua.dto.report;

import java.util.List;

public class InternationalDataCollectionDTO {

	private List<String> estado;
	private String tieneFechaEgreso;
	private String fechaIngreso;
	private String fechaEgreso;

	public List<String> getEstado() {
		return estado;
	}

	public void setEstado(List<String> estado) {
		this.estado = estado;
	}

	public String getTieneFechaEgreso() {
		return tieneFechaEgreso;
	}

	public void setTieneFechaEgreso(String tieneFechaEgreso) {
		this.tieneFechaEgreso = tieneFechaEgreso;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getFechaEgreso() {
		return fechaEgreso;
	}

	public void setFechaEgreso(String fechaEgreso) {
		this.fechaEgreso = fechaEgreso;
	}

}
