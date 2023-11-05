package ar.com.ua.service;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ua.model.Parametro;

public interface ParametroService extends JpaRepository<Parametro, Long> {

}
