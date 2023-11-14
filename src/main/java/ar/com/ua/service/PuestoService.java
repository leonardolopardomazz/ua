package ar.com.ua.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ua.model.Puesto;

public interface PuestoService extends JpaRepository<Puesto, Long> {
	List<Puesto> findByDescripcion(String descripcion);
}
