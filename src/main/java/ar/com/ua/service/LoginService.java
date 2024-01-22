package ar.com.ua.service;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ua.model.Login;
import ar.com.ua.model.Usuario;

public interface LoginService extends JpaRepository<Login, Long> {
	Login findFirstByUsuarioOrderByFechaUltimoIntentoDesc(Usuario usuario);
	Login findFirstByUsuarioAndPrimerAccesoTrueOrderByFechaReseteoContrasenaDesc(Usuario usuario);
}
