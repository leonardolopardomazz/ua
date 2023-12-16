package ar.com.ua.service;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ua.model.Parametro;
import java.util.List;


public interface ParametroService extends JpaRepository<Parametro, Long> {
	
	List<Parametro> findByDescripcion(String descripcion);

}
