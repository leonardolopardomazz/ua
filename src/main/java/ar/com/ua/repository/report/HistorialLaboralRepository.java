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
public interface HistorialLaboralRepository extends JpaRepository<Empleado, Long> {
	/*
	 * @Query(value =
	 * "SELECT emp.nro_legajo, emp.apellido, emp.nombre, puesto.descripcion as puesto, "
	 * + "hp.fecha_ingreso_reconocida, hp.fecha_egreso "
	 * +
	 * "FROM empleados emp, parametros param, puesto puesto, historial_de_puestos hp "
	 * +
	 * "WHERE emp.cod_estado_empleado IN :estado OR emp.cod_estado_empleado IS NULL "
	 * + "AND emp.cod_direccion = :idDireccion OR emp.cod_direccion IS NULL "
	 * + "AND emp.cod_pais IN :idPais OR emp.cod_pais IS NULL "
	 * + "AND emp.nro_legajo = hp.nro_legajo "
	 * +
	 * "AND hp.fecha_ingreso_reconocida between :fechaIngresoDesde and :fechaIngresoHasta OR hp.fecha_ingreso_reconocida IS NOT NULL "
	 * + "GROUP BY emp.nro_legajo", nativeQuery = true)
	 */
	@Query(value = "SELECT nro_legajo, apellido, nombre, puesto, fecha_ingreso_reconocida, fecha_egreso FROM ( "
			+ "SELECT emp.nro_legajo, emp.apellido, emp.nombre, p.descripcion as puesto, emp.fecha_ingreso_reconocida, null as fecha_egreso "
			+ "FROM empleados emp JOIN puesto p ON p.id = emp.cod_puesto "
			+ "WHERE (EXISTS (SELECT 1 FROM historial_de_puestos hp WHERE emp.nro_legajo = hp.nro_legajo)) "
			+ "AND (emp.cod_estado_empleado IN :estado) "
			+ "AND (p.cod_direccion = :idDireccion OR :idDireccion IS NULL) "
			+ "AND (emp.cod_pais IN :idPais) "
			+ "AND (emp.fecha_ingreso_reconocida between :fechaIngresoDesde and :fechaIngresoHasta OR emp.fecha_ingreso_reconocida IS NOT NULL) "
			+ "UNION "
			+ "SELECT emp.nro_legajo, emp.apellido, emp.nombre, p.descripcion as puesto, hp.fecha_ingreso_reconocida, hp.fecha_egreso "
			+ "FROM empleados emp JOIN historial_de_puestos hp ON emp.nro_legajo = hp.nro_legajo JOIN  puesto p ON p.id = hp.cod_puesto "
			+ "WHERE (emp.cod_estado_empleado IN :estado) "
			+ "AND (p.cod_direccion = :idDireccion OR :idDireccion IS NULL) "
			+ "AND (emp.cod_pais IN :idPais) "
			+ "AND (hp.fecha_ingreso_reconocida between :fechaIngresoDesde AND :fechaIngresoHasta OR hp.fecha_ingreso_reconocida IS NOT NULL) "
			+ ") historial", nativeQuery = true)
	List<String> reporte(@Param("idPais") List<String> idPais,
			@Param("idDireccion") String idDireccion, @Param("estado") List<String> estado,
			@Param("fechaIngresoDesde") String fechaIngresoDesde,
			@Param("fechaIngresoHasta") String fechaIngresoHasta);
}
