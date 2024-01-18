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
public interface GenericoRepository extends JpaRepository<Empleado, Long> {

	@Query(value = "SELECT emp.nro_legajo, "
			+ "			CONCAT(emp.apellido, \" \", emp.nombre, \" \", COALESCE(emp.segundo_nombre,\"\")) as apellido_nombre, "
			+ "			emp.nombre_preferido, "
			+ "			emp.fecha_nacimiento, "
			+ "			emp.cod_generacion, "
			+ "			emp.cod_nacionalidad, "
			+ "			emp.cod_genero, "
			+ "			emp.nro_doc_laboral, "
			+ "			emp.nro_doc_personal, "
			+ "			emp.calle_residencia AS domicilio, "
			+ "			emp.numero_residencia, "
			+ "			emp.piso_residencia, "
			+ "			emp.localidad_residencia, "
			+ "			emp.cod_provincia AS provincia, "
			+ "			emp.email_personal, "
			+ "			emp.fecha_ingreso, "
			+ "			emp.fecha_ingreso_reconocida, "
			+ "			emp.cod_tipo_contratacion AS tipo_contratacion, "
			+ "			emp.horas_semanales, "
			+ "			emp.fte, "
			+ "			emp.cod_frec_liquidacion AS frecuencia_liquidacion, "
			+ "			emp.cod_tipo_empleo AS tipo_de_empleo, "
			+ "			emp.cod_tipo_jornada AS tipo_de_jornada, "
			+ "			pais.descripcion AS pais, "
			+ "			emp.cod_oficina, "
			+ "			emp.email_laboral, "
			+ "			p.descripcion AS puesto, "
			+ "			emp.cod_categoria_empleado, "
			+ "			emp.cod_direccion, "
			+ "			p.cod_gerencia, "
			+ "			p.cod_jefatura, "
			+ "			emp.cod_division, "
			+ "			emp.cod_centro_de_costo, "
			+ "			emp.cod_prepaga, "
			+ "			emp.cod_obra_social, "
			+ "			emp.cod_plan_prepaga, "
			+ "			emp.cod_banco, "
			+ "			emp.cbu, "
			+ "			emp.cod_convenio, "
			+ "			emp.afiliado_sindicato, "
			+ "			emp.fecha_fin_contrato, "
			+ "			emp.fecha_egreso AS fecha_egreso, "
			+ "			emp.cod_tipo_egreso, "
			+ "			emp.cod_estado_civil, "
			+ "			emp.cod_grado, "
			+ "			puesto_manager.descripcion AS puesto_manager, "
			+ "			CONCAT(manager.apellido, \" \", manager.nombre) AS apellido_nombre_manager, "
			+ "         GROUP_CONCAT( "
			+ "            cdf.apellido,\";\", "
			+ "            cdf.nombre,\";\", "
			+ "            (SELECT descripcion FROM parametros WHERE id = cdf.cod_parentesco),\";\", "
			+ "            (SELECT descripcion FROM parametros WHERE id = cdf.cod_tipo_doc),\";\", "
			+ "            cdf.nro_doc,\";\", "
			+ "            cdf.fecha_nacimiento,\";\", "
			+ "            IF(cdf.activo = 1 ,'Si', 'No') "
			+ "            SEPARATOR '|') as cargas_de_familia "
			+ "			FROM empleados emp "
			+ "            JOIN pais ON pais.id = emp.cod_pais "
			+ "            JOIN puesto p "
			+ "			   ON emp.cod_puesto = p.id "
			+ "            LEFT JOIN puesto puesto_manager ON p.cod_puesto_al_que_reporta = puesto_manager.id "
			+ "            LEFT JOIN empleados manager ON manager.cod_puesto = puesto_manager.id "
			+ "            LEFT JOIN cargas_de_familia cdf "
			+ "            ON emp.nro_legajo = cdf.nro_legajo "
			+ "			WHERE "
			+ "                emp.cod_estado_empleado IN :estadoEmpleado "
			+ "            AND (p.cod_direccion = :idDireccion OR :idDireccion IS NULL) "
			+ "            AND (p.cod_gerencia = :idGerencia OR :idGerencia IS NULL) "
			+ "            GROUP BY emp.nro_legajo", nativeQuery = true)
	List<String> reporte(@Param("estadoEmpleado") List<String> estado, @Param("idDireccion") String idDireccion,
			@Param("idGerencia") String idGerencia);
}
