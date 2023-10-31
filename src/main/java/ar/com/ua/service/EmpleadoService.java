package ar.com.ua.service;

import org.springframework.data.repository.CrudRepository;

import ar.com.ua.model.Empleado;

public interface EmpleadoService extends CrudRepository<Empleado, Long> {

}
