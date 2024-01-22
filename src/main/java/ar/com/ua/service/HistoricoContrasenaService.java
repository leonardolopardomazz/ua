package ar.com.ua.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ua.model.HistoricoContrasena;
import ar.com.ua.model.Usuario;

public interface HistoricoContrasenaService  extends JpaRepository<HistoricoContrasena, Long> {
	
	List<HistoricoContrasena> findTop5ByUsuarioOrderByFechaCambioContrasenaAsc(Usuario usuario);

}
