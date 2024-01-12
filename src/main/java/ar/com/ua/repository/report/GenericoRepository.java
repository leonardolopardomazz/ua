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
	
/*
	edad
	Denominación
	Lugar de Trabajo (tabla)
	
	
	Manager / Jefe
	Cargo de Manager / Jefe 
	Dirección / C.M.
	Subcentro de Costo
	Cargas de Familia
	*/
	
	@Query(value = "SELECT emp.nro_legajo, " 
			+ "CONCAT(emp.apellido, \" \", emp.nombre, \" \", emp.segundo_nombre), "
			+ "emp.nombre_preferido, " 
			+ "emp.fecha_nacimiento, " 
			+ "emp.cod_generacion, "
			+ "emp.cod_nacionalidad, "
			+ "emp.cod_genero, " 
			+ "emp.nro_doc_laboral, " 
			+ "emp.nro_doc_personal, " 
			+ "emp.calle_residencia as domicilio, "
			+ "emp.numero_residencia, " 
			+ "emp.piso_residencia, " 
			+ "emp.localidad_residencia, "
			+ "emp.cod_provincia as provincia, " 
			+ "emp.email_personal, "
			+ "emp.fecha_ingreso, " 
			+ "emp.fecha_ingreso_reconocida, "
			+ "emp.cod_tipo_contratacion as tipo_contratacion, "
			+ "emp.horas_semanales, " 
			+ "emp.fte, "
			+ "emp.cod_frec_liquidacion as frecuencia_liquidacion, "
			+ "emp.cod_tipo_de_empleo as tipo_de_empleo, "
			+ "emp.tipo_de_jornada as tipo_de_jornada, "
			+ "emp.cod_pais, " 
			+ "emp.email_laboral, " 
			+ "emp.cod_puesto, "
			+ "emp.cod_categoria, "
			+ "emp.cod_direccion, "
			+ "emp.cod_gerencia, "
			+ "emp.cod_jefatura, "
			+ "emp.cod_division, "
			+ "emp.cod_centro_de_costo, "
			+ "emp.cod_prepaga, "
			+ "emp.cod_obra_social, "
			+ "emp.cod_plan_prepaga, "
			+ "emp.cod_banco, " 
			+ "emp.cbu, "
			+ "emp.cod_convenio, "
			+ "emp.afiliado_sindicato, " 
			+ "emp.fecha_fin_contrato, "
			+ "emp.fecha_egreso as fecha_egreso, "
			+ "emp.cod_tipo_egreso, " 
			+ "emp.cod_estado_civil, "
			+ "emp.cod_grado "
			+ "FROM empleados emp, parametros "
			+ "GROUP BY nro_legajo ", nativeQuery = true)
	List<String> reporte(@Param("estado") List<String> estado, @Param("idDireccion") String idDireccion, @Param("idGerencia") String idGerencia);
}
