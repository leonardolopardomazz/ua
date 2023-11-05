package ar.com.ua.service;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ua.model.Puesto;

public interface PuestoService extends JpaRepository<Puesto, Long> {

}
