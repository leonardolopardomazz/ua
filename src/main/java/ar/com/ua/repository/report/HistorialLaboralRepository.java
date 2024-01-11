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
public interface HistorialLaboralRepository extends JpaRepository<Empleado, Long>  {
	
	@Query(value = "SELECT emp.nro_legajo, emp.apellido, emp.nombre, puesto.descripcion as puesto, "
			+ "hp.fecha_ingreso_reconocida, hp.fecha_egreso "
			+ "FROM empleados emp, parametros param, puesto puesto, historial_de_puestos hp "
			+ "WHERE emp.cod_estado_empleado IN :estado OR emp.cod_estado_empleado IS NULL "
			+ "AND emp.cod_direccion = :idDireccion OR emp.cod_direccion IS NULL "
			+ "AND emp.cod_pais IN :idPais OR emp.cod_pais IS NULL "
			+ "AND emp.nro_legajo = hp.nro_legajo "
			+ "AND hp.fecha_ingreso_reconocida between :fechaIngresoDesde and :fechaIngresoHasta OR hp.fecha_ingreso_reconocida IS NOT NULL "
			+ "GROUP BY emp.nro_legajo", nativeQuery = true)
	List<String> reporte(@Param("idPais") List<String> idPais, 
			@Param("idDireccion") String idDireccion, @Param("estado") List<String> estado, @Param("fechaIngresoDesde") String fechaIngresoDesde, 
			@Param("fechaIngresoHasta") String fechaIngresoHasta);
}
