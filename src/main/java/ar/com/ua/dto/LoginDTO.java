package ar.com.ua.dto;

import java.util.Date;

public class LoginDTO {

	private UsuarioDTO usuario;
	private Date ultimoIntento;
	private Date ultimoCambioContrasena;
	private Date fechaReseteoContrasena;
	private int cantidadReintentos;
	private boolean primerAcceso;

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public Date getUltimoIntento() {
		return ultimoIntento;
	}

	public void setUltimoIntento(Date ultimoIntento) {
		this.ultimoIntento = ultimoIntento;
	}

	public Date getUltimoCambioContrasena() {
		return ultimoCambioContrasena;
	}

	public void setUltimoCambioContrasena(Date ultimoCambioContrasena) {
		this.ultimoCambioContrasena = ultimoCambioContrasena;
	}

	public int getCantidadReintentos() {
		return cantidadReintentos;
	}

	public void setCantidadReintentos(int cantidadReintentos) {
		this.cantidadReintentos = cantidadReintentos;
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

}
