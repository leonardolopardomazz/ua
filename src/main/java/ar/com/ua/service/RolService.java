package ar.com.ua.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ua.model.Rol;

public interface RolService extends JpaRepository<Rol, Long> {
	
	List<Rol> findByDescripcion(String descripcion);
}
