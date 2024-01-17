package ar.com.ua.model;

import java.util.Date;
import java.util.List;

import ar.com.ua.dto.UsuarioDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "login")
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@OneToOne()
	@JoinColumn(name = "cod_parentesco", referencedColumnName = "id")
	private Usuario usuario;
	
	@Column(name = "nro_doc")
	private String contrasena;
	private Date ultimaVezLogueado;
	private Date ultimaCambioContrasena;
	private int cantidadReintentos;
	private List<String> historicoContrasena;
	private boolean esBloqueado;

}
