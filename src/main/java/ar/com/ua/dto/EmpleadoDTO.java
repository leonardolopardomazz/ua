package ar.com.ua.dto;

import java.util.Date;

import ar.com.ua.model.Pais;
import ar.com.ua.model.Parametro;
import ar.com.ua.model.Puesto;

public class EmpleadoDTO {

	private Long id;
	private String numeroLegajo;
	private String nombre;
	private String apellido;
	private Parametro codigoTipoDocumento;
	private String numeroDocumentoPersonal;
	private String numeroDocumentoLaboral;
	private Date fechaNacimiento;
	private Date fechaIngreso;
	private Pais codigoPais;
	private Parametro codigoOficina;
	private Parametro codigoDireccion;
	private Puesto codigoPuesto;
	private String segundoNombre;
	private String nombrePreferido;
	private Parametro codigoGeneracion;
	private Parametro codigoNacionalidad;
	private Parametro codigoGenero;
	private Parametro codigoProvincia;
	private String calleResidencia;
	private String numeroResidencia;
	private String departamentoResidencia;
	private String pisoResidencia;
	private String localidadResidencia;
	private String emailPersonal;
	private Parametro codigoBanco;
	private String cbu;
	private Date fechaIngresoReconocida;
	private Parametro codigoTipoContratacion;
	private int horasSemanales;
	private double fte;
	private Parametro codigoFrecuenciaLiquidacion;
	private Parametro codigoTipoEmpleo;
	private Parametro codigoTipoJornada;
	private String emailLaboral;
	private Parametro codigoCategoriaEmpleado;
	private Parametro codigoDivision;
	private Parametro codigoCentroDeCosto;
	private Parametro codigoPrepaga;
	private Parametro codigoObraSocial;
	private Parametro codigoConvenio;
	private Parametro codigoCategoriaConvenio;
	private boolean afiliadoSindicato;
	private Date fechaFinContrato;
	private Date fechaEgreso;
	private Parametro codigoTipoEgreso;
	private Parametro codigoEstadoEmpleado;
	private String observaciones;
	private Pais codigoPaisResidencia;
	private Parametro codigoEstadoCivil;
	private Parametro codigoGrado;

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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

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

	public String getNumeroDocumentoLaboral() {
		return numeroDocumentoLaboral;
	}

