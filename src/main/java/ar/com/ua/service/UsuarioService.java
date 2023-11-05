package ar.com.ua.service;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ua.model.Usuario;

public interface UsuarioService extends JpaRepository<Usuario, Long> {

}
