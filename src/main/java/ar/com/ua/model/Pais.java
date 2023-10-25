package ar.com.ua.model;

public class Pais {
	
	private Integer codigo;
	private String descripcion;
	private String codigoSecuenciador;
	private boolean activo;
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getCodigoSecuenciador() {
		return codigoSecuenciador;
	}
	public void setCodigoSecuenciador(String codigoSecuenciador) {
		this.codigoSecuenciador = codigoSecuenciador;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
}
