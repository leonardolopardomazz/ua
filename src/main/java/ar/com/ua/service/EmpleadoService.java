package ar.com.ua.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ar.com.ua.model.Empleado;

public interface EmpleadoService extends JpaRepository<Empleado, Long> {
	boolean existsByNumeroLegajo(Long numeroLegajo);
	List<Empleado> findByNumeroLegajo(Long numeroLegajo);
	
	
	@Query(value = "SELECT emp.nro_legajo FROM historial_de_ingresos_caidos hic, empleados emp WHERE hic.id_empleado = emp.id", nativeQuery = true)
	public List<Long> numerosLegajoEnHistoricoIngresoCaido();
}
