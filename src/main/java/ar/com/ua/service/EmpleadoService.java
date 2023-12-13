package ar.com.ua.service;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ua.model.Empleado;

public interface EmpleadoService extends JpaRepository<Empleado, Long> {
	boolean existsByNumeroLegajo(String numeroLegajo);
}
