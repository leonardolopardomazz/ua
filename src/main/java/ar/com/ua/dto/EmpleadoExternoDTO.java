package ar.com.ua.dto;

import java.util.Date;

import ar.com.ua.model.Parametro;

public class EmpleadoExternoDTO {

	private Integer legajoExterno;
	private String apellido;
	private String nombre;
	private Parametro codigoTipoDocumento;
	private String numeroDocumento;
	private Parametro codigoNacionalidad;
	private Parametro codigoProveedor;
	private Parametro codigoPais;
	private Parametro codigoPuesto;
	private Parametro codigoDivision;
	private Parametro codigoDireccion;
	private Parametro codigoGerencia;
	private Parametro codigoJefatura;
	private Date fechaIngreso;
	private Date fechaEgreso;
	private Parametro codigoGenero;
	private String emailPersonal;
	private boolean activo;

	public Integer getLegajoExterno() {
		return legajoExterno;
	}

	public void setLegajoExterno(Integer legajoExterno) {
		this.legajoExterno = legajoExterno;
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

	public Parametro getCodigoNacionalidad() {
		return codigoNacionalidad;
	}

	public void setCodigoNacionalidad(Parametro codigoNacionalidad) {
		this.codigoNacionalidad = codigoNacionalidad;
	}

	public Parametro getCodigoProveedor() {
		return codigoProveedor;
	}

	public void setCodigoProveedor(Parametro codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	public Parametro getCodigoPais() {
		return codigoPais;
	}

	public void setCodigoPais(Parametro codigoPais) {
		this.codigoPais = codigoPais;
	}

	public Parametro getCodigoPuesto() {
		return codigoPuesto;
	}

	public void setCodigoPuesto(Parametro codigoPuesto) {
		this.codigoPuesto = codigoPuesto;
	}

	public Parametro getCodigoDivision() {
		return codigoDivision;
	}

	public void setCodigoDivision(Parametro codigoDivision) {
		this.codigoDivision = codigoDivision;
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

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaEgreso() {
		return fechaEgreso;
	}

	public void setFechaEgreso(Date fechaEgreso) {
		this.fechaEgreso = fechaEgreso;
	}

	public Parametro getCodigoGenero() {
		return codigoGenero;
	}

	public void setCodigoGenero(Parametro codigoGenero) {
		this.codigoGenero = codigoGenero;
	}

	public String getEmailPersonal() {
		return emailPersonal;
	}

	public void setEmailPersonal(String emailPersonal) {
		this.emailPersonal = emailPersonal;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
