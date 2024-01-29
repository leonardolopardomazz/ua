package ar.com.ua.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "secuenciador")
public class Secuenciador extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "cod_secuenciador")
	private String codigo;

	@Column(name = "rango_desde")
	private Long rangoDesde;

	@Column(name = "rango_hasta")
	private Long rangoHasta;

	@Column(name = "secuencia")
	private Long secuencia;

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

	public void setCodigo(String codigoSecuenciador) {
		this.codigo = codigoSecuenciador;
	}

	public Long getRangoDesde() {
		return rangoDesde;
	}

	public void setRangoDesde(Long rangoDesde) {
		this.rangoDesde = rangoDesde;
	}

	public Long getRangoHasta() {
		return rangoHasta;
	}

	public void setRangoHasta(Long rangoHasta) {
		this.rangoHasta = rangoHasta;
	}

	public Long getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(Long secuencia) {
		this.secuencia = secuencia;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
