package ar.com.ua.dto.report;

import java.util.List;

import ar.com.ua.dto.EmpleadoDTO;

public class VueltaAlColegioDTO {
	
	private List<String> pais;
	private EmpleadoDTO empleado;
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
	*/
	

}
