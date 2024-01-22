package ar.com.ua.builder;

import org.springframework.stereotype.Component;

import ar.com.ua.dto.LoginResponseDTO;
import ar.com.ua.model.Login;
import ar.com.ua.model.Usuario;

@Component
public class LoginResponseBuilder {

	public LoginResponseDTO loginToLoginResponse(Login login) {
		LoginResponseDTO dto = new LoginResponseDTO();
		
		Usuario usuario = login.getUsuario();

		dto.setNombreUsuario(usuario.getNombreUsuario());
		dto.setBloqueado(usuario.isBloqueado());
		dto.setCantidadReintentos(login.getCantidadReintentos());
		dto.setFechaUltimoIntento(login.getFechaUltimoIntento());
		dto.setFechaReseteoContrasena(login.getFechaReseteoContrasena());
		dto.setPrimerAcceso(login.isPrimerAcceso());
		
		return dto;
	}

}
