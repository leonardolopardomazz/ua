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
@Table(name = "externos")
public class EmpleadoExterno extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nro_legajo", unique = true, nullable = false)
	private String numeroLegajo;

	@Column(name = "apellido")
	private String apellido;

	@Column(name = "nombre")
	private String nombre;

	@OneToOne()
	@JoinColumn(name = "cod_tipo_doc", referencedColumnName = "id")
	private Parametro codigoTipoDocumento;

	@Column(name = "nro_doc")
	private String numeroDocumento;

	@OneToOne()
	@JoinColumn(name = "cod_nacionalidad", referencedColumnName = "id")
	private Parametro codigoNacionalidad;

	@OneToOne()
	@JoinColumn(name = "cod_proveedor", referencedColumnName = "id")
	private Parametro codigoProveedor;

	@OneToOne()
	@JoinColumn(name = "cod_pais", referencedColumnName = "id")
	private Pais codigoPais;

	@OneToOne()
	@JoinColumn(name = "cod_puesto", referencedColumnName = "id")
	private Puesto codigoPuesto;

	@OneToOne()
	@JoinColumn(name = "cod_division", referencedColumnName = "id")
	private Parametro codigoDivision;

	@OneToOne()
	@JoinColumn(name = "cod_direccion", referencedColumnName = "id")
	private Parametro codigoDireccion;

	@OneToOne()
	@JoinColumn(name = "cod_gerencia", referencedColumnName = "id")
	private Parametro codigoGerencia;

	@OneToOne()
	@JoinColumn(name = "cod_jefatura", referencedColumnName = "id")
	private Parametro codigoJefatura;

	@Column(name = "fecha_ingreso")
	private Date fechaIngreso;

	@Column(name = "fecha_egreso")
	private Date fechaEgreso;

	@OneToOne()
	@JoinColumn(name = "cod_genero", referencedColumnName = "id")
	private Parametro codigoGenero;

	@Column(name = "email_personal")
	private String emailPersonal;

	@Column(name = "activo")
	private boolean activo;

	@Column(name = "nro_doc_laboral")
	private String numeroDocumentoLaboral;

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

	public Pais getCodigoPais() {
		return codigoPais;
	}

	public void setCodigoPais(Pais codigoPais) {
		this.codigoPais = codigoPais;
	}

	public Puesto getCodigoPuesto() {
		return codigoPuesto;
	}

	public void setCodigoPuesto(Puesto codigoPuesto) {
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

	public String getNumeroDocumentoLaboral() {
		return numeroDocumentoLaboral;
	}

	public void setNumeroDocumentoLaboral(String numeroDocumentoLaboral) {
		this.numeroDocumentoLaboral = numeroDocumentoLaboral;
	}

}
