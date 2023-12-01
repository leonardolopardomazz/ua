package ar.com.ua.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.ua.model.RolPermiso;
import ar.com.ua.repository.RolPermisoRepository;

@Component
public class RolPermisoService {
	
	@Autowired
	private RolPermisoRepository<RolPermiso> repository;

	public void customSave(RolPermiso rolPermiso) {
		this.repository.customSave(rolPermiso);
	}
	
	public void customDelete(RolPermiso rolPermiso) {
		this.repository.customDelete(rolPermiso);
	}
}
