package ar.com.ua.dto;

import java.util.Date;

import ar.com.ua.model.Parametro;

public class CargaDeFamiliaDTO {

	private Integer numeroLegajo;
	private String apellido;
	private String nombre;
	private Parametro codigoParentesco;
	private Parametro codigoTipoDocumento;
	private String numeroDocumento;
	private Date fechaNacimiento;
	private boolean activo;

	public Integer getNumeroLegajo() {
		return numeroLegajo;
	}

	public void setNumeroLegajo(Integer numeroLegajo) {
		this.numeroLegajo = numeroLegajo;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Parametro getCodigoParentesco() {
		return codigoParentesco;
	}

	public void setCodigoParentesco(Parametro codigoParentesco) {
		this.codigoParentesco = codigoParentesco;
	}

	public Parametro getCodigoTipoDocumento() {
		return codigoTipoDocumento;
	}

	public void setCodigoTipoDocumento(Parametro codigoTipoDocumento) {
		this.codigoTipoDocumento = codigoTipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
