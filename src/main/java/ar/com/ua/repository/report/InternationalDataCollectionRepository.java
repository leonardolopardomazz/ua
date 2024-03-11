package ar.com.ua.repository.report;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.com.ua.model.Empleado;
import ar.com.ua.projection.report.InternationalDataCollectionProjection;

@Repository
@Transactional(readOnly = true)
public interface InternationalDataCollectionRepository extends JpaRepository<Empleado, Long> {

	@Query(value = "SELECT emp.nro_legajo as globalId, "
			+ "p.descripcion as positionTitle, "
			+ "puesto_manager.descripcion AS cargoManagerToReport, "
			+ "CONCAT(manager.apellido, \" \", manager.nombre, \"/\",COALESCE(manager.email_laboral,\"\")) AS managerToReport, "
			+ "emp.apellido as surname, "
			+ "emp.nombre as firstName , "
			+ "emp.segundo_nombre as middleName, "
			+ "emp.nombre_preferido as preferedName, "
			+ "emp.fecha_nacimiento as dateOfBirth, "
			+ "emp.cod_genero as gender, "
			+ "pais.descripcion as country, "
			+ "emp.email_laboral as mailLaboral, "
			+ "emp.fecha_ingreso_reconocida as startDate, "
			+ "emp.horas_semanales as horasDeTrabajo, "
			+ "emp.fte as fte, "
			+ "emp.cod_frec_liquidacion as rateFrecuency, "
			+ "emp.cod_tipo_empleo as employmentType, "
			+ "emp.cod_tipo_jornada as personnelType, "
			+ "p.cod_jefatura as jefatura, "
			+ "emp.fecha_egreso as termDate, "
			+ "emp.cod_tipo_egreso as termReason, "
			+ "emp.cod_generacion as generation, "
			+ "emp.cod_division as divission, "
			+ "p.cod_direccion as direccion, "
			+ "p.cod_gerencia as gerencia, "
			+ "emp.cod_oficina as oficina, "
			+ "IF(l.id is NULL, 'Activo', 'Inactivo') AS active, "
			+ "p.cod_categoria AS codigoCategoria "
			+ "FROM empleados emp JOIN pais ON emp.cod_pais = pais.id JOIN puesto p ON p.id = emp.cod_puesto "
			+ "LEFT JOIN historial_de_licencias l ON emp.id = l.id_empleado AND l.fecha_inicio <= :fechaHasta AND l.fecha_fin >= :fechaHasta "
			+ "LEFT JOIN puesto puesto_manager ON p.cod_puesto_al_que_reporta = puesto_manager.id "
			+ "LEFT JOIN empleados manager ON manager.cod_puesto = puesto_manager.id "
			+ "WHERE "
			+ " :fechaHasta IS NOT NULL "
			+ " AND emp.fecha_ingreso_reconocida <= :fechaHasta "
			+ " AND (emp.fecha_egreso >= :fechaHasta OR emp.fecha_egreso IS NULL) ", nativeQuery = true)
	List<InternationalDataCollectionProjection> reporte(@Param("fechaHasta") String fechaHasta);

}
