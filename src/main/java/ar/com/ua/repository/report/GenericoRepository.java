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
/*
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
			+ "(SELECT descripcion FROM parametros WHERE id = 2) as provincia, "
			+ "emp.email_laboral, "
			+ "emp.fecha_ingreso, "
			+ "emp.fecha_ingreso_reconocida, "
			+ "(SELECT descripcion FROM parametros WHERE id = 2) as tipo_contratacion, "
			+ "emp.horas_semanales, "
			+ "emp.fte, "
			+ "(SELECT descripcion FROM parametros WHERE id = 2) as frecuencia_liquidacion, "
			+ "(SELECT descripcion FROM parametros WHERE id = 2) as tipo_de_empleado, "
			+ "(SELECT descripcion FROM parametros WHERE id = 2) as tipo_de_jornada, "
			+ "(SELECT descripcion FROM parametros WHERE id = 2) as pais, "
			+ "-- Lugar de Trabajo (tabla) "
			+ "emp.email_laboral, "
			+ "(SELECT descripcion FROM parametros WHERE id = 2) as tipo_jornada, "
			+ "(SELECT descripcion FROM parametros WHERE id = 2) as puesto, "
			+ "(SELECT descripcion FROM parametros WHERE id = 2) as categoria, "
			+ "(SELECT descripcion FROM parametros WHERE id = 2) as manager_jefe, "
			+ "(SELECT descripcion FROM parametros WHERE id = 2) as cargo_manager_jefe, "
			+ "(SELECT descripcion FROM parametros WHERE id = 2) as direccion, "
			+ "(SELECT descripcion FROM parametros WHERE id = 2) as gerencia, "
			+ "(SELECT descripcion FROM parametros WHERE id = 2) as jefatura, "
			+ "(SELECT descripcion FROM parametros WHERE id = 2) as division, "
			+ "(SELECT descripcion FROM parametros WHERE id = 2) as centro_de_costos, "
			+ "(SELECT descripcion FROM parametros WHERE id = 2) as prepaga, "
			+ "(SELECT descripcion FROM parametros WHERE id = 2) as obra_social, "
			+ "(SELECT descripcion FROM parametros WHERE id = 2) as plan_prepaga, "
			+ "(SELECT descripcion FROM parametros WHERE id = 2) as banco, "
			+ "emp.cbu as cbu, "
			+ "-- Cargas de Familia ??? "
			+ "(SELECT descripcion FROM parametros WHERE id = 2) as convenio, "
			+ "(SELECT descripcion FROM parametros WHERE id = 2) as categoria, "
			+ "emp.afiliado_sindicato as afiliado_sindicato, "
			+ "emp.fecha_fin_contrato as fecha_fin_contrado, "
			+ "emp.fecha_egreso as fecha_egreso, "
			+ "(SELECT descripcion FROM parametros WHERE id = 2) as tipo_egreso, "
			+ "-- Motivo de Egreso "
			+ "(SELECT descripcion FROM parametros WHERE id = 2) as estado_civil, "
			+ "(SELECT descripcion FROM parametros WHERE id = 2) as grado "
			+ "FROM empleados emp, parametros "
			+ "GROUP BY nro_legajo", nativeQuery = true)
	List<String> reporte(@Param("idDireccion") String idDireccion, @Param("idGerencia") String idGerencia,
			@Param("estado") String estado);
*/
}
