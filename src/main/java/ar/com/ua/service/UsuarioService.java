package ar.com.ua.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ua.model.Usuario;

public interface UsuarioService extends JpaRepository<Usuario, Long> {
	Usuario findByNombreUsuario(String nombreUsuario);
	List<Usuario> findByNombreUsuarioLike(String nombreUsuario);
	Usuario findByNumeroLegajo(Long numeroLegajo);
	Usuario findByNombreUsuarioAndContrasena(String nombreUsuario, String contrasena);
	Boolean existsByNombreUsuarioAndBloqueadoTrue(String nombreUsuario);
	Boolean existsByNombreUsuario(String nombreUsuario);
	Boolean existsByNombreUsuarioAndContrasena(String nombreUsuario, String contrasena);
}
