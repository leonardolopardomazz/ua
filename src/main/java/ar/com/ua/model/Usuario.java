package ar.com.ua.model;

import java.util.Date;

public class Usuario {
	
	private String codigoSecuenciador;
	private Date rangoDesde;
	private Date rangoHasta;
	private String secuencia;
	private String estado;
	private boolean activo;
	
	public String getCodigoSecuenciador() {
		return codigoSecuenciador;
	}
	public void setCodigoSecuenciador(String codigoSecuenciador) {
		this.codigoSecuenciador = codigoSecuenciador;
	}
	public Date getRangoDesde() {
		return rangoDesde;
	}
	public void setRangoDesde(Date ragoDesde) {
		this.rangoDesde = ragoDesde;
	}
	public Date getRangoHasta() {
		return rangoHasta;
	}
	public void setRagoHasta(Date ragoHasta) {
		this.rangoHasta = ragoHasta;
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
