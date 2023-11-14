package ar.com.ua.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ua.model.TipoParametro;

public interface TipoParametroService extends JpaRepository<TipoParametro, Long> {
	List<TipoParametro> findByDescripcion(String descripcion);
}
