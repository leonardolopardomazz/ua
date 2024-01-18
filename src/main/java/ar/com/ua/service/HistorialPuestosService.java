package ar.com.ua.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ua.model.HistorialPuestos;

public interface HistorialPuestosService extends JpaRepository<HistorialPuestos, Long> {
    List<HistorialPuestos> findByNumeroLegajo(String numeroLegajo);

}
