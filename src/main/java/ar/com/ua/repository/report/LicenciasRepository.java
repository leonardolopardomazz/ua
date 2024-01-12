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
public interface LicenciasRepository extends JpaRepository<Empleado, Long> {

	@Query(value = "SELECT "
			+ "emp.nro_legajo, "
			+ "emp.apellido, "
			+ "emp.nombre, "
			+ "hdl.cod_tipo_licencia, "
			+ "hdl.fecha_inicio, "
			+ "hdl.fecha_fin, "
			+ "hdl.activo, "
			+ "emp.cod_pais, "
			+ "puesto.cod_direccion, "
			+ "puesto.cod_gerencia, "
			+ "puesto.cod_jefatura, "
			+ "puesto.descripcion "
			+ "FROM empleados as emp, historial_de_licencias as hdl, puesto as puesto "
			+ "WHERE "
			+ "emp.cod_puesto = hdl.id AND emp.cod_puesto = puesto.id "
			+ "AND emp.cod_estado_empleado IN :estadoEmpleado "
			+ "AND emp.cod_pais = :idPais "
			+ "AND puesto.cod_direccion = :idDireccion "
			+ "AND hdl.activo = :idEstadoLicencia", nativeQuery = true)
	List<String> reporte(@Param("estadoEmpleado") List<String> estadoEmpleado, @Param("idPais") String pais,
			@Param("idDireccion") String direccion, @Param("idEstadoLicencia") String estadoLicencia);
}
