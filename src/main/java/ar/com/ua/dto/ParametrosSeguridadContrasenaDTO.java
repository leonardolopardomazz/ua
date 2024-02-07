package ar.com.ua.dto;

import java.util.Date;

public class ParametrosSeguridadContrasenaDTO {

	private Long id;
	private Integer diasValidezContrasena;
	private Integer cantidadReintentos;
	private Date fechaValidezInicio;
	private Date fechaValidezFin;
	private boolean activo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getDiasValidezContrasena() {
		return diasValidezContrasena;
	}

	public void setDiasValidezContrasena(Integer diasValidezContrasena) {
		this.diasValidezContrasena = diasValidezContrasena;
	}

	public Integer getCantidadReintentos() {
		return cantidadReintentos;
	}

	public void setCantidadReintentos(Integer cantidadReintentos) {
		this.cantidadReintentos = cantidadReintentos;
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

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	

}
