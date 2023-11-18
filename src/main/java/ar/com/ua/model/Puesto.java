package ar.com.ua.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "puesto")
public class Puesto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "cod_puesto")
	private String codigo;

	@Column(name = "descripcion")
	private String descripcion;

    @Column(name = "cod_direccion")
	private String codigoDireccion;

    @Column(name = "cod_gerencia")
	private String codigoGerencia;

	@Column(name = "cod_jefatura")
	private String codigoJefatura;

	@Column(name = "cod_categoria")
	private String codigoCategoria;

	@Column(name = "cod_puesto_al_que_reporta")
	private String codigoPuestoAlQueReporta;

	@Column(name = "activo", unique = true, nullable = false)
	private boolean activo;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCodigoDireccion() {
		return codigoDireccion;
	}

	public void setCodigoDireccion(String codigoDireccion) {
		this.codigoDireccion = codigoDireccion;
	}

	public String getCodigoGerencia() {
		return codigoGerencia;
	}

	public void setCodigoGerencia(String codigoGerencia) {
		this.codigoGerencia = codigoGerencia;
	}

	public String getCodigoJefatura() {
		return codigoJefatura;
	}

	public void setCodigoJefatura(String codigoJefatura) {
		this.codigoJefatura = codigoJefatura;
	}

	public String getCodigoCategoria() {
		return codigoCategoria;
	}

	public void setCodigoCategoria(String codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}

	public String getCodigoPuestoAlQueReporta() {
		return codigoPuestoAlQueReporta;
	}

	public void setCodigoPuestoAlQueReporta(String codigoPuestoAlQueReporta) {
		this.codigoPuestoAlQueReporta = codigoPuestoAlQueReporta;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
