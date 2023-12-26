package ar.com.ua.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ua.model.HistorialIngresoCaidos;

public interface HistorialIngresoCaidosService extends JpaRepository<HistorialIngresoCaidos, Long> {

	public List<HistorialIngresoCaidos> findAllByEmpleadoIsNotNull();
}
