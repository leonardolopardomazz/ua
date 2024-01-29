package ar.com.ua.controller.report;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.ua.commons.ManejoSesion;
import jakarta.servlet.http.HttpSession;

@Component
public class AccesoReporte {

	@Autowired
	private ManejoSesion manejoSesion;

	private boolean tieneAcceso(List<String> roles, String rolAcceso) {
		for (String rol : roles) {
			if (rol.equals(rolAcceso)) {
				return true;
			}
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public boolean deteminarAccesoAlRecurso(String endPointPathConstant, String tipoMetodoConstant, String permiso) {
		HttpSession httpSession = this.manejoSesion.getHttpSession();
		List<String> roles = (List<String>) httpSession.getAttribute("rolesUsuario");

		if (tieneAcceso(roles, permiso)) {
			return true;
		}
		return false;
	}

}
