package ar.com.ua.service;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ua.model.EmpleadoExterno;

public interface EmpleadoExternoService extends JpaRepository<EmpleadoExterno, Long> {

}
