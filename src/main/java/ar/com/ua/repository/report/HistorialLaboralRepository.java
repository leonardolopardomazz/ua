package ar.com.ua.repository.report;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.com.ua.model.Empleado;

@Repository
@Transactional(readOnly = true)
public interface HistorialLaboralRepository extends JpaRepository<Empleado, Long>  {
	
	/*
	 * Permitir seleccionar País (selección múltiple, default ARG), 
	 * Dirección (si null seleccionar todos), 
	 * Estado_empleado (selección múltiple: Activo (default), inactivo, baja), 
	 * Fecha_ingreso_desde; Fecha_ingreso_hasta
	 * 
	 * 
Recuperar datos de la tabla “Empleado” para Cod_país = selección (si null seleccionar todos); Cód_dirección = selección, Estado_empleado = selección. Tabla “Parámetros” para tipo_parámetro = 6 (dirección), 12 (gerencia). Tabla “Puesto”. Tabla “Historial Puestos” F_ingreso_reconocida >= Selección desde y <= selección hasta
El reporte estará ordenado por País, Dirección, Gerencia, Centro de costo, Apellido (alfabéticamente) y Fecha_ingreso_reconocida; y estará compuesto por los siguientes campos:

Número de legajo del empleado
Apellido del empleado
Nombre del empleado
Puesto
Fecha desde y hasta de cada puesto: se obtiene de la tabla “Historial de cambios de puesto”
	 */

	@Query(value = "SELECT emp.nro_legajo, emp.apellido, emp.nombre, puesto.descripcion as puesto, "
			+ "hp.fecha_ingreso_reconocida, hp.fecha_egreso "
			+ "FROM empleados emp, parametros param, puesto puesto, historial_de_puestos hp "
			+ "WHERE emp.cod_estado_empleado = :estado OR emp.cod_estado_empleado IS NULL "
			+ "AND emp.cod_direccion = :idDireccion OR emp.cod_direccion IS NULL "
			+ "AND emp.cod_pais = :idPais OR emp.cod_pais IS NULL "
			+ "AND emp.nro_legajo = hp.nro_legajo "
			+ "AND hp.fecha_ingreso_reconocida between :fechaIngresoDesde and :fechaIngresoHasta "
			+ "GROUP BY emp.nro_legajo", nativeQuery = true)
	List<String> reporte(@Param("idPais") String idPais, 
			@Param("idDireccion") String idDireccion, @Param("estado") String estado, @Param("fechaIngresoDesde") String fechaIngresoDesde, 
			@Param("fechaIngresoHasta") String fechaIngresoHasta);

}
