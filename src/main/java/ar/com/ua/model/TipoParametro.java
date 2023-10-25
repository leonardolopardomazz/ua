package ar.com.ua.model;

public class TipoParametro {

	private String codigoTipoParametro;
	private String descripcion;
	private boolean activo;

	public String getCodigoTipoParametro() {
		return codigoTipoParametro;
	}

	public void setCodigoTipoParametro(String codigoTipoParametro) {
		this.codigoTipoParametro = codigoTipoParametro;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
