package ar.com.ua.dto;

import java.util.Date;

public class LoginResponseDTO {

	private String nombreUsuario;
	private boolean bloqueado;
	private int cantidadReintentos;
	private Date fechaUltimoIntento;
	private boolean primerAcceso;
	private Date fechaReseteoContrasena;

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
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

}
