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
public interface DirectoresRepository extends JpaRepository<Empleado, Long> {

	@Query(value = "SELECT emp.nro_legajo, CONCAT(emp.apellido, \" \", emp.nombre) AS apellido_nombre, emp.fecha_ingreso AS fecha_ingreso, "
			+ "emp.fecha_ingreso_reconocida AS fecha_ingreso_reconocida, pais.descripcion AS pais, emp.email_laboral AS email_laboral, "
			+ "emp.cod_oficina, p.descripcion AS puesto, p.cod_categoria, p.cod_direccion, p.cod_gerencia, p.cod_jefatura, pr.descripcion AS puesto_manager, "
			+ "emp.cod_division,emp.cod_centro_de_costo,emp.cod_convenio "
			+ "FROM empleados emp JOIN pais pais ON emp.cod_pais = pais.id JOIN puesto p ON emp.cod_puesto = p.id JOIN puesto pr ON p.cod_puesto_al_que_reporta = pr.id "
			+ "WHERE emp.cod_estado_empleado IN :estado "
			+ "AND (emp.cod_direccion = :idDireccion OR :idDireccion IS NULL) "
			+ "AND (p.cod_gerencia = :idGerencia OR :idGerencia IS NULL) ", nativeQuery = true)
	List<String> reporte(@Param("estado") List<String> estado, @Param("idDireccion") String idDireccion,
			@Param("idGerencia") String idGerencia);

}
