package ar.com.ua.model;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.SQLDelete;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
@SQLDelete(sql = "UPDATE usuarios SET fecha_baja = CURRENT_TIMESTAMP, activo = 0 WHERE id = ?")
public class Usuario extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "nro_legajo")
	private Long numeroLegajo;

	@Column(name = "nombre_usuario", unique = true, nullable = false)
	private String nombreUsuario;

	@Column(name = "contrasena", nullable = false)
	private String contrasena;

	@OneToMany(mappedBy = "usuario")
	private List<HistoricoContrasena> historicoContrasena;

	@OneToMany(mappedBy = "usuario")
	private List<Login> login;

	@Column(name = "fecha_alta")
	private Date fechaAlta;

	@Column(name = "fecha_baja")
	private Date fechaBaja;

	@Column(name = "activo")
	private boolean activo;

	@Column(name = "bloqueado")
	private boolean bloqueado;

	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "roles_usuarios", joinColumns = {
			@JoinColumn(name = "id_usuario", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "cod_rol", referencedColumnName = "cod_rol") })
	private List<Rol> roles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public List<HistoricoContrasena> getHistoricoContrasena() {
		return historicoContrasena;
	}

	public void setHistoricoContrasena(List<HistoricoContrasena> historicoContrasena) {
		this.historicoContrasena = historicoContrasena;
	}

	public List<Login> getLogin() {
		return login;
	}

	public void setLogin(List<Login> login) {
		this.login = login;
	}

	public Long getNumeroLegajo() {
		return numeroLegajo;
	}

	public void setNumeroLegajo(Long numeroLegajo) {
		this.numeroLegajo = numeroLegajo;
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

	public boolean isBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

}
