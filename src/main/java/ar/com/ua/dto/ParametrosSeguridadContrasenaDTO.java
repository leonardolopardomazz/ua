package ar.com.ua.dto;

public class ParametrosSeguridadContrasenaDTO {

	private Long id;
	private Integer diasValidezContrasena;
	private Integer cantidadReintentos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getDiasValidezContrasena() {
		return diasValidezContrasena;
	}

	public void setDiasValidezContrasena(Integer diasValidezContrasena) {
		this.diasValidezContrasena = diasValidezContrasena;
	}

	public Integer getCantidadReintentos() {
		return cantidadReintentos;
	}

	public void setCantidadReintentos(Integer cantidadReintentos) {
		this.cantidadReintentos = cantidadReintentos;
	}

}
