package ar.com.ua.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "parametros_seguridad_contrasena")
public class ParametrosSeguridadContrasena extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "dias_validez_contrasena", nullable = false)
	private Integer diasValidezContrasena;

	@Column(name = "cantidad_reintentos_validos")
	private Integer cantidadReintentosValidos;

	@Column(name = "fecha_validez_inicio")
	private Date fechaValidezInicio;

	@Column(name = "fecha_validez_fin")
	private Date fechaValidezFin;

	@Column(name = "activo")
	private boolean activo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getDiasValidezContrasena() {
		return diasValidezContrasena;
	}

	public void setDiasValidezContrasena(Integer diasValidezContrasena) {
		this.diasValidezContrasena = diasValidezContrasena;
	}

	public Integer getCantidadReintentosValidos() {
		return cantidadReintentosValidos;
	}

	public void setCantidadReintentosValidos(Integer cantidadReintentosValidos) {
		this.cantidadReintentosValidos = cantidadReintentosValidos;
	}

	public Date getFechaValidezInicio() {
		return fechaValidezInicio;
	}

	public void setFechaValidezInicio(Date fechaValidezInicio) {
		this.fechaValidezInicio = fechaValidezInicio;
	}

	public Date getFechaValidezFin() {
		return fechaValidezFin;
	}

	public void setFechaValidezFin(Date fechaValidezFin) {
		this.fechaValidezFin = fechaValidezFin;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
