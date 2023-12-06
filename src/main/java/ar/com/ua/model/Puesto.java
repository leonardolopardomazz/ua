package ar.com.ua.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "puesto")
public class Puesto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@OneToOne()
	@JoinColumn(name = "cod_puesto", referencedColumnName = "id")
	private Parametro codigo;

	@Column(name = "descripcion")
	private String descripcion;

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
	@JoinColumn(name = "cod_categoria", referencedColumnName = "id")
	private Parametro codigoCategoria;

	@OneToOne()
	@JoinColumn(name = "cod_puesto_al_que_reporta", referencedColumnName = "id")
	private Parametro codigoPuestoAlQueReporta;

	@Column(name = "activo", unique = true, nullable = false)
	private boolean activo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Parametro getCodigo() {
		return codigo;
	}

	public void setCodigo(Parametro codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public Parametro getCodigoCategoria() {
		return codigoCategoria;
	}

	public void setCodigoCategoria(Parametro codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}

	public Parametro getCodigoPuestoAlQueReporta() {
		return codigoPuestoAlQueReporta;
	}

	public void setCodigoPuestoAlQueReporta(Parametro codigoPuestoAlQueReporta) {
		this.codigoPuestoAlQueReporta = codigoPuestoAlQueReporta;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
