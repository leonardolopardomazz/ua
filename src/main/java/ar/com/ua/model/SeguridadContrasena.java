package ar.com.ua.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "seguridad_contrasena")
public class SeguridadContrasena {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "patron")
	private String patron;

	@Column(name = "fecha_validez_inicio")
	private Date fechaValidezInicio;

	@Column(name = "fecha_validez_fin")
	private Date fechaValidezFin;

	@Column(name = "regla")
	private String regla;

	@Column(name = "activo")
	private boolean activo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPatron() {
		return patron;
	}

	public void setPatron(String patron) {
		this.patron = patron;
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
	
	public String getRegla() {
		return regla;
	}

	public void setRegla(String regla) {
		this.regla = regla;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
