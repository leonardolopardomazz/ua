package ar.com.ua.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "login")
public class Login extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	@Column(name = "fecha_ultimo_intento")
	private Date fechaUltimoIntento;

	@Column(name = "fecha_ultimo_cambio_contrasena")
	private Date fechaUltimoCambioContrasena;

	@Column(name = "cantidad_reintentos")
	private int cantidadReintentos;

	@Column(name = "fecha_reseteo_contrasena")
	private Date fechaReseteoContrasena;

	@Column(name = "primer_acceso")
	private boolean primerAcceso;

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

	public Date getFechaUltimoIntento() {
		return fechaUltimoIntento;
	}

	public void setFechaUltimoIntento(Date fechaUltimoIntento) {
		this.fechaUltimoIntento = fechaUltimoIntento;
	}

	public Date getFechaUltimoCambioContrasena() {
		return fechaUltimoCambioContrasena;
	}

	public void setFechaUltimoCambioContrasena(Date fechaUltimoCambioContrasena) {
		this.fechaUltimoCambioContrasena = fechaUltimoCambioContrasena;
	}

	public int getCantidadReintentos() {
		return cantidadReintentos;
	}

	public void setCantidadReintentos(int cantidadReintentos) {
		this.cantidadReintentos = cantidadReintentos;
	}

	public Date getFechaReseteoContrasena() {
		return fechaReseteoContrasena;
	}

	public void setFechaReseteoContrasena(Date fechaReseteoContrasena) {
		this.fechaReseteoContrasena = fechaReseteoContrasena;
	}

	public boolean isPrimerAcceso() {
		return primerAcceso;
	}

	public void setPrimerAcceso(boolean primerAcceso) {
		this.primerAcceso = primerAcceso;
	}

}
