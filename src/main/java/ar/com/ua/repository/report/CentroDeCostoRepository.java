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
public interface CentroDeCostoRepository extends JpaRepository<Empleado, Long>  {

	@Query(value = "SELECT emp.nro_legajo, emp.apellido, emp.nombre, "
			+ "emp.cod_direccion, (SELECT descripcion FROM ua.parametros WHERE id = :idDireccion) as direccion, "
			+ "puesto.cod_gerencia, (SELECT descripcion FROM ua.parametros WHERE id = :idGerencia) as gerencia, "
			+ "emp.cod_centro_de_costo, (SELECT descripcion FROM ua.parametros WHERE id = :idCentroDeCosto) as centro_de_costo, "
			+ "emp.fte "
			+ "FROM empleados emp, parametros param, puesto puesto "
			+ "WHERE emp.cod_centro_de_costo = :idCentroDeCosto OR emp.cod_centro_de_costo IS NULL "
			+ "AND emp.cod_estado_empleado = :estado OR emp.cod_estado_empleado IS NULL " 
			+ "AND emp.cod_direccion = :idDireccion OR emp.cod_direccion IS NULL "
			+ "GROUP BY emp.nro_legajo ", nativeQuery = true)
	List<String> reporteCentroDeCosto(@Param("idCentroDeCosto") String idCentroDeCosto, @Param("estado") String estado,
			@Param("idDireccion") String idDireccion, @Param("idGerencia") String idGerencia);

}
