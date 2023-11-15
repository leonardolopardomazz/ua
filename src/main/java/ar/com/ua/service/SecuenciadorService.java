package ar.com.ua.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ua.model.Secuenciador;

public interface SecuenciadorService extends JpaRepository<Secuenciador, Long> {
	List<Secuenciador> findByCodigo(String codigo);
}
