package ar.com.ua.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "puesto")
public class Puesto {

	private String codigoPuesto;
	private String descripcion;
	private Parametro codigoDireccion;
	private Parametro codigoGerencia;
	private Parametro codigoJefatura;
	private Parametro codigoCategoria;
	private Parametro codigoPuestoAlQueReporta;
	private boolean activo;

	public String getCodigoPuesto() {
		return codigoPuesto;
	}

	public void setCodigoPuesto(String codigoPuesto) {
		this.codigoPuesto = codigoPuesto;
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
