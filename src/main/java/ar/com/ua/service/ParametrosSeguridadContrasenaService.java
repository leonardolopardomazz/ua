package ar.com.ua.service;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ua.model.ParametrosSeguridadContrasena;

public interface ParametrosSeguridadContrasenaService extends JpaRepository<ParametrosSeguridadContrasena, Long> {
	

}
