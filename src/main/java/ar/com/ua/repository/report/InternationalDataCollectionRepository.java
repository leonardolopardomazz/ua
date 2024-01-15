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
public interface InternationalDataCollectionRepository extends JpaRepository<Empleado, Long> {
	
	@Query(value = "select emp.nro_legajo, "
			+ "puesto.descripcion, "
			+ "CONCAT(puesto.cod_puesto_al_que_reporta, \" \",  puesto.cod_puesto_al_que_reporta) as manager, "
			+ "emp.apellido as surname, "
			+ "emp.nombre as name_, "
			+ "emp.segundo_nombre as middle_name, "
			+ "emp.nombre_preferido, "
			+ "emp.fecha_nacimiento, "
			+ "emp.cod_genero, "
			+ "emp.cod_pais, "
			+ "emp.email_laboral, "
			+ "emp.fecha_ingreso, "
			+ "emp.horas_semanales, "
			+ "emp.fte, "
			+ "emp.cod_frec_liquidacion, "
			+ "emp.cod_tipo_empleo, "
			+ "emp.cod_tipo_contratacion, "
			+ "puesto.cod_jefatura, "
			+ "emp.fecha_egreso, "
			+ "emp.cod_tipo_egreso, "
			+ "emp.cod_generacion, "
			+ "emp.cod_division "
			+ "from empleados emp, puesto puesto "
			+ "where emp.cod_puesto = puesto.id "
			+ "and emp.activo IN :estado "
			+ "and emp.fecha_egreso is :tieneFechaEgreso"
			+ "and (emp.fecha_egreso is null OR emp.fecha_egreso <= :fechaEgreso)"
			+ "and emp.fecha_ingreso >= :fechaIngreso " , nativeQuery = true)
	List<String> reporte(@Param("estado") List<String> estado, @Param("tieneFechaEgreso") String tieneFechaEgreso, @Param("fechaIngreso") String fechaIngreso,  @Param("fechaEgreso") String fechaEgreso);

}
