package ar.com.ua.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Rol {

	@Id
	@Column(name = "cod_rol", unique = true, nullable = false)
	private Integer codigo;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "activo")
	private boolean activo;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "roles_permisos", joinColumns = { @JoinColumn(name = "cod_permiso") }, inverseJoinColumns = {
			@JoinColumn(name = "cod_rol") })
	private List<Permiso> permisos;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "roles_usuarios", joinColumns = { @JoinColumn(name = "id_usuario") }, inverseJoinColumns = {
			@JoinColumn(name = "cod_rol") })
	private List<Usuario> usuarios;

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

	protected List<Permiso> getPermisos() {
		return permisos;
	}

	protected void setPermisos(List<Permiso> permisos) {
		this.permisos = permisos;
	}

	protected List<Usuario> getUsuarios() {
		return usuarios;
	}

	protected void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
