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
public interface GenericoRepository extends JpaRepository<Empleado, Long>  {

	@Query(value = "SELECT emp.nro_legajo, "
			+ "CONCAT(emp.apellido, \" \", emp.nombre, \" \", emp.segundo_nombre), "
			+ "emp.nombre_preferido, "
			+ "emp.fecha_nacimiento, "
			+ "-- calcular edad "
			+ "(SELECT descripcion FROM parametros WHERE id = :idGeneracion) as generacion, "
			+ "(SELECT descripcion FROM parametros WHERE id = :idNacionalidad) as nacionalidad, "
			+ "(SELECT descripcion FROM parametros WHERE id = :idGenero) as genero, "
			+ "-- ??? Denominación "
			+ "-- ???CUIL "
			+ "emp.nro_doc_personal as dni, "
			+ "emp.calle_residencia as domicilio, "
			+ "emp.numero_residencia, "
			+ "emp.piso_residencia, "
			+ "emp.localidad_residencia, "
			+ "(SELECT descripcion FROM parametros WHERE id = :idProvincia) as provincia, "
			+ "emp.email_laboral, "
			+ "emp.fecha_ingreso, "
			+ "emp.fecha_ingreso_reconocida, "
			+ "(SELECT descripcion FROM parametros WHERE id = :idTipoContratacion) as tipo_contratacion, "
			+ "emp.horas_semanales, "
			+ "emp.fte, "
			+ "(SELECT descripcion FROM parametros WHERE id = :idFrecuenciaLiquidacion) as frecuencia_liquidacion, "
			+ "(SELECT descripcion FROM parametros WHERE id = :idTipoEmpleado) as tipo_de_empleado, "
			+ "(SELECT descripcion FROM parametros WHERE id = :idTipoDeJornada) as tipo_de_jornada, "
			+ "(SELECT descripcion FROM parametros WHERE id = :idPais) as pais, "
			+ "-- Lugar de Trabajo (tabla) "
			+ "emp.email_laboral, "
			+ "(SELECT descripcion FROM parametros WHERE id = :idPuesto) as puesto, "
			+ "(SELECT descripcion FROM parametros WHERE id = :idCategoria) as categoria, "
			+ "(SELECT descripcion FROM parametros WHERE id = :idManagerJefe) as manager_jefe, "
			+ "(SELECT descripcion FROM parametros WHERE id = :idCargoManagerJefe) as cargo_manager_jefe, "
			+ "(SELECT descripcion FROM parametros WHERE id = :idDireccion) as direccion, "
			+ "(SELECT descripcion FROM parametros WHERE id = :idGerencia) as gerencia, "
			+ "(SELECT descripcion FROM parametros WHERE id = :idJefatura) as jefatura, "
			+ "(SELECT descripcion FROM parametros WHERE id = :idDivision) as division, "
			+ "(SELECT descripcion FROM parametros WHERE id = :idCentroDeCostos) as centro_de_costos, "
			+ "(SELECT descripcion FROM parametros WHERE id = :idPrepaga) as prepaga, "
			+ "(SELECT descripcion FROM parametros WHERE id = :idObraSocial) as obra_social, "
			+ "(SELECT descripcion FROM parametros WHERE id = :idPlanPrepaga) as plan_prepaga, "
			+ "(SELECT descripcion FROM parametros WHERE id = :idBanco) as banco, "
			+ "emp.cbu as cbu, "
			+ "-- Cargas de Familia ??? "
			+ "(SELECT descripcion FROM parametros WHERE id = :idConvenio) as convenio, "
			+ "emp.afiliado_sindicato as afiliado_sindicato, "
			+ "emp.fecha_fin_contrato as fecha_fin_contrado, "
			+ "emp.fecha_egreso as fecha_egreso, "
			+ "(SELECT descripcion FROM parametros WHERE id = :idTipoEgreso) as tipo_egreso, "
			+ "-- Motivo de Egreso "
			+ "(SELECT descripcion FROM parametros WHERE id = :idEstadoCivil) as estado_civil, "
			+ "(SELECT descripcion FROM parametros WHERE id = :idGrado) as grado "
			+ "FROM empleados emp, parametros "
			+ "GROUP BY nro_legajo", nativeQuery = true)
	List<String> reporte(@Param("idDireccion") String idDireccion, @Param("idGerencia") String idGerencia,
			@Param("estado") String estado);

}
