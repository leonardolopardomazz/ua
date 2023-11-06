package ar.com.ua.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles_usuarios")
public class RolUsuario {

	@Id
	@Column(name = "cod_rol", unique = true, nullable = false)
	private Long codigo;

	@Id
	@Column(name = "id_usuario", unique = true, nullable = false)
	private Long id;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
