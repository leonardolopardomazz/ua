package ar.com.ua.service;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ua.model.SeguridadContrasena;

public interface SeguridadContrasenaService extends JpaRepository<SeguridadContrasena, Long> {
	
	SeguridadContrasena findFirstByActivoTrueOrderByIdAsc();

}
