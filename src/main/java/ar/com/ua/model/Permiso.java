package ar.com.ua.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "permisos")
public class Permiso {

	@Id
	@Column(name = "cod_permiso", unique = true, nullable = false)
	private Integer codigo;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "activo")
	private boolean activo;

	@ManyToMany(mappedBy = "permisos")
	private List<Rol> roles;

	protected Integer getCodigo() {
		return codigo;
	}

	protected void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	protected String getDescripcion() {
		return descripcion;
	}

	protected void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
	}}
