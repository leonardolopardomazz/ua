package ar.com.ua.dto;

import ar.com.ua.model.Secuenciador;

public class PaisDTO {

	private Long id;
	private String codigo;
	private String descripcion;
	private Secuenciador secuenciador;
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

	public void setCodigo(String codigoPais) {
		this.codigo = codigoPais;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Secuenciador getSecuenciador() {
		return secuenciador;
	}

	public void setSecuenciador(Secuenciador secuenciador) {
		this.secuenciador = secuenciador;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
