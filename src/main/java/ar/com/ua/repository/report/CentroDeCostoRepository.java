package ar.com.ua.repository.report;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.com.ua.model.Empleado;
import ar.com.ua.projection.report.CentroDeCostoProjection;

@Repository
@Transactional(readOnly = true)
public interface CentroDeCostoRepository extends JpaRepository<Empleado, Long> {

	@Query(value = "SELECT emp.nro_legajo as numeroLegajo, "
			+ "emp.apellido as apellido, "
			+ "emp.nombre as nombre, "
			+ "emp.cod_direccion as codigoDireccion, "
			+ "p.cod_gerencia as codigoGerencia, "
			+ "emp.cod_centro_de_costo as codigoCentroDeCosto, "
			+ "emp.fte as fte "
			+ "FROM empleados emp JOIN puesto p ON emp.cod_puesto = p.id "
			+ "WHERE (emp.cod_centro_de_costo = :idCentroDeCosto OR :idCentroDeCosto IS NULL) "
			+ "AND (emp.cod_direccion = :idDireccion OR :idDireccion IS NULL) "
			+ "AND (emp.cod_estado_empleado IN ( :estado )) "
			, nativeQuery = true)
	List<CentroDeCostoProjection> reporte(@Param("idCentroDeCosto") String idCentroDeCosto, @Param("estado") List<String> estado,
			@Param("idDireccion") String idDireccion);

}
