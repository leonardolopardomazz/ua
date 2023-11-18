package ar.com.ua.dto;

public class PuestoDTO {

	private Long id;
	private String codigo;
	private String descripcion;
	private String codigoDireccion;
	private String codigoGerencia;
	private String codigoJefatura;
	private String codigoCategoria;
	private String codigoPuestoAlQueReporta;
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
