package ar.com.ua.controller.report;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.ua.commons.ManejoSesion;
import ar.com.ua.model.Permiso;
import ar.com.ua.model.Rol;
import jakarta.servlet.http.HttpSession;

@Component
public class AccesoPermiso {

	@Autowired
	private ManejoSesion manejoSesion;

	private boolean tieneAcceso(List<Rol> roles, String permisoAlRecurso) {
		for (Rol rol : roles) {
			for (Permiso permiso : rol.getPermisos()) {
				if (permiso.getCodigo().equals(permisoAlRecurso)) {
					return true;
				}
			}
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public boolean deteminarAccesoAlRecurso(String permisoAlRecurso) {
		HttpSession httpSession = this.manejoSesion.getHttpSession();
		List<Rol> roles = (List<Rol>) httpSession.getAttribute("rolesUsuario");

		if (tieneAcceso(roles, permisoAlRecurso)) {
			return true;
		}
		return false;
	}

}
