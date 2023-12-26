package ar.com.ua.dto;

import java.util.Date;
import java.util.List;

import ar.com.ua.model.Rol;

public class UsuarioDTO {

	private Long id;
	private Long numeroLegajo;
	private String nombreUsuario;
	private Date fechaAlta;
	private Date fechaBaja;
	private boolean activo;
	private List<Rol> roles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumeroLegajo() {
		return numeroLegajo;
	}

	public void setNumeroLegajo(Long numeroLegajo) {
		this.numeroLegajo = numeroLegajo;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

}
