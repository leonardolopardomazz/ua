package ar.com.ua.controller.report;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.ua.commons.ManejoSesion;
import ar.com.ua.model.Rol;
import jakarta.servlet.http.HttpSession;

@Component
public class AccesoReporte {

	@Autowired
	private ManejoSesion manejoSesion;

	private boolean tieneAcceso(List<Rol> roles, String rolAlRecurso) {
		for (Rol rol : roles) {
			if (rol.getDescripcion().equals(rolAlRecurso)) {
				return true;
			}
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public boolean deteminarAccesoAlRecurso(String rolAlRecurso) {
		HttpSession httpSession = this.manejoSesion.getHttpSession();
		List<Rol> roles = (List<Rol>) httpSession.getAttribute("rolesUsuario");

		if (tieneAcceso(roles, rolAlRecurso)) {
			return true;
		}
		return false;
	}

}
