package ar.com.ua.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "empleados")
public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "nro_legajo", unique = true, nullable = false)
	private String numeroLegajo;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido")
	private String apellido;

	@OneToOne()
	@JoinColumn(name = "cod_tipo_doc", referencedColumnName = "id")
	private Parametro codigoTipoDocumento;

	@Column(name = "nro_doc_personal")
	private String numeroDocumentoPersonal;

	@Column(name = "nro_doc_laboral")
	private String numeroDocumentoLaboral;

	@Column(name = "fecha_nacimiento")
	private Date fechaNacimiento;

	@Column(name = "fecha_ingreso")
	private Date fechaIngreso;

	@OneToOne()
	@JoinColumn(name = "cod_pais", referencedColumnName = "id")
	private Pais codigoPais;

	@OneToOne()
	@JoinColumn(name = "cod_oficina", referencedColumnName = "id")
	private Parametro codigoOficina;

	@OneToOne()
	@JoinColumn(name = "cod_direccion", referencedColumnName = "id")
	private Parametro codigoDireccion;

	@OneToOne()
	@JoinColumn(name = "cod_puesto", referencedColumnName = "id")
	private Puesto codigoPuesto;

	@Column(name = "segundo_nombre")
	private String segundoNombre;

	@Column(name = "nombre_preferido")
	private String nombrePreferido;

	@OneToOne()
	@JoinColumn(name = "cod_generacion", referencedColumnName = "id")
	private Parametro codigoGeneracion;

	@OneToOne()
	@JoinColumn(name = "cod_nacionalidad", referencedColumnName = "id")
	private Parametro codigoNacionalidad;

	@OneToOne()
	@JoinColumn(name = "cod_genero", referencedColumnName = "id")
	private Parametro codigoGenero;

	@OneToOne()
	@JoinColumn(name = "cod_provincia", referencedColumnName = "id")
	private Parametro codigoProvincia;

	@Column(name = "calle_residencia")
	private String calleResidencia;

	@Column(name = "numero_residencia")
	private String numeroResidencia;

	@Column(name = "depto_residencia")
	private String departamentoResidencia;

	@Column(name = "piso_residencia")
	private String pisoResidencia;

	@Column(name = "localidad_residencia")
	private String localidadResidencia;

	@Column(name = "email_personal")
	private String emailPersonal;

	@OneToOne()
	@JoinColumn(name = "cod_banco", referencedColumnName = "id")
	private Parametro codigoBanco;

	@Column(name = "cbu")
	private String cbu;

	@Column(name = "fecha_ingreso_reconocida")
	private Date fechaIngresoReconocida;

	@OneToOne()
	@JoinColumn(name = "cod_tipo_contratacion", referencedColumnName = "id")
	private Parametro codigoTipoContratacion;

	@Column(name = "horas_semanales")
	private int horasSemanales;

	@Column(name = "fte")
	private double fte;

	@OneToOne()
	@JoinColumn(name = "cod_frec_liquidacion", referencedColumnName = "id")
	private Parametro codigoFrecuenciaLiquidacion;

	@OneToOne()
	@JoinColumn(name = "cod_tipo_empleo", referencedColumnName = "id")
	private Parametro codigoTipoEmpleo;

	@OneToOne()
	@JoinColumn(name = "cod_tipo_jornada", referencedColumnName = "id")
	private Parametro codigoTipoJornada;

	@Column(name = "email_laboral")
	private String emailLaboral;

	@OneToOne()
	@JoinColumn(name = "cod_categoria_empleado", referencedColumnName = "id")
	private Parametro codigoCategoriaEmpleado;

	@OneToOne()
	@JoinColumn(name = "cod_division", referencedColumnName = "id")
	private Parametro codigoDivision;

	@OneToOne()
	@JoinColumn(name = "cod_centro_de_costo", referencedColumnName = "id")
	private Parametro codigoCentroDeCosto;

	@OneToOne()
	@JoinColumn(name = "cod_prepaga", referencedColumnName = "id")
	private Parametro codigoPrepaga;

	@OneToOne()
	@JoinColumn(name = "cod_obra_social", referencedColumnName = "id")
	private Parametro codigoObraSocial;

	@OneToOne()
	@JoinColumn(name = "cod_convenio", referencedColumnName = "id")
	private Parametro codigoConvenio;

	@OneToOne()
	@JoinColumn(name = "cod_categoria_convenio", referencedColumnName = "id")
	private Parametro codigoCategoriaConvenio;

	@Column(name = "afiliado_sindicato")
	private boolean afiliadoSindicato;

	@Column(name = "fecha_fin_contrato")
	private Date fechaFinContrato;

	@Column(name = "fecha_egreso")
	private Date fechaEgreso;

	@OneToOne()
	@JoinColumn(name = "cod_tipo_egreso", referencedColumnName = "id")
	private Parametro codigoTipoEgreso;

	@OneToOne()
	@JoinColumn(name = "cod_estado_empleado", referencedColumnName = "id")
	private Parametro codigoEstadoEmpleado;

	@Column(name = "observaciones")
	private String observaciones;

	@OneToOne()
	@JoinColumn(name = "cod_pais_residencia", referencedColumnName = "id")
	private Pais codigoPaisResidencia;

	@OneToOne()
	@JoinColumn(name = "cod_estado_civil", referencedColumnName = "id")
	private Parametro codigoEstadoCivil;

	@OneToOne()
	@JoinColumn(name = "cod_grado", referencedColumnName = "id")
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
