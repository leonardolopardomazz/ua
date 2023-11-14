package ar.com.ua.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ua.model.Permiso;

public interface PermisoService extends JpaRepository<Permiso, Long> {
	
	List<Permiso> findByDescripcion(String descripcion);

}
