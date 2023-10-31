package ar.com.ua.model;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "empleados")
public class Empleado {

	@Id
	@Column(name = "nro_legajo", unique = true, nullable = false)
	private String numeroLegajo;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido")
	private String apellido;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cod_tipo_doc", referencedColumnName = "cod_parametro")
	private Parametro codigoTipoDocumento;

	@Column(name = "nro_documento_personal")
	private String numeroDocumentoPersonal;

	@Column(name = "nro_documento_laboral")
	private String numeroDocumentoLaboral;

	@Column(name = "fecha_nacimiento")
	private Date fechaNacimiento;

	@Column(name = "fecha_ingreso")
	private Date fechaIngreso;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cod_pais", referencedColumnName = "cod_parametro")
	private Parametro codigoPais;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cod_oficina", referencedColumnName = "cod_parametro")
	private Parametro codigoOficina;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cod_direccion", referencedColumnName = "cod_parametro")
	private Parametro codigoDireccion;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cod_puesto", referencedColumnName = "cod_puesto")
	private Puesto codigoPuesto;

	@Column(name = "segundo_nombre")
	private String segundoNombre;

	@Column(name = "nombre_preferido")
	private String nombrePreferido;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cod_generacion", referencedColumnName = "cod_parametro")
	private Parametro codigoGeneracion;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cod_nacionalidad", referencedColumnName = "cod_parametro")
	private Parametro codigoNacionalidad;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cod_genero", referencedColumnName = "cod_parametro")
	private Parametro codigoGenero;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cod_provincia", referencedColumnName = "cod_parametro")
	private Parametro codigoProvincia;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "calle_residencia", referencedColumnName = "cod_parametro")
	private Parametro calleResidencia;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "numero_residencia", referencedColumnName = "cod_parametro")
	private Parametro numeroResidencia;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "departamento_residencia", referencedColumnName = "cod_parametro")
	private Parametro departamentoResidencia;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "piso_residencia", referencedColumnName = "cod_parametro")
	private Parametro pisoResidencia;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "localidad_residencia", referencedColumnName = "cod_parametro")
	private Parametro localidadResidencia;

	@Column(name = "email_personal")
	private String emailPersonal;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "codigo_banco", referencedColumnName = "cod_parametro")
	private Parametro codigoBanco;

	@Column(name = "cbu")
	private String cbu;

	@Column(name = "fecha_ingreso_reconocida")
	private Date fechaIngresoReconocida;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "codigo_tipo_contratacion", referencedColumnName = "cod_parametro")
	private Parametro codigoTipoContratacion;

	@Column(name = "horas_semanales")
	private int horasSemanales;

	@Column(name = "fte")
	private double fte;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cod_frec_liquidacion", referencedColumnName = "cod_parametro")
	private Parametro codigoFrecuenciaLiquidacion;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cod_tipo_empleo", referencedColumnName = "cod_parametro")
	private Parametro codigoTipoEmpleo;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cod_tipo_jornada", referencedColumnName = "cod_parametro")
	private Parametro codigoTipoJornada;

	@Column(name = "email_laboral")
	private String emailLaboral;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cod_categoria_empleado", referencedColumnName = "cod_parametro")
	private Parametro codigoCategoriaEmpleado;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cod_division", referencedColumnName = "cod_parametro")
	private Parametro codigoDivision;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cod_centro_de_costo", referencedColumnName = "cod_parametro")
	private Parametro codigoCentroDeCosto;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cod_prepaga", referencedColumnName = "cod_parametro")
	private Parametro codigoPrepaga;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cod_obra_social", referencedColumnName = "cod_parametro")
	private Parametro codigoObraSocial;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "obra_social_nro_afiliado", referencedColumnName = "cod_parametro")
	private Parametro obraSocialNumeroAfiliado;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cod_plan_prepaga", referencedColumnName = "cod_parametro")
	private Parametro codigoPlanPrepaga;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cod_convenio", referencedColumnName = "cod_parametro")
	private Parametro codigoConvenio;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cod_categoria_convenio", referencedColumnName = "cod_parametro")
	private Parametro codigoCategoriaConvenio;

	@Column(name = "afiliado_sindicato")
	private boolean afiliadoSindicato;

	@Column(name = "fecha_fin_contrado")
	private Date fechaFinContrato;

	@Column(name = "fecha_egreso")
	private Date fechaEgreso;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cod_tipo_egreso", referencedColumnName = "cod_parametro")
	private Parametro codigoTipoEgreso;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cod_estado_empleado", referencedColumnName = "cod_parametro")
	private Parametro codigoEstadoEmpleado;

	@Column(name = "observaciones")
	private String observaciones;

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

	public Parametro getCodigoPais() {
		return codigoPais;
	}

	public void setCodigoPais(Parametro codigoPais) {
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

	public Parametro getCalleResidencia() {
		return calleResidencia;
	}

	public void setCalleResidencia(Parametro calleResidencia) {
		this.calleResidencia = calleResidencia;
	}

	public Parametro getNumeroResidencia() {
		return numeroResidencia;
	}

	public void setNumeroResidencia(Parametro numeroResidencia) {
		this.numeroResidencia = numeroResidencia;
	}

	public Parametro getDepartamentoResidencia() {
		return departamentoResidencia;
	}

	public void setDepartamentoResidencia(Parametro departamentoResidencia) {
		this.departamentoResidencia = departamentoResidencia;
	}

	public Parametro getPisoResidencia() {
		return pisoResidencia;
	}

	public void setPisoResidencia(Parametro pisoResidencia) {
		this.pisoResidencia = pisoResidencia;
	}

	public Parametro getLocalidadResidencia() {
		return localidadResidencia;
	}

	public void setLocalidadResidencia(Parametro localidadResidencia) {
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

	public Parametro getObraSocialNumeroAfiliado() {
		return obraSocialNumeroAfiliado;
	}

	public void setObraSocialNumeroAfiliado(Parametro obraSocialNumeroAfiliado) {
		this.obraSocialNumeroAfiliado = obraSocialNumeroAfiliado;
	}

	public Parametro getCodigoPlanPrepaga() {
		return codigoPlanPrepaga;
	}

	public void setCodigoPlanPrepaga(Parametro codigoPlanPrepaga) {
		this.codigoPlanPrepaga = codigoPlanPrepaga;
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

}
