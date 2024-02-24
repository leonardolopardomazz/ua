package ar.com.ua.repository.report;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.com.ua.model.Empleado;
import ar.com.ua.projection.report.LicenciasProjection;

@Repository
@Transactional(readOnly = true)
public interface LicenciasRepository extends JpaRepository<Empleado, Long> {

	@Query(value = "SELECT "
			+ "emp.nro_legajo as numeroLegajo, "
			+ "emp.apellido as apellido, "
			+ "emp.nombre as nombre, "
			+ "hdl.cod_tipo_licencia as codigoLicencia, "
			+ "hdl.fecha_inicio as fechaInicio, "
			+ "hdl.fecha_fin as fechaFin, "
			+ "hdl.activo as activo, "
			+ "pais.descripcion as paisDescripcion, "
			+ "p.cod_direccion as codigoDireccion, "
			+ "p.cod_gerencia as codigoGerencia, "
			+ "p.cod_jefatura as codigojefatura, "
			+ "p.descripcion as descripcion "
			+ "FROM empleados emp JOIN historial_de_licencias hdl ON emp.id = hdl.id_empleado "
			+ "JOIN puesto p ON emp.cod_puesto = p.id JOIN pais pais ON emp.cod_pais = pais.id "
			+ "WHERE (emp.cod_estado_empleado IN :estadoEmpleado) "
			+ "AND (emp.cod_pais = :idPais OR :idPais IS NULL) "
			+ "AND (p.cod_direccion = :idDireccion OR :idDireccion IS NULL) "
			+ "AND (hdl.activo IN ( :estadoLicencia )) ", 
			nativeQuery = true)
	List<LicenciasProjection> reporte(@Param("estadoEmpleado") List<String> estadoEmpleado, @Param("idPais") String pais,
			@Param("idDireccion") String direccion, @Param("estadoLicencia") List<String> estadoLicencia);
}
