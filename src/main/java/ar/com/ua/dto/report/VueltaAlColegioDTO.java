package ar.com.ua.dto.report;

import java.util.List;

public class VueltaAlColegioDTO {
	
	private List<String> pais;
	private String numeroLegajo;
	private String apellido;
	private Long codigoPais;
	private Long codigoDireccion;
	private Long codigoPuesto;
	
	public List<String> getPais() {
		return pais;
	}
	public void setPais(List<String> pais) {
		this.pais = pais;
	}
	public String getNumeroLegajo() {
		return numeroLegajo;
	}
	public void setNumeroLegajo(String numeroLegajo) {
		this.numeroLegajo = numeroLegajo;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Long getCodigoPais() {
		return codigoPais;
	}
	public void setCodigoPais(Long codigoPais) {
		this.codigoPais = codigoPais;
	}
	public Long getCodigoDireccion() {
		return codigoDireccion;
	}
	public void setCodigoDireccion(Long codigoDireccion) {
		this.codigoDireccion = codigoDireccion;
	}
	public Long getCodigoPuesto() {
		return codigoPuesto;
	}
	public void setCodigoPuesto(Long codigoPuesto) {
		this.codigoPuesto = codigoPuesto;
	}
	
	
	
	/*
	Permitir seleccionar país (selección múltiple, default ARG)
	Filtrar por: 
	Tabla Empleado: estado empleado=activo; Cód_país = selección
	Recuperar datos de la tabla “Cargas de familia” para Estado_Activo = verdadero y filtros de la tabla empleado
	El reporte estará ordenado por país y nro. de legajo; y estará compuesto por los siguientes campos:
	Número de legajo del empleado 
	Apellido del empleado
	Nombre del empleado
	Cantidad de hijos: se obtendrá contando para cada empleado, de la tabla “Cargas de familia”, la cantidad de veces que el “Tipo de familiar” sea “Hijo” y Edad < 18 años (Edad= hoy – fecha de nacimiento)
	Edad: mostrar las edades de todos los hijos hasta 20 años
	
	
	a.ABM Empleados: Filtro por “Nro_Legajo”, “Apellido”, “Cod_País”, “Cod_Dirección”, “Cod_Puesto”, 
	*/
	

}
