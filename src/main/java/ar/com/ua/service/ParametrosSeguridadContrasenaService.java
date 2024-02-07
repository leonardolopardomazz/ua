package ar.com.ua.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ua.model.ParametrosSeguridadContrasena;

public interface ParametrosSeguridadContrasenaService extends JpaRepository<ParametrosSeguridadContrasena, Long> {
	
	List<ParametrosSeguridadContrasena> findByActivoTrue();
	int countByActivoTrue(); 
}
