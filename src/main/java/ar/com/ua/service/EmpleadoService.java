package ar.com.ua.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ua.model.Empleado;

public interface EmpleadoService extends JpaRepository<Empleado, Long> {
	boolean existsByNumeroLegajo(Long numeroLegajo);

	List<Empleado> findByNumeroLegajo(Long numeroLegajo);
}
