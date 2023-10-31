package ar.com.ua.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "nombre_usuario")
	private String nombreUsuario;

	@Column(name = "fecha_alta")
	private Date fechaAlta;

	@Column(name = "fecha_baja")
	private Date fechaBaja;

	@Column(name = "activo")
	private boolean activo;

	@ManyToMany(mappedBy = "usuarios")
	private List<Rol> roles;

	protected Integer getId() {
		return id;
	}

	protected void setId(Integer id) {
		this.id = id;
	}

	protected String getNombreUsuario() {
		return nombreUsuario;
	}

	protected void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	protected Date getFechaAlta() {
		return fechaAlta;
	}

	protected void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	protected Date getFechaBaja() {
		return fechaBaja;
	}

	protected void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	protected boolean isActivo() {
		return activo;
	}

	protected void setActivo(boolean activo) {
		this.activo = activo;
	}

	protected List<Rol> getRoles() {
		return roles;
	}

	protected void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

}
