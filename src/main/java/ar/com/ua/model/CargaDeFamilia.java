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
@Table(name = "cargas_de_familia")
public class CargaDeFamilia extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "nro_legajo", unique = true, nullable = false)
	private String numeroLegajo;

	@Column(name = "apellido")
	private String apellido;

	@Column(name = "nombre")
	private String nombre;

	@OneToOne()
	@JoinColumn(name = "cod_parentesco", referencedColumnName = "id")
	private Parametro codigoParentesco;

	@OneToOne()
	@JoinColumn(name = "cod_tipo_doc", referencedColumnName = "id")
	private Parametro codigoTipoDocumento;

	@Column(name = "nro_doc")
	private String numeroDocumento;

	@Column(name = "fecha_nacimiento")
	private Date fechaNacimiento;

	@Column(name = "activo")
	private boolean activo;

	@OneToOne()
	@JoinColumn(name = "id_empleado", referencedColumnName = "id")
	private Empleado empleado;

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

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

}
