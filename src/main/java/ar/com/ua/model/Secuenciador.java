package ar.com.ua.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "secuenciador")
public class Secuenciador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "cod_secuenciador")
	private String codigo;

	@Column(name = "fecha_rango_desde")
	private Date fechaRangoDesde;

	@Column(name = "fecha_rango_hasta")
	private Date fechaRangoHasta;

	@Column(name = "secuencia")
	private String secuencia;

	@Column(name = "estado")
	private String estado;

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

	public Date getFechaRangoDesde() {
		return fechaRangoDesde;
	}

	public void setFechaRangoDesde(Date fechaRangoDesde) {
		this.fechaRangoDesde = fechaRangoDesde;
	}

	public Date getFechaRangoHasta() {
		return fechaRangoHasta;
	}

	public void setFechaRangoHasta(Date fechaRangoHasta) {
		this.fechaRangoHasta = fechaRangoHasta;
	}

	public String getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(String secuencia) {
		this.secuencia = secuencia;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
