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
@Table(name = "historial_de_puestos")
public class HistorialPuestos extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "nro_legajo", unique = true, nullable = false)
	private String numeroLegajo;

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
	@JoinColumn(name = "cod_gerencia", referencedColumnName = "id")
	private Parametro codigoGerencia;

	@OneToOne()
	@JoinColumn(name = "cod_jefatura", referencedColumnName = "id")
	private Parametro codigoJefatura;

	@OneToOne()
	@JoinColumn(name = "cod_puesto", referencedColumnName = "id")
	private Puesto codigoPuesto;

	@Column(name = "fecha_inicio_puesto")
	private Date fechaInicioPuesto;

	@Column(name = "fecha_fin_puesto")
	private Date fechaFinPuesto;

	@Column(name = "activo")
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
