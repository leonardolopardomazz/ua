package ar.com.ua.dto;

import java.util.Date;
import java.util.List;

public class LoginResponseDTO {

	private String nombreUsuario;
	private Long idUsuario;
	private boolean bloqueado;
	private int cantidadReintentos;
	private Date fechaUltimoIntento;
	private boolean primerAcceso;
	private Date fechaReseteoContrasena;
	private boolean pudoAcceder;
	private List<String> roles;
	private List<String> permisos;

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public boolean isBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

	public int getCantidadReintentos() {
		return cantidadReintentos;
	}

	public void setCantidadReintentos(int cantidadReintentos) {
		this.cantidadReintentos = cantidadReintentos;
	}

	public Date getFechaUltimoIntento() {
		return fechaUltimoIntento;
	}

	public void setFechaUltimoIntento(Date fechaUltimoIntento) {
		this.fechaUltimoIntento = fechaUltimoIntento;
	}

	public boolean isPrimerAcceso() {
		return primerAcceso;
	}

	public void setPrimerAcceso(boolean primerAcceso) {
		this.primerAcceso = primerAcceso;
	}

	public Date getFechaReseteoContrasena() {
		return fechaReseteoContrasena;
	}

	public void setFechaReseteoContrasena(Date fechaReseteoContrasena) {
		this.fechaReseteoContrasena = fechaReseteoContrasena;
	}

	public boolean isPudoAcceder() {
		return pudoAcceder;
	}

	public void setPudoAcceder(boolean pudoAcceder) {
		this.pudoAcceder = pudoAcceder;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public List<String> getPermisos() {
		return permisos;
	}

	public void setPermisos(List<String> permisos) {
		this.permisos = permisos;
	}

}
