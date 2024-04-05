package ar.com.ua.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ar.com.ua.model.Empleado;

public interface EmpleadoService extends JpaRepository<Empleado, Long> {
	boolean existsByNumeroLegajo(Long numeroLegajo);
	List<Empleado> findByNumeroLegajo(Long numeroLegajo);
	
	
	@Query(value = "SELECT emp.nro_legajo FROM historial_de_ingresos_caidos hic, empleados emp WHERE hic.id_empleado = emp.id", nativeQuery = true)
	public List<Long> numerosLegajoEnHistoricoIngresoCaido();
	
	@Query(value = "SELECT count(emp.nro_legajo) FROM empleados emp WHERE emp.cod_puesto = :codPuesto AND emp.cod_estado_empleado <> 89", nativeQuery = true)
	public Long existsByCodigoPuesto(@Param("codPuesto") Long codPuesto);
}
