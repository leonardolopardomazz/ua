package ar.com.ua.dto;

import java.util.Date;

public class SeguridadContrasenaDTO {

	private Long id;
	private String patron;
	private Date fechaValidezInicio;
	private Date fechaValidezFin;
	private String regla;
	private boolean activo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPatron() {
		return patron;
	}

	public void setPatron(String patron) {
		this.patron = patron;
	}

	public Date getFechaValidezInicio() {
		return fechaValidezInicio;
	}

	public void setFechaValidezInicio(Date fechaValidezInicio) {
		this.fechaValidezInicio = fechaValidezInicio;
	}

	public Date getFechaValidezFin() {
		return fechaValidezFin;
	}

	public void setFechaValidezFin(Date fechaValidezFin) {
		this.fechaValidezFin = fechaValidezFin;
	}

	public String getRegla() {
		return regla;
	}

	public void setRegla(String regla) {
		this.regla = regla;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
