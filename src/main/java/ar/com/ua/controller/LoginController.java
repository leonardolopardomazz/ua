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
import ar.com.ua.dto.SesionDTO;
import ar.com.ua.dto.UsuarioDTO;
import ar.com.ua.dto.response.ResponseDto;
import ar.com.ua.dto.response.ResponseOKDto;
import ar.com.ua.model.Login;
import ar.com.ua.model.Permiso;
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

	private Login populateLogin(Usuario usuario, int cantidadReintentos, boolean isPrimerAcceso) {
		Login login = new Login();
		login.setCantidadReintentos(cantidadReintentos);
		login.setPrimerAcceso(isPrimerAcceso);
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
		return this.loginService.findFirstByUsuarioOrderByIdDesc(usuario);
	}

	/**
	 * Decide si tiene que bloquear un usuario dada la cantidad de reintentos
	 * previos
	 * 
	 * @param login
	 */
	private void determinarLogicaBloqueoUsuario(Login login) {
		int cantidadReintentos = login.getCantidadReintentos();
		int cantidadReintentosSistema = this.pscService.findFirstByActivoTrue().getCantidadReintentosValidos();
		Usuario usuario = login.getUsuario();

		if (cantidadReintentos >= cantidadReintentosSistema) {
			usuario.setBloqueado(true);
			this.usuarioService.save(usuario);
		}
	}

	private boolean determinarVencioElPlazoContrasena(String fechaUltimoCambioContrasena) {
		int diasPasados = ManejoFechas.calcularDiferenciaEnDiasHastaHoy(fechaUltimoCambioContrasena);
		int diasValidezContrasena = this.pscService.findFirstByActivoTrue().getDiasValidezContrasena();

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
			Login login = this.getLastLogin(usuario);
			loginAGuardar = this.populateLogin(usuario, 0, login.isPrimerAcceso());

			// Existe un usuario con el nombreUsuario pero NO contrasena consultada
		} else if (this.usuarioService.existsByNombreUsuario(nombreUsuario)) {
			Usuario usuario = this.usuarioService.findByNombreUsuario(nombreUsuario);

			Login login = this.getLastLogin(usuario);

			if (login != null)
				cantidadReintentos = login.getCantidadReintentos();

			loginAGuardar = this.populateLogin(usuario, cantidadReintentos + 1, login.isPrimerAcceso());
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
		HttpSession httpSession = this.manejoSesion.getHttpSession();
		this.manejoSesion.setAttributte(httpSession, "nombreUsuario", usuario.getNombreUsuario());
		this.manejoSesion.setAttributteRol(httpSession, "rolesUsuario", usuario.getRoles());

		List<Permiso> permisos = new ArrayList<>();
		for (Rol rol : usuario.getRoles()) {
			permisos = rol.getPermisos();
		}

		this.manejoSesion.setAttributtePermisos(httpSession, "permisosUsuario", permisos);
	}

	@GetMapping(value = "/isalive")
	public ResponseDto isSessionActive () {
		try {
			SesionDTO dto = new SesionDTO();
			
			if(manejoSesion.getHttpSession().getAttribute("nombreUsuario") != null) {
				dto.setActivo(true);
			}
			
			return new ResponseOKDto<SesionDTO>(EndPointPathConstant.LOGIN, TipoMetodoConstant.POST,
					CodigoRespuestaConstant.OK, dto);
		} catch (Exception e) {
			return ManejoErrores.errorGenerico(EndPointPathConstant.LOGIN, TipoMetodoConstant.POST,
					MensajeError.ERROR_SESSION);
		}
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

			// Verifica si el usuario esta bloqueado
			if (this.usuarioService.existsByNombreUsuarioAndBloqueadoTrue(nombreUsuario)) {
				return ManejoErrores.errorGenerico(EndPointPathConstant.LOGIN, TipoMetodoConstant.POST,
						MensajeError.USER_BLOCKED);
			}

			Login loginAGuardar = this.loginAGuardar(nombreUsuario, contrasena);

			// Valida la fecha de expiracion de la contrasena
			if (loginAGuardar.getFechaUltimoCambioContrasena() != null) {
				String fechaUltimoCambioContrasena = loginAGuardar.getFechaUltimoCambioContrasena().toString();
				if (this.determinarVencioElPlazoContrasena(fechaUltimoCambioContrasena)) {
					return ManejoErrores.errorGenerico(EndPointPathConstant.LOGIN, TipoMetodoConstant.POST,
							MensajeError.EXPIRE_PASSWORD);
				}
			}

			Usuario usuario = loginAGuardar.getUsuario();

			//Para el caso donde al usuario se lo desbloquea/resetea, pero ingresa contrasena invalida
			if (!this.usuarioService.existsByNombreUsuarioAndContrasena(nombreUsuario, contrasena)) {
				this.loginService.save(loginAGuardar);
				
				// Determino si bloqueo un usuario teniendo en cuenta la cantidad de reintentos
				this.determinarLogicaBloqueoUsuario(loginAGuardar);
				
				return ManejoErrores.errorGenerico(EndPointPathConstant.LOGIN, TipoMetodoConstant.POST,
						MensajeError.USER_NOT_FOUND);
			}

			// Guarda los roles del usuario en la session
			this.setFieldsInSession(usuario);

			Login loginPrimerAcceso = this.loginService
					.findFirstByUsuarioAndPrimerAccesoTrueOrderByFechaReseteoContrasenaDesc(usuario);

			Login loginPosterior = this.loginService
					.findFirstByUsuarioAndPrimerAccesoFalseOrderByFechaReseteoContrasenaDesc(usuario);

			if (loginPosterior == null) {
				// Verifico si es el primer acceso del usuario sea por usuario nuevo o reinicio
				// de contrasena.
				if (loginPrimerAcceso != null) {
					LoginResponseDTO loginResponseDto = loginBuilder.loginToLoginResponse(loginPrimerAcceso);

					if (!this.usuarioService.existsByNombreUsuarioAndContrasena(nombreUsuario, contrasena)) {
						return ManejoErrores.errorGenerico(EndPointPathConstant.LOGIN, TipoMetodoConstant.POST,
								MensajeError.USER_NOT_FOUND);
					}

					return new ResponseOKDto<LoginResponseDTO>(EndPointPathConstant.LOGIN, TipoMetodoConstant.POST,
							CodigoRespuestaConstant.OK, loginResponseDto);
				}
			}

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
