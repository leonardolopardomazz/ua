package ar.com.ua.service;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ua.model.Secuenciador;

public interface SecuenciadorService extends JpaRepository<Secuenciador, Long> {
	Secuenciador findByCodigo(String codigo);
}
