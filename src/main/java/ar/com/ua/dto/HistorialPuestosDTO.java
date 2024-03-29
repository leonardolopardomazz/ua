package ar.com.ua.dto;

import java.util.Date;

import ar.com.ua.model.Pais;
import ar.com.ua.model.Parametro;
import ar.com.ua.model.Puesto;

public class HistorialPuestosDTO {

	private Long id;
	private String numeroLegajo;
	private Pais codigoPais;
	private Parametro codigoOficina;
	private Parametro codigoDireccion;
	private Parametro codigoGerencia;
	private Parametro codigoJefatura;
	private Puesto codigoPuesto;
	private Date fechaInicioPuesto;
	private Date fechaFinPuesto;
	private boolean activo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroLegajo() {
		return numeroLegajo;
	}

	public void setNumeroLegajo(String numeroLegajo) {
		this.numeroLegajo = numeroLegajo;
	}

	public Pais getCodigoPais() {
		return codigoPais;
	}

	public void setCodigoPais(Pais codigoPais) {
		this.codigoPais = codigoPais;
	}

	public Parametro getCodigoOficina() {
		return codigoOficina;
	}

	public void setCodigoOficina(Parametro codigoOficina) {
		this.codigoOficina = codigoOficina;
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

	public Puesto getCodigoPuesto() {
		return codigoPuesto;
	}

	public void setCodigoPuesto(Puesto codigoPuesto) {
		this.codigoPuesto = codigoPuesto;
	}

	public Date getFechaInicioPuesto() {
		return fechaInicioPuesto;
	}

	public void setFechaInicioPuesto(Date fechaInicioPuesto) {
		this.fechaInicioPuesto = fechaInicioPuesto;
	}

	public Date getFechaFinPuesto() {
		return fechaFinPuesto;
	}

	public void setFechaFinPuesto(Date fechaFinPuesto) {
		this.fechaFinPuesto = fechaFinPuesto;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
