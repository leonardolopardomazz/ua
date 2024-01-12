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
public interface DirectoresRepository extends JpaRepository<Empleado, Long>  {

	@Query(value = "SELECT emp.nro_legajo, "
			+ "CONCAT(emp.apellido, \" \", emp.nombre) as apellido_nombre, "
			+ "emp.fecha_ingreso as fecha_ingreso, "
			+ "emp.fecha_ingreso_reconocida as fecha_ingreso_reconocida, "
			+ "emp.cod_pais as idPais, "
			+ "emp.email_laboral as email_laboral, "
			+ "emp.cod_puesto as idPuesto, "
			+ "puesto.cod_categoria, "
			+ "puesto.cod_puesto_al_que_reporta, "
			+ "puesto.cod_direccion, "
			+ "puesto.cod_gerencia, "
			+ "puesto.cod_jefatura, "
			+ "emp.cod_division, "
			+ "emp.cod_centro_de_costo, "
			+ "emp.cod_convenio "
			+ "FROM empleados as emp, PUESTO as puesto "
			+ "WHERE "
			+ "emp.cod_puesto = puesto.id "
			+ "AND  emp.cod_estado_empleado IN :estado "
			+ "AND emp.cod_direccion = :idDireccion "
			+ "AND puesto.cod_gerencia = :idGerencia "
			+ "GROUP BY emp.nro_legajo", nativeQuery = true)
	List<String> reporte(@Param("estado") List<String> estado, @Param("idDireccion") String idDireccion,
			@Param("idGerencia") String idGerencia);

}
