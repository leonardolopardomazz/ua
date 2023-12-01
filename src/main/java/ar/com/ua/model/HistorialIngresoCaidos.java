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
@Table(name = "historial_de_ingresos_caidos")
public class HistorialIngresoCaidos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@OneToOne()
	@JoinColumn(name = "cod_tipo_doc", referencedColumnName = "id")
	private Parametro codigoTipoDocumento;
	
	@Column(name = "nro_doc_personal")
	private String numeroDocumentoPersonal;
	
	@Column(name = "apellido")
	private String apellido;
	
	@Column(name = "nombre")
	private String nombre;
	
	@OneToOne()
	@JoinColumn(name = "cod_puesto", referencedColumnName = "id")
	private Parametro codigoPuesto;
	
	@OneToOne()
	@JoinColumn(name = "cod_direccion", referencedColumnName = "id")
	private Parametro codigoDireccion;
	
	@OneToOne()
	@JoinColumn(name = "cod_gerencia", referencedColumnName = "id")
	private Parametro codigoGerencia;
	
	@OneToOne()
	@JoinColumn(name = "cod_jefatura", referencedColumnName = "id")
	private Parametro codigoJefatura;
	
	@Column(name = "fecha_nacimiento")
	private Date fechaNacimiento;
	
	@Column(name = "fecha_egreso")
	private Date fechaEgreso;
	
	@Column(name = "observaciones")
	private String observaciones;

	@Column(name = "activo")
	private boolean activo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
