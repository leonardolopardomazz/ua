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

	@Query(value = "SELECT nro_legajo, apellido, nombre, puesto, fecha_ingreso_reconocida, fecha_egreso, cod_direccion FROM ( "
			+ "SELECT emp.nro_legajo, emp.apellido, emp.nombre, p.descripcion as puesto, "
			+ "hp.ultimo_egreso AS fecha_ingreso_reconocida, null as fecha_egreso, emp.cod_direccion "
			+ "FROM empleados emp JOIN puesto p ON p.id = emp.cod_puesto JOIN (SELECT nro_legajo,MAX(fecha_egreso) AS ultimo_egreso FROM historial_de_puestos GROUP BY nro_legajo) hp ON emp.nro_legajo = hp.nro_legajo "
			+ "WHERE emp.cod_estado_empleado IN :estado "
			+ "AND (p.cod_direccion = :idDireccion OR :idDireccion IS NULL) "
			+ "AND emp.cod_pais IN :idPais "
			+ "UNION "
			+ "SELECT emp.nro_legajo, emp.apellido, emp.nombre, p.descripcion as puesto, hp.fecha_ingreso_reconocida, hp.fecha_egreso, emp.cod_direccion "
			+ "FROM empleados emp JOIN historial_de_puestos hp ON emp.nro_legajo = hp.nro_legajo JOIN  puesto p ON p.id = hp.cod_puesto "
			+ "WHERE emp.cod_estado_empleado IN :estado "
			+ "AND (p.cod_direccion = :idDireccion OR :idDireccion IS NULL) "
			+ "AND emp.cod_pais IN :idPais "
			+ ") historial "
			+ "WHERE fecha_ingreso_reconocida between IFNULL(:fechaIngresoDesde, \"1900-01-01\") AND IFNULL(:fechaIngresoHasta, now()) ", nativeQuery = true)
	List<String> reporte(@Param("idPais") List<String> idPais,
			@Param("idDireccion") String idDireccion, @Param("estado") List<String> estado,
			@Param("fechaIngresoDesde") String fechaIngresoDesde,
			@Param("fechaIngresoHasta") String fechaIngresoHasta);
}
