package ar.com.ua.dto;

public class SecuenciadorDTO {

	private Long id;
	private String codigo;
	private Long rangoDesde;
	private Long rangoHasta;
	private String secuencia;
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

	public Long getRangoDesde() {
		return rangoDesde;
	}

	public void setRangoDesde(Long rangoDesde) {
		this.rangoDesde = rangoDesde;
	}

	public Long getRangoHasta() {
		return rangoHasta;
	}

	public void setRangoHasta(Long rangoHasta) {
		this.rangoHasta = rangoHasta;
	}

	public String getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(String secuencia) {
		this.secuencia = secuencia;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
