package ar.com.ua.dto;

import ar.com.ua.model.Parametro;
import ar.com.ua.model.Puesto;

public class PuestoDTO {

	private Long id;
	private Parametro codigoCentroDeCosto;
	private String descripcion;
	private Parametro codigoDireccion;
	private Parametro codigoGerencia;
	private Parametro codigoJefatura;
	private Parametro codigoCategoria;
	private Puesto codigoPuestoAlQueReporta;
	private boolean activo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Parametro getCodigoCentroDeCosto() {
		return codigoCentroDeCosto;
	}

	public void setCodigoCentroDeCosto(Parametro codigo) {
		this.codigoCentroDeCosto = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Parametro getCodigoDireccion() {
		return codigoDireccion;
	}

	public void setCodigoDireccion(Parametro codigoDireccion) {
		this.codigoDireccion = codigoDireccion;
	}

	public Parametro getCodigoGerencia() {
		return codigoGerencia;
	}

	public void setCodigoGerencia(Parametro codigoGerencia) {
		this.codigoGerencia = codigoGerencia;
	}

	public Parametro getCodigoJefatura() {
		return codigoJefatura;
	}

	public void setCodigoJefatura(Parametro codigoJefatura) {
		this.codigoJefatura = codigoJefatura;
	}

	public Parametro getCodigoCategoria() {
		return codigoCategoria;
	}

	public void setCodigoCategoria(Parametro codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}

	public Puesto getCodigoPuestoAlQueReporta() {
		return codigoPuestoAlQueReporta;
	}

	public void setCodigoPuestoAlQueReporta(Puesto codigoPuestoAlQueReporta) {
		this.codigoPuestoAlQueReporta = codigoPuestoAlQueReporta;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
