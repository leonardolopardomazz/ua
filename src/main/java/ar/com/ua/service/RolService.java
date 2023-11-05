package ar.com.ua.service;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ua.model.Rol;

public interface RolService extends JpaRepository<Rol, Long> {

}
