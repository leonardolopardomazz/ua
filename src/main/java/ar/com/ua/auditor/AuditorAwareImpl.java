package ar.com.ua.auditor;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;

import ar.com.ua.commons.ManejoSesion;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.context.SecurityContextHolder;
import jakarta.servlet.http.HttpSession;

public class AuditorAwareImpl implements AuditorAware<String> {

	@Autowired
	private ManejoSesion manejoSesion;

	@Override
	public Optional<String> getCurrentAuditor() {
		/*
		 * Authentication authentication =
		 * SecurityContextHolder.getContext().getAuthentication();
		 * 
		 * if (authentication == null || !authentication.isAuthenticated()) { return
		 * null; }
		 * 
		 * return Optional.of(authentication.getName().toUpperCase());
		 */
		try {
			HttpSession httpSession = this.manejoSesion.getHttpSession();
			String nombreUsuario = (String) httpSession.getAttribute("nombreUsuario");

			return Optional.of(nombreUsuario);
		} catch (Exception e) {
			throw e;
		}
	}
}
