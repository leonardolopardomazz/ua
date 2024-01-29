package ar.com.ua.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ua.builder.LoginResponseBuilder;
import ar.com.ua.commons.ManejoErrores;
import ar.com.ua.commons.ManejoFechas;
import ar.com.ua.commons.ManejoSesion;
import ar.com.ua.constant.CodigoRespuestaConstant;
import ar.com.ua.constant.EndPointConstant;
import ar.com.ua.constant.EndPointPathConstant;
import ar.com.ua.constant.MensajeError;
import ar.com.ua.constant.TipoMetodoConstant;
import ar.com.ua.dto.LoginResponseDTO;
import ar.com.ua.dto.UsuarioDTO;
import ar.com.ua.dto.response.ResponseDto;
import ar.com.ua.dto.response.ResponseOKDto;
import ar.com.ua.model.Login;
import ar.com.ua.model.Rol;
import ar.com.ua.model.Usuario;
import ar.com.ua.service.LoginService;
import ar.com.ua.service.ParametrosSeguridadContrasenaService;
import ar.com.ua.service.UsuarioService;
import jakarta.servlet.http.HttpSession;

@RequestMapping("/login")
@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private ParametrosSeguridadContrasenaService pscService;

	@Autowired
	private ManejoSesion manejoSesion;

	@Autowired
	private LoginResponseBuilder loginBuilder;

	private Login populateLogin(Usuario usuario, int cantidadReintentos) {
		Login login = new Login();
		login.setCantidadReintentos(cantidadReintentos);
		login.setPrimerAcceso(false);
		login.setUsuario(usuario);
		login.setFechaUltimoIntento(new Date());

		return login;
	}

	/**
	 * Obtiene el ultimo ingreso de un usuario
	 * 
	 * @param usuario
	 * @return
	 */
	private Login getLastLogin(Usuario usuario) {
		return this.loginService.findFirstByUsuarioOrderByFechaUltimoIntentoDesc(usuario);
	}

	/**
	 * Decide si tiene que bloquear un usuario dada la cantidad de reintentos
	 * previos
	 * 
	 * @param login
	 */
	private void determinarLogicaBloqueoUsuario(Login login) {
		int cantidadReintentos = login.getCantidadReintentos();
		int cantidadReintentosSistema = this.pscService.findAll().get(0).getCantidadReintentosValidos();
		Usuario usuario = login.getUsuario();

		if (cantidadReintentos >= cantidadReintentosSistema) {
			usuario.setBloqueado(true);
			this.usuarioService.save(usuario);
		}
	}

	private boolean determinarVencioElPlazoContrasena(String fechaUltimoCambioContrasena) {
		int diasPasados = ManejoFechas.calcularDiferenciaEnDiasHastaHoy(fechaUltimoCambioContrasena);
		int diasValidezContrasena = this.pscService.findAll().get(0).getDiasValidezContrasena();

		if (diasPasados > diasValidezContrasena) {
			return true;
		}
		return false;
	}

	/**
	 * Determina que objeto Login sera guardado en la tabla Login, basandose en la
	 * existencia del nombreUsuario y contrasena
	 * 
	 * @param nombreUsuario
	 * @param contrasena
	 */
	private Login loginAGuardar(String nombreUsuario, String contrasena) {
		Login loginAGuardar = new Login();
		int cantidadReintentos = 0;

		// Existe un usuario con el nombreUsuario y contrasena consultados
		if (this.usuarioService.existsByNombreUsuarioAndContrasena(nombreUsuario, contrasena)) {
			Usuario usuario = this.usuarioService.findByNombreUsuarioAndContrasena(nombreUsuario, contrasena);
			loginAGuardar = this.populateLogin(usuario, 0);

			// Existe un usuario con el nombreUsuario pero NO contrasena consultada
		} else if ((this.usuarioService.existsByNombreUsuario(nombreUsuario))) {
			Usuario usuario = this.usuarioService.findByNombreUsuario(nombreUsuario);
			Login login = this.getLastLogin(usuario);

			if (login != null)
				cantidadReintentos = login.getCantidadReintentos();

			loginAGuardar = this.populateLogin(usuario, cantidadReintentos + 1);
		}

		return loginAGuardar;
	}

	/**
	 * Guarda los roles dado un usuario en la session
	 * 
	 * @param usuario
	 * @return
	 */
	private void setFieldsInSession(Usuario usuario) {
		List<String> listRoles = new ArrayList<>();
		for (Rol rol : usuario.getRoles()) {
			listRoles.add(rol.getDescripcion());
		}

		HttpSession httpSession = this.manejoSesion.getHttpSession();
		this.manejoSesion.setAttributte(httpSession, "nombreUsuario", usuario.getNombreUsuario());
		this.manejoSesion.setAttributte(httpSession, "rolesUsuario", listRoles);
	}

	// @PreAuthorize
	@PostMapping(value = "")
	public ResponseDto login(@RequestBody UsuarioDTO dto) {
		try {
			final String nombreUsuario = dto.getNombreUsuario();
			final String contrasena = dto.getContrasena();

			// No existe un usuario con el nombreUsuario
			if (!this.usuarioService.existsByNombreUsuario(nombreUsuario)) {
				return ManejoErrores.errorGenerico(EndPointPathConstant.LOGIN, TipoMetodoConstant.POST,
						MensajeError.USER_NOT_FOUND);
			}

			Usuario usuario = this.usuarioService.findByNombreUsuario(nombreUsuario);

			if (usuario != null) {

				// Guarda los roles del usuario en la session
				this.setFieldsInSession(usuario);

				Login loginPrimerAcceso = this.loginService
						.findFirstByUsuarioAndPrimerAccesoTrueOrderByFechaReseteoContrasenaDesc(usuario);

				// Verifico si es el primer acceso del usuario sea por usuario nuevo o reinicio
				// de contrasena.
				if (loginPrimerAcceso == null) {
					return ManejoErrores.errorGenerico(EndPointPathConstant.LOGIN, TipoMetodoConstant.POST,
							MensajeError.IS_FIRST_ACCESS);
				}

				if (loginPrimerAcceso.getFechaUltimoCambioContrasena() != null) {
					String fechaUltimoCambioContrasena = loginPrimerAcceso.getFechaUltimoCambioContrasena().toString();
					if (this.determinarVencioElPlazoContrasena(fechaUltimoCambioContrasena)) {
						return ManejoErrores.errorGenerico(EndPointPathConstant.LOGIN, TipoMetodoConstant.POST,
								MensajeError.EXPIRE_PASSWORD);
					}
				}
			}

			// Verifica si el usuario esta bloqueado
			if (this.usuarioService.existsByNombreUsuarioAndBloqueadoTrue(nombreUsuario)) {
				return ManejoErrores.errorGenerico(EndPointPathConstant.LOGIN, TipoMetodoConstant.POST,
						MensajeError.USER_BLOCKED);
			}

			Login loginAGuardar = this.loginAGuardar(nombreUsuario, contrasena);

			// Guardo en la tabla Login
			Login loginGuardado = this.loginService.save(loginAGuardar);

			// Determino si bloqueo un usuario teniendo en cuenta la cantidad de reintentos
			this.determinarLogicaBloqueoUsuario(loginGuardado);

			LoginResponseDTO loginResponseDto = loginBuilder.loginToLoginResponse(loginGuardado);

			return new ResponseOKDto<LoginResponseDTO>(EndPointPathConstant.LOGIN, TipoMetodoConstant.POST,
					CodigoRespuestaConstant.OK, loginResponseDto);

		} catch (Exception e) {
			return ManejoErrores.errorGenerico(EndPointConstant.ADD, TipoMetodoConstant.POST, e.getMessage());
		}
	}

	@GetMapping(value = "primerlogin/{id}")
	public Boolean esPrimerLogin(@PathVariable Long id) {

		try {
			Optional<Usuario> value = this.usuarioService.findById(id);

			if (value.isPresent()) {
				Usuario usuario = value.get();
				Login login = this.loginService
						.findFirstByUsuarioAndPrimerAccesoTrueOrderByFechaReseteoContrasenaDesc(usuario);

				if (login != null) {
					return true;
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return false;
	}
}
