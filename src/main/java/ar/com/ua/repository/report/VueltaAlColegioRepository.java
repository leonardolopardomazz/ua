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
public interface VueltaAlColegioRepository extends JpaRepository<Empleado, Long> {

	@Query(value = "SELECT emp.nro_legajo as numeroLegajo, emp.apellido, emp.nombre, p.descripcion as pais, GROUP_CONCAT(cdf.fecha_nacimiento) as fechaNacimiento "
			+ "FROM empleados emp JOIN cargas_de_familia cdf ON emp.nro_legajo = cdf.nro_legajo JOIN pais p ON p.id = emp.cod_pais WHERE "
			+ "(emp.cod_pais IN :pais OR emp.cod_pais IS NULL) " + "AND cdf.activo = 1 "
			+ "AND cdf.cod_parentesco = (SELECT id FROM parametros WHERE descripcion = 'hijo/a') GROUP BY emp.nro_legajo", nativeQuery = true)
	List<String> reporte(@Param("pais") List<String> pais);
}
