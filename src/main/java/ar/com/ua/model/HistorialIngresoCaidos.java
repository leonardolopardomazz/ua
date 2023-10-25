package ar.com.ua.model;

import java.util.Date;

public class HistorialIngresoCaidos {
	
	private Parametro codigoTipoDocumento;
	private String numeroDocumentoPersonal;
	private String apellido;
	private String nombre;
	private Parametro codigoPuesto;
	private Parametro codigoDireccion;
	private Parametro codigoGerencia;
	private Parametro codigoJefatura;
	private Date fechaNacimiento;
	private Date fechaEgreso;
	private String observaciones;
	private boolean activo;
	
	public Parametro getCodigoTipoDocumento() {
		return codigoTipoDocumento;
	}
	public void setCodigoTipoDocumento(Parametro codigoTipoDocumento) {
		this.codigoTipoDocumento = codigoTipoDocumento;
	}
	public String getNumeroDocumentoPersonal() {
		return numeroDocumentoPersonal;
	}
	public void setNumeroDocumentoPersonal(String numeroDocumentoPersonal) {
		this.numeroDocumentoPersonal = numeroDocumentoPersonal;
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
	public Parametro getCodigoPuesto() {
		return codigoPuesto;
	}
	public void setCodigoPuesto(Parametro codigoPuesto) {
		this.codigoPuesto = codigoPuesto;
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
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Date getFechaEgreso() {
		return fechaEgreso;
	}
	public void setFechaEgreso(Date fechaEgreso) {
		this.fechaEgreso = fechaEgreso;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	

}
