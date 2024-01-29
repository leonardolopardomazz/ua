package ar.com.ua.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles_permisos")
public class RolPermiso extends Auditable {

	@Id
	@Column(name = "cod_rol", unique = true, nullable = false)
	private Long codigoRol;

	@Id
	@Column(name = "id_permiso", unique = true, nullable = false)
	private Long codigoPermiso;

	public Long getCodigoRol() {
		return codigoRol;
	}

	public void setCodigoRol(Long codigoRol) {
		this.codigoRol = codigoRol;
	}

	public Long getCodigoPermiso() {
		return codigoPermiso;
	}

	public void setCodigoPermiso(Long codigoPermiso) {
		this.codigoPermiso = codigoPermiso;
	}

}
