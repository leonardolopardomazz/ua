package ar.com.ua.service;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ua.model.CargaDeFamilia;

public interface CargaDeFamiliaService extends JpaRepository<CargaDeFamilia, Long> {

}
