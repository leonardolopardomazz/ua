package ar.com.ua.model;

import java.util.Date;

public class Secuenciador {

	private String codigo;
	private Date rangoDesde;
	private Date rangoHasta;
	private String secuencia;
	private String estado;
	private boolean activo;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigoSecuenciador) {
		this.codigo = codigoSecuenciador;
	}

	public Date getRangoDesde() {
		return rangoDesde;
	}

	public void setRangoDesde(Date rangoDesde) {
		this.rangoDesde = rangoDesde;
	}

	public Date getRangoHasta() {
		return rangoHasta;
	}

	public void setRangoHasta(Date rangoHasta) {
		this.rangoHasta = rangoHasta;
	}

	public String getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(String secuencia) {
		this.secuencia = secuencia;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
