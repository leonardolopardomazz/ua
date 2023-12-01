package ar.com.ua.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.ua.model.RolUsuario;
import ar.com.ua.repository.RolUsuarioRepository;

@Component
public class RolUsuarioService {

	@Autowired
	private RolUsuarioRepository<RolUsuario> repository;

	public void customSave(RolUsuario rolUsuario) {
		this.repository.customSave(rolUsuario);
	}

	public void customDelete(RolUsuario rolUsuario) {
		this.repository.customDelete(rolUsuario);
	}

}
