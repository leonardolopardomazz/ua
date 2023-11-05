package ar.com.ua.service;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ua.model.Permiso;

public interface PermisoService extends JpaRepository<Permiso, Long> {

}
