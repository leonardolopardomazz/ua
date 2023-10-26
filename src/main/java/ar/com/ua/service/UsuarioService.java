package ar.com.ua.service;

import org.springframework.data.repository.CrudRepository;

import ar.com.ua.model.Usuario;

public interface UsuarioService  extends CrudRepository<Usuario, Long> {

}
