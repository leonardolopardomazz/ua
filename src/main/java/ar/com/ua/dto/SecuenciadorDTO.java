package ar.com.ua.dto;

import java.util.Date;

public class SecuenciadorDTO {

	private Long id;
	private String codigo;
	private Date fechaRangoDesde;
	private Date fechaRangoHasta;
	private String secuencia;
	private String estado;
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

	public void setCodigo(String codigoSecuenciador) {
		this.codigo = codigoSecuenciador;
	}

	public Date getFechaRangoDesde() {
		return fechaRangoDesde;
	}

	public void setFechaRangoDesde(Date fechaRangoDesde) {
		this.fechaRangoDesde = fechaRangoDesde;
	}

	public Date getFechaRangoHasta() {
		return fechaRangoHasta;
	}

	public void setFechaRangoHasta(Date fechaRangoHasta) {
		this.fechaRangoHasta = fechaRangoHasta;
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