	public void setNumeroDocumentoLaboral(String numeroDocumentoLaboral) {
		this.numeroDocumentoLaboral = numeroDocumentoLaboral;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
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

	public Puesto getCodigoPuesto() {
		return codigoPuesto;
	}

	public void setCodigoPuesto(Puesto codigoPuesto) {
		this.codigoPuesto = codigoPuesto;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getNombrePreferido() {
		return nombrePreferido;
	}

	public void setNombrePreferido(String nombrePreferido) {
		this.nombrePreferido = nombrePreferido;
	}

	public Parametro getCodigoGeneracion() {
		return codigoGeneracion;
	}

	public void setCodigoGeneracion(Parametro codigoGeneracion) {
		this.codigoGeneracion = codigoGeneracion;
	}

	public Parametro getCodigoNacionalidad() {
		return codigoNacionalidad;
	}

	public void setCodigoNacionalidad(Parametro codigoNacionalidad) {
		this.codigoNacionalidad = codigoNacionalidad;
	}

	public Parametro getCodigoGenero() {
		return codigoGenero;
	}

	public void setCodigoGenero(Parametro codigoGenero) {
		this.codigoGenero = codigoGenero;
	}

	public Parametro getCodigoProvincia() {
		return codigoProvincia;
	}

	public void setCodigoProvincia(Parametro codigoProvincia) {
		this.codigoProvincia = codigoProvincia;
	}

	public String getCalleResidencia() {
		return calleResidencia;
	}

	public void setCalleResidencia(String calleResidencia) {
		this.calleResidencia = calleResidencia;
	}

	public String getNumeroResidencia() {
		return numeroResidencia;
	}

	public void setNumeroResidencia(String numeroResidencia) {
		this.numeroResidencia = numeroResidencia;
	}

	public String getDepartamentoResidencia() {
		return departamentoResidencia;
	}

	public void setDepartamentoResidencia(String departamentoResidencia) {
		this.departamentoResidencia = departamentoResidencia;
	}

	public String getPisoResidencia() {
		return pisoResidencia;
	}

	public void setPisoResidencia(String pisoResidencia) {
		this.pisoResidencia = pisoResidencia;
	}

	public String getLocalidadResidencia() {
		return localidadResidencia;
	}

	public void setLocalidadResidencia(String localidadResidencia) {
		this.localidadResidencia = localidadResidencia;
	}

	public String getEmailPersonal() {
		return emailPersonal;
	}

	public void setEmailPersonal(String emailPersonal) {
		this.emailPersonal = emailPersonal;
	}

	public Parametro getCodigoBanco() {
		return codigoBanco;
	}

	public void setCodigoBanco(Parametro codigoBanco) {
		this.codigoBanco = codigoBanco;
	}

	public String getCbu() {
		return cbu;
	}

	public void setCbu(String cbu) {
		this.cbu = cbu;
	}

	public Date getFechaIngresoReconocida() {
		return fechaIngresoReconocida;
	}

	public void setFechaIngresoReconocida(Date fechaIngresoReconocida) {
		this.fechaIngresoReconocida = fechaIngresoReconocida;
	}

	public Parametro getCodigoTipoContratacion() {
		return codigoTipoContratacion;
	}

	public void setCodigoTipoContratacion(Parametro codigoTipoContratacion) {
		this.codigoTipoContratacion = codigoTipoContratacion;
	}

	public int getHorasSemanales() {
		return horasSemanales;
	}

	public void setHorasSemanales(int horasSemanales) {
		this.horasSemanales = horasSemanales;
	}

	public double getFte() {
		return fte;
	}

	public void setFte(double fte) {
		this.fte = fte;
	}

	public Parametro getCodigoFrecuenciaLiquidacion() {
		return codigoFrecuenciaLiquidacion;
	}

	public void setCodigoFrecuenciaLiquidacion(Parametro codigoFrecuenciaLiquidacion) {
		this.codigoFrecuenciaLiquidacion = codigoFrecuenciaLiquidacion;
	}

	public Parametro getCodigoTipoEmpleo() {
		return codigoTipoEmpleo;
	}

	public void setCodigoTipoEmpleo(Parametro codigoTipoEmpleo) {
		this.codigoTipoEmpleo = codigoTipoEmpleo;
	}

	public Parametro getCodigoTipoJornada() {
		return codigoTipoJornada;
	}

	public void setCodigoTipoJornada(Parametro codigoTipoJornada) {
		this.codigoTipoJornada = codigoTipoJornada;
	}

	public String getEmailLaboral() {
		return emailLaboral;
	}

	public void setEmailLaboral(String emailLaboral) {
		this.emailLaboral = emailLaboral;
	}

	public Parametro getCodigoCategoriaEmpleado() {
		return codigoCategoriaEmpleado;
	}

	public void setCodigoCategoriaEmpleado(Parametro codigoCategoriaEmpleado) {
		this.codigoCategoriaEmpleado = codigoCategoriaEmpleado;
	}

	public Parametro getCodigoDivision() {
		return codigoDivision;
	}

	public void setCodigoDivision(Parametro codigoDivision) {
		this.codigoDivision = codigoDivision;
	}

	public Parametro getCodigoCentroDeCosto() {
		return codigoCentroDeCosto;
	}

	public void setCodigoCentroDeCosto(Parametro codigoCentroDeCosto) {
		this.codigoCentroDeCosto = codigoCentroDeCosto;
	}

	public Parametro getCodigoPrepaga() {
		return codigoPrepaga;
	}

	public void setCodigoPrepaga(Parametro codigoPrepaga) {
		this.codigoPrepaga = codigoPrepaga;
	}

	public Parametro getCodigoObraSocial() {
		return codigoObraSocial;
	}

	public void setCodigoObraSocial(Parametro codigoObraSocial) {
		this.codigoObraSocial = codigoObraSocial;
	}

	public Parametro getCodigoConvenio() {
		return codigoConvenio;
	}

	public void setCodigoConvenio(Parametro codigoConvenio) {
		this.codigoConvenio = codigoConvenio;
	}

	public Parametro getCodigoCategoriaConvenio() {
		return codigoCategoriaConvenio;
	}

	public void setCodigoCategoriaConvenio(Parametro codigoCategoriaConvenio) {
		this.codigoCategoriaConvenio = codigoCategoriaConvenio;
	}

	public boolean isAfiliadoSindicato() {
		return afiliadoSindicato;
	}

	public void setAfiliadoSindicato(boolean afiliadoSindicato) {
		this.afiliadoSindicato = afiliadoSindicato;
	}

	public Date getFechaFinContrato() {
		return fechaFinContrato;
	}

	public void setFechaFinContrato(Date fechaFinContrato) {
		this.fechaFinContrato = fechaFinContrato;
	}

	public Date getFechaEgreso() {
		return fechaEgreso;
	}

	public void setFechaEgreso(Date fechaEgreso) {
		this.fechaEgreso = fechaEgreso;
	}

	public Parametro getCodigoTipoEgreso() {
		return codigoTipoEgreso;
	}

	public void setCodigoTipoEgreso(Parametro codigoTipoEgreso) {
		this.codigoTipoEgreso = codigoTipoEgreso;
	}

	public Parametro getCodigoEstadoEmpleado() {
		return codigoEstadoEmpleado;
	}

	public void setCodigoEstadoEmpleado(Parametro codigoEstadoEmpleado) {
		this.codigoEstadoEmpleado = codigoEstadoEmpleado;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Pais getCodigoPaisResidencia() {
		return codigoPaisResidencia;
	}

	public void setCodigoPaisResidencia(Pais codigoPaisResidencia) {
		this.codigoPaisResidencia = codigoPaisResidencia;
	}

	public Parametro getCodigoEstadoCivil() {
		return codigoEstadoCivil;
	}

	public void setCodigoEstadoCivil(Parametro codigoEstadoCivil) {
		this.codigoEstadoCivil = codigoEstadoCivil;
	}

	public Parametro getCodigoGrado() {
		return codigoGrado;
	}

	public void setCodigoGrado(Parametro codigoGrado) {
		this.codigoGrado = codigoGrado;
	}

}
