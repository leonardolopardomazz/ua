package ar.com.ua.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ua.model.Pais;

public interface PaisService extends JpaRepository<Pais, Long> {
	List<Pais> findByCodigo(String codigo);
}
