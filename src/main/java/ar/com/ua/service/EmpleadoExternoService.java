package ar.com.ua.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ar.com.ua.model.EmpleadoExterno;

public interface EmpleadoExternoService extends JpaRepository<EmpleadoExterno, Long> {
	
	@Query(value = "SELECT MAX(eext.numeroLegajo) FROM EmpleadoExterno eext")
	public String findMaxNumeroLegajo();
}
