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

	@Query(value = "SELECT emp.nro_legajo, emp.apellido, emp.nombre, p.descripcion as puesto, hp.fecha_inicio_puesto, hp.fecha_fin_puesto, emp.cod_direccion "
			+ "FROM empleados emp JOIN historial_de_puestos hp ON emp.nro_legajo = hp.nro_legajo JOIN  puesto p ON p.id = hp.cod_puesto "
			+ "WHERE emp.cod_estado_empleado IN :estado "
			+ "AND (p.cod_direccion = :idDireccion OR :idDireccion IS NULL) "
			+ "AND emp.cod_pais IN :idPais "
			+ "AND fecha_inicio_puesto between IFNULL(:fechaDesde, \"1900-01-01\") AND IFNULL(:fechaHasta, now() + INTERVAL 30 DAY) ", nativeQuery = true)
	List<String> reporte(@Param("idPais") List<String> idPais,
			@Param("idDireccion") String idDireccion, @Param("estado") List<String> estado,
			@Param("fechaDesde") String fechaDesde,
			@Param("fechaHasta") String fechaHasta);
}
