package ar.com.ua.dto;

import java.util.Date;

import ar.com.ua.model.Usuario;

public class HistoricoContrasenaDTO {

	private Long id;
	private Usuario usuario;
	private String contrasena;
	private Date fechaCambioContrasena;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Date getFechaCambioContrasena() {
		return fechaCambioContrasena;
	}

	public void setFechaCambioContrasena(Date fechaCambioContrasena) {
		this.fechaCambioContrasena = fechaCambioContrasena;
	}

}
