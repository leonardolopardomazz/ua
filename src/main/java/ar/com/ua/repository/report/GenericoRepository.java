package ar.com.ua.repository.report;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.com.ua.model.Empleado;
import ar.com.ua.projection.report.GenericoProjection;

@Repository
@Transactional(readOnly = true)
public interface GenericoRepository extends JpaRepository<Empleado, Long> {

	@Query(value = "SELECT emp.nro_legajo as numeroLegajo, "
			+ "			CONCAT(emp.apellido, \" \", emp.nombre, \" \", COALESCE(emp.segundo_nombre,\"\")) as apellidoNombre, "
			+ "			emp.nombre_preferido as nombrePreferido, "
			+ "			emp.fecha_nacimiento as fechaNacimiento, "
			+ "			emp.cod_generacion as codigoGeneracion, "
			+ "			emp.cod_nacionalidad as codigoNacionalidad, "
			+ "			emp.cod_genero as codigoGenero, "
			+ "			emp.nro_doc_laboral as numeroDocumentoLaboral, "
			+ "			emp.nro_doc_personal as numeroDocumentoPersonal, "
			+ "			emp.calle_residencia as domicilio, "
			+ "			emp.numero_residencia as numeroResidencia, "
			+ "			emp.piso_residencia as pisoResidencia, "
			+ "			emp.localidad_residencia as localidadResidencia, "
			+ "			emp.cod_provincia as provincia, "
			+ "			emp.email_personal as emailPersonal, "
			+ "			emp.fecha_ingreso as fechaIngreso, "
			+ "			emp.fecha_ingreso_reconocida as fechaIngresoReconocida, "
			+ "			emp.cod_tipo_contratacion as tipoContratacion, "
			+ "			emp.horas_semanales as horasSemanales, "
			+ "			emp.fte as fte, "
			+ "			emp.cod_frec_liquidacion as frecuenciaLiquidacion, "
			+ "			emp.cod_tipo_empleo as tipoDeEmpleo, "
			+ "			emp.cod_tipo_jornada as tipoDeJornada, "
			+ "			pais.descripcion as pais, "
			+ "			emp.cod_oficina as codigoOficina, "
			+ "			emp.email_laboral as emailLaboral, "
			+ "			p.descripcion as puesto, "
			+ "			p.cod_categoria as codigoCategoria, "
			+ "			emp.cod_direccion as codigoDireccion, "
			+ "			p.cod_gerencia as codigoGerencia, "
			+ "			p.cod_jefatura as codigoJefatura, "
			+ "			emp.cod_division as codigoDivision, "
			+ "			emp.cod_centro_de_costo as codigoCentroDeCosto, "
			+ "			emp.cod_prepaga as codigoPrepaga, "
			+ "			emp.cod_obra_social as codigoObraSocial, "
			+ "			emp.cod_plan_prepaga as codigoPlanPrepaga, "
			+ "			emp.cod_banco as codigoBanco, "
			+ "			emp.cbu as cbu, "
			+ "			emp.cod_convenio as codigoConvenio, "
			+ "			emp.afiliado_sindicato as afiliadoSindicato, "
			+ "			emp.fecha_fin_contrato as fechaFinContrado, "
			+ "			emp.fecha_egreso as fechaEgreso, "
			+ "			emp.cod_tipo_egreso as codigoTipoEgreso, "
			+ "			emp.cod_estado_civil as codigoEstadoCivil, "
			+ "			emp.cod_grado as codigoGrado, "
			+ "			puesto_manager.descripcion as puestoManager, "
			+ "			CONCAT(manager.apellido, \" \", manager.nombre) as apellidoNombreManager, "
			+ "         GROUP_CONCAT( "
			+ "            cdf.apellido,\";\", "
			+ "            cdf.nombre,\";\", "
			+ "            (SELECT descripcion FROM parametros WHERE id = cdf.cod_parentesco),\";\", "
			+ "            (SELECT descripcion FROM parametros WHERE id = cdf.cod_tipo_doc),\";\", "
			+ "            cdf.nro_doc,\";\", "
			+ "            cdf.fecha_nacimiento,\";\", "
			+ "            IF(cdf.activo = 1 ,'Si', 'No') "
			+ "            SEPARATOR '|') as cargasDeFamilia "
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
	List<GenericoProjection> reporte(@Param("estadoEmpleado") List<String> estado, @Param("idDireccion") String idDireccion,
			@Param("idGerencia") String idGerencia);
}
