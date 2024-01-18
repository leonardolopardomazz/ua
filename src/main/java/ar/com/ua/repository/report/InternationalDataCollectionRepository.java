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
public interface InternationalDataCollectionRepository extends JpaRepository<Empleado, Long> {

	@Query(value = "SELECT emp.nro_legajo, "
			+ "p.descripcion, "
			+ "puesto_manager.descripcion AS puesto_manager, "
			+ "CONCAT(manager.apellido, \" \", manager.nombre, \"/\",COALESCE(manager.email_laboral,\"\")) AS manager, "
			+ "emp.apellido as surname, "
			+ "emp.nombre as name_, "
			+ "emp.segundo_nombre as middle_name, "
			+ "emp.nombre_preferido, "
			+ "emp.fecha_nacimiento, "
			+ "emp.cod_genero, "
			+ "pais.descripcion, "
			+ "emp.email_laboral, "
			+ "emp.fecha_ingreso, "
			+ "emp.horas_semanales, "
			+ "emp.fte, "
			+ "emp.cod_frec_liquidacion, "
			+ "emp.cod_tipo_empleo, "
			+ "emp.cod_tipo_contratacion, "
			+ "p.cod_jefatura, "
			+ "emp.fecha_egreso, "
			+ "emp.cod_tipo_egreso, "
			+ "emp.cod_generacion, "
			+ "emp.cod_division, "
			+ "emp.cod_direccion, "
			+ "emp.fecha_ingreso_reconocida "
			+ "FROM empleados emp JOIN pais ON emp.cod_pais = pais.id JOIN puesto p ON p.id = emp.cod_puesto "
			+ "LEFT JOIN puesto puesto_manager ON p.cod_puesto_al_que_reporta = puesto_manager.id "
			+ "LEFT JOIN empleados manager ON manager.cod_puesto = puesto_manager.id "
			+ "WHERE emp.cod_estado_empleado = :estadoActivo "
			+ "   OR emp.cod_estado_empleado = :estadoInactivo "
			+ "   OR (emp.cod_estado_empleado = :estadoBaja AND :fechaDesde IS NULL AND :fechaHasta IS NULL) "
			+ "   OR (emp.cod_estado_empleado = :estadoBaja AND :fechaDesde IS NULL AND :fechaHasta IS NOT NULL AND emp.fecha_egreso <= :fechaHasta) "
			+ "   OR (emp.cod_estado_empleado = :estadoBaja AND :fechaDesde IS NOT NULL AND :fechaHasta IS NULL AND emp.fecha_egreso >= :fechaDesde) "
			+ "   OR (emp.cod_estado_empleado = :estadoBaja AND :fechaDesde IS NOT NULL AND :fechaHasta IS NOT NULL AND emp.fecha_egreso >= :fechaDesde AND emp.fecha_egreso <= :fechaHasta) ", nativeQuery = true)
	List<String> reporte(@Param("estadoActivo") String estadoActivo, @Param("estadoInactivo") String estadoInactivo,
			@Param("estadoBaja") String estadoBaja, @Param("fechaDesde") String fechaDesde,
			@Param("fechaHasta") String fechaHasta);

}
