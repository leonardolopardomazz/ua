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
			+ "emp.fecha_ingreso_reconocida, "
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
			+ "p.cod_gerencia, "
			+ "emp.cod_oficina, "
			+ "l.id AS id_licencia, "
			+ "p.cod_categoria AS categoria "
			+ "FROM empleados emp JOIN pais ON emp.cod_pais = pais.id JOIN puesto p ON p.id = emp.cod_puesto "
			+ "LEFT JOIN historial_de_licencias l ON emp.id = l.id_empleado AND l.fecha_inicio <= :fechaHasta AND l.fecha_fin >= :fechaHasta "
			+ "LEFT JOIN puesto puesto_manager ON p.cod_puesto_al_que_reporta = puesto_manager.id "
			+ "LEFT JOIN empleados manager ON manager.cod_puesto = puesto_manager.id "
			+ "WHERE "
			+ " :fechaHasta IS NOT NULL "
			+ " AND emp.fecha_ingreso_reconocida <= :fechaHasta "
			+ " AND (emp.fecha_egreso >= :fechaHasta OR emp.fecha_egreso IS NULL) ", nativeQuery = true)
	List<String> reporte(@Param("fechaHasta") String fechaHasta);

}
