package ar.com.ua.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pais")
public class Pais {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "cod_pais")
	private String codigo;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_secuenciador", referencedColumnName = "id")
	private Secuenciador secuenciador;
	
	@Column(name = "activo")
	private boolean activo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Secuenciador getSecuenciador() {
		return secuenciador;
	}

	public void setSecuenciador(Secuenciador codigoSecuenciador) {
		this.secuenciador = codigoSecuenciador;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
}
