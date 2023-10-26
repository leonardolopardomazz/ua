package ar.com.ua.service;

import org.springframework.data.repository.CrudRepository;

import ar.com.ua.model.Puesto;

public interface PuestoService extends CrudRepository<Puesto, Long> {

}
