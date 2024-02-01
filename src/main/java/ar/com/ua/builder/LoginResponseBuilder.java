package ar.com.ua.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.com.ua.dto.LoginResponseDTO;
import ar.com.ua.model.Login;
import ar.com.ua.model.Permiso;
import ar.com.ua.model.Rol;
import ar.com.ua.model.Usuario;

@Component
public class LoginResponseBuilder {

	public LoginResponseDTO loginToLoginResponse(Login login) {
		LoginResponseDTO dto = new LoginResponseDTO();

		Usuario usuario = login.getUsuario();

		dto.setNombreUsuario(usuario.getNombreUsuario());
		dto.setIdUsuario(usuario.getId());
		dto.setBloqueado(usuario.isBloqueado());
		dto.setCantidadReintentos(login.getCantidadReintentos());
		dto.setFechaUltimoIntento(login.getFechaUltimoIntento());
		dto.setFechaReseteoContrasena(login.getFechaReseteoContrasena());
		dto.setPrimerAcceso(login.isPrimerAcceso());
		if (login.getCantidadReintentos() != 0) {
			dto.setPudoAcceder(false);
		} else {
			dto.setPudoAcceder(true);
		}
		
		List<Rol> listRoles = usuario.getRoles();
		
		List<String> rolesDescripcion = new ArrayList<>();
		for (Rol rol : listRoles) {
			rolesDescripcion.add(rol.getDescripcion());
		}
		dto.setRoles(rolesDescripcion);
		
		List<String> permisosDescripcion = new ArrayList<>();
		for (Rol rol : listRoles) {
			for (Permiso permiso : rol.getPermisos()) {
				permisosDescripcion.add(permiso.getDescripcion());
			}
		}
		dto.setPermisos(permisosDescripcion);

		return dto;
	}

}
