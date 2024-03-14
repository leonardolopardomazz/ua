package ar.com.ua.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ua.builder.UsuarioBuilder;
import ar.com.ua.commons.ManejoErrores;
import ar.com.ua.constant.CodigoRespuestaConstant;
import ar.com.ua.constant.EndPointConstant;
import ar.com.ua.constant.EndPointPathConstant;
import ar.com.ua.constant.MensajeError;
import ar.com.ua.constant.PermisosConstant;
import ar.com.ua.constant.TipoMetodoConstant;
import ar.com.ua.controller.report.AccesoPermiso;
import ar.com.ua.dto.ContrasenaDTO;
import ar.com.ua.dto.UsuarioDTO;
import ar.com.ua.dto.response.ResponseDto;
import ar.com.ua.dto.response.ResponseErrorDto;
import ar.com.ua.dto.response.ResponseOKDto;
import ar.com.ua.dto.response.ResponseOKListDto;
import ar.com.ua.model.HistoricoContrasena;
import ar.com.ua.model.Login;
import ar.com.ua.model.SeguridadContrasena;
import ar.com.ua.model.Usuario;
import ar.com.ua.service.EmpleadoService;
import ar.com.ua.service.HistoricoContrasenaService;
import ar.com.ua.service.LoginService;
import ar.com.ua.service.SeguridadContrasenaService;
import ar.com.ua.service.UsuarioService;
import ar.com.ua.utils.PasswordEncrypt;

@RequestMapping("/usuario")
@RestController
public class UsuarioController implements IABMController<UsuarioDTO>, IListController<UsuarioDTO> {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private EmpleadoService empleadoService;

	@Autowired
	private HistoricoContrasenaService hcService;

	@Autowired
	private LoginService loginService;

	@Autowired
	private SeguridadContrasenaService scService;

	@Autowired
	private UsuarioBuilder usuarioBuilder;

	@Autowired
	private AccesoPermiso accesoPermiso;

	static Logger logger = Logger.getLogger(UsuarioController.class.getName());

	private HistoricoContrasena populateHistoricoContrasena(Usuario usuario) {
		HistoricoContrasena hc = new HistoricoContrasena();
		hc.setUsuario(usuario);
		hc.setFechaCambioContrasena(new Date());
		hc.setContrasena(usuario.getContrasena());

		return hc;
	}

	private Login populateLogin(Usuario usuario) {
		Login login = new Login();
		login.setCantidadReintentos(0);
		login.setUsuario(usuario);
		login.setPrimerAcceso(true);
		login.setFechaReseteoContrasena(new Date());

		return login;
	}

	/**
	 * Valida si la contrasena cumple la dureza proporcionada por seguridad
	 * informatica
	 * 
	 * @param contrasena
	 * @return
	 */
	private boolean validarContrasenaConRegex(String contrasena) {
		SeguridadContrasena sc = this.scService.findFirstByActivoTrueOrderByIdAsc();
		String patron = sc.getPatron();
		Pattern pattern = Pattern.compile(patron);
		Matcher matcher = pattern.matcher(contrasena);

		return matcher.matches();
	}

	/**
	 * Verifico si la contrasena ingresada no existe en las ultimas 5 ingresadas
	 * 
	 * @param contrasena
	 * @return
	 */
	private boolean noExisteEnHistoricoContrasena(Usuario usuario, String contrasena) {
		List<HistoricoContrasena> hcList = this.hcService.findTop5ByUsuarioOrderByFechaCambioContrasenaAsc(usuario);

		for (HistoricoContrasena historicoContrasena : hcList) {
			if (historicoContrasena.getContrasena().equals(contrasena)) {
				return false;
			}
		}

		return true;
	}

	/**
	 * 
	 * @param messageError
	 * @return
	 */
	private ResponseErrorDto manejoErrorCambiarContrasena(String messageError) {
		List<String> mensajesError = new ArrayList<String>();
		mensajesError.add(messageError);

		return new ResponseErrorDto(EndPointConstant.FIND_ONE, TipoMetodoConstant.GET, CodigoRespuestaConstant.ERROR,
				mensajesError);
	}

	/**
	 * 
	 * @param messageError
	 * @param tipoMetodoConstant
	 * @return
	 */
	private ResponseErrorDto manejoErrorGuardar(String messageError, String tipoMetodoConstant) {
		List<String> mensajesError = new ArrayList<String>();
		String messageException = messageError;
		mensajesError.add(messageException);

		return new ResponseErrorDto(EndPointPathConstant.USUARIO, tipoMetodoConstant, CodigoRespuestaConstant.ERROR,
				mensajesError);
	}

	/**
	 * Validacion existe Numero legajo en la tabla Empleado
	 * 
	 * @param dto
	 * @throws Exception
	 */
	private void existeNumeroLegajo(UsuarioDTO dto) throws Exception {
		boolean existeNumeroLegajo = this.empleadoService.existsByNumeroLegajo(dto.getNumeroLegajo());
		if (!existeNumeroLegajo) {
			throw new Exception("El numero de legajo no existe en la tabla empleado");
		}
	}

	private ResponseDto save(Long id, UsuarioDTO dto, String tipoMetodoConstant) {
		// Setteo el id para la actualizacion
		dto.setId(id);
		return this.save(dto, tipoMetodoConstant);
	}

	private ResponseDto save(UsuarioDTO dto, String tipoMetodoConstant) {
		try {
			Usuario usuarioAGuardar = usuarioBuilder.dtoToModel(dto);

			// Validacion existe Numero legajo en la tabla Empleado
			this.existeNumeroLegajo(dto);

			if (tipoMetodoConstant.equals(TipoMetodoConstant.POST)) {
				// Encripto la contrasena para guardarla
				usuarioAGuardar.setContrasena(PasswordEncrypt.encrypt(usuarioAGuardar.getContrasena()));
			}

			Usuario usuarioGuardado = usuarioService.save(usuarioAGuardar);
			UsuarioDTO usuarioDto = usuarioBuilder.modelToDto(usuarioGuardado);

			if (tipoMetodoConstant.equals(TipoMetodoConstant.POST)) {
				this.marcarUsuarioPrimerIngreso(usuarioGuardado);
			}

			return new ResponseOKDto<UsuarioDTO>(EndPointPathConstant.USUARIO, tipoMetodoConstant,
					CodigoRespuestaConstant.OK, usuarioDto);

		} catch (Exception e) {
			return this.manejoErrorGuardar(e.getMessage(), tipoMetodoConstant);
		}
	}

	/**
	 * Genera una contrasena aleatoria
	 * 
	 * @return
	 */
	private String generateRandomPassword() {
		String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";
		String contrasena = RandomStringUtils.random(15, caracteres);
		return contrasena;
	}

	/**
	 * Inserta un registro en la tabla de Login para marcar como primer ingreso a un
	 * usuario
	 * 
	 * @param dto
	 */
	private void marcarUsuarioPrimerIngreso(Usuario usuario) {
		try {
			Login loginAGuardar = populateLogin(usuario);
			this.loginService.save(loginAGuardar);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Inserta un usuario a la tabla
	 * 
	 * @return ResponseDto
	 */
	@Override
	public ResponseDto add(UsuarioDTO dto) {
		try {
			// Chequeo de acceso al reporte
			boolean tieneAcceso = this.accesoPermiso.deteminarAccesoAlRecurso(PermisosConstant.PERMISO_USUARIO_ALTA);

			if (!tieneAcceso) {
				return ManejoErrores.errorGenerico(EndPointConstant.ADD, TipoMetodoConstant.POST,
						MensajeError.ACCESS_DENIED);
			}

			return this.save(dto, TipoMetodoConstant.POST);
		} catch (Exception e) {
			return ManejoErrores.errorGenerico(EndPointConstant.ADD, TipoMetodoConstant.POST, e.getMessage());
		}

	}

	/**
	 * Actualiza un usuario en la tabla
	 */
	@Override
	public ResponseDto modify(@PathVariable Long id, UsuarioDTO dto) {
		try {
			// Chequeo de acceso al reporte
			boolean tieneAcceso = this.accesoPermiso
					.deteminarAccesoAlRecurso(PermisosConstant.PERMISO_USUARIO_MODIFICACION);

			if (!tieneAcceso) {
				return ManejoErrores.errorGenerico(EndPointConstant.MODIFY, TipoMetodoConstant.PUT,
						MensajeError.ACCESS_DENIED);
			}

			return this.save(id, dto, TipoMetodoConstant.PUT);

		} catch (Exception e) {
			return ManejoErrores.errorGenerico(EndPointConstant.MODIFY, TipoMetodoConstant.PUT, e.getMessage());
		}
	}

	/**
	 * Elimina un usuario de la tabla
	 */
	@Override
	public ResponseDto deleteById(@PathVariable Long id) {

		try {
			// Chequeo de acceso al reporte
			boolean tieneAcceso = this.accesoPermiso.deteminarAccesoAlRecurso(PermisosConstant.PERMISO_USUARIO_BAJA);

			if (!tieneAcceso) {
				return ManejoErrores.errorGenerico(EndPointConstant.DELETE, TipoMetodoConstant.DELETE,
						MensajeError.ACCESS_DENIED);
			}

			usuarioService.deleteById(id);

			return new ResponseOKDto<UsuarioDTO>(EndPointConstant.DELETE, TipoMetodoConstant.DELETE,
					CodigoRespuestaConstant.OK, null);
		} catch (Exception e) {
			return ManejoErrores.errorGenerico(EndPointConstant.DELETE, TipoMetodoConstant.DELETE, e.getMessage());
		}
	}

	@Override
	public ResponseDto findOne(@PathVariable Long id) {
		try {
			Optional<Usuario> value = usuarioService.findById(id);
			if (value.isPresent()) {
				Usuario usuario = value.get();

				UsuarioDTO usuarioDto = usuarioBuilder.modelToDto(usuario);

				return new ResponseOKDto<UsuarioDTO>(EndPointConstant.FIND_ONE, TipoMetodoConstant.GET,
						CodigoRespuestaConstant.OK, usuarioDto);
			} else {
				return ManejoErrores.errorGenerico(EndPointConstant.FIND_ONE, TipoMetodoConstant.GET,
						MensajeError.ELEMENT_NOTFOUND_MESSAGE);
			}
		} catch (Exception e) {
			return ManejoErrores.errorGenerico(EndPointConstant.FIND_ONE, TipoMetodoConstant.GET, e.getMessage());
		}
	}

	@Override
	public ResponseDto findAny(@RequestParam Map<String, String> params) {

		try {
			String nombreUsuario = params.get("nombreUsuario");

			List<Usuario> listUsuarios = usuarioService.findByNombreUsuarioLike(nombreUsuario);

			if (!listUsuarios.isEmpty()) {
				List<UsuarioDTO> listUsuariosDto = usuarioBuilder.modelListToDto(listUsuarios);

				return new ResponseOKListDto<UsuarioDTO>(EndPointConstant.FIND_ANY, TipoMetodoConstant.GET,
						CodigoRespuestaConstant.OK, listUsuariosDto);
			} else {
				return ManejoErrores.errorGenerico(EndPointConstant.FIND_ANY, TipoMetodoConstant.GET,
						MensajeError.ELEMENT_NOTFOUND_MESSAGE);
			}

		} catch (Exception e) {
			return ManejoErrores.errorGenerico(EndPointConstant.FIND_ANY, TipoMetodoConstant.GET, e.getMessage());
		}
	}

	@Override
	public ResponseDto findAll() {
		try {
			// List
			List<Usuario> usuarios = (ArrayList<Usuario>) usuarioService.findAll();

			// Build Model List to Dto List
			List<UsuarioDTO> usuariosDto = usuarioBuilder.modelListToDto(usuarios);

			// return
			return new ResponseOKListDto<UsuarioDTO>(EndPointConstant.FIND_ALL, TipoMetodoConstant.GET,
					CodigoRespuestaConstant.OK, usuariosDto);

		} catch (Exception e) {
			return ManejoErrores.errorGenerico(EndPointConstant.FIND_ALL, TipoMetodoConstant.GET, e.getMessage());
		}
	}

	// Metodos para el caso de uso de Login

	@PutMapping(value = "/cambiarcontrasena/{id}")
	public ResponseDto cambiarContrasena(@PathVariable Long id, @RequestBody UsuarioDTO dto) {
		try {
			final String contrasenaIngresada = dto.getContrasena();

			Optional<Usuario> value = this.usuarioService.findById(id);

			if (value.isPresent()) {
				Usuario usuario = value.get();
				usuario.setContrasena(dto.getContrasena());

				// Valida la contrasena ingresada con la regex proporcionada por seguridad
				// informatica
				if (!this.validarContrasenaConRegex(contrasenaIngresada)) {
					return this.manejoErrorGuardar(MensajeError.PATTERN_NO_VALID, MensajeError.PATTERN_NO_VALID);
				}

				// Verifico si la contrasena ingresada no existe en las ultimas 5 ingresadas

				String contrasenaEncriptada = PasswordEncrypt.encrypt(contrasenaIngresada);

				if (noExisteEnHistoricoContrasena(usuario, contrasenaEncriptada)) {
					// Encripto la contrasena antes de guardarla
					usuario.setContrasena(contrasenaEncriptada);
					this.usuarioService.save(usuario);

					HistoricoContrasena hc = populateHistoricoContrasena(usuario);
					this.hcService.save(hc);

					Login login = new Login();
					login.setUsuario(usuario);
					login.setPrimerAcceso(false);
					this.loginService.save(login);

					UsuarioDTO usuarioDTO = this.usuarioBuilder.modelToDto(usuario);

					return new ResponseOKDto<UsuarioDTO>(EndPointPathConstant.CAMBIAR_CONTRASENA,
							TipoMetodoConstant.PUT, CodigoRespuestaConstant.OK, usuarioDTO);
				} else {
					return this.manejoErrorCambiarContrasena(MensajeError.REPEATED_PASSWORD);
				}
			} else {
				return this.manejoErrorCambiarContrasena(MensajeError.USER_NOT_FOUND);
			}
		} catch (Exception e) {
			return this.manejoErrorCambiarContrasena(e.getMessage());
		}
	}

	@GetMapping(value = "/resetear/{id}")
	public ResponseDto resetearContrasena(@PathVariable Long id) {

		ContrasenaDTO contrasenaDTO = new ContrasenaDTO();

		try {
			Optional<Usuario> value = this.usuarioService.findById(id);
			if (value.isPresent()) {
				Usuario usuario = value.get();

				final String randomPassword = this.generateRandomPassword();
				usuario.setContrasena(PasswordEncrypt.encrypt(randomPassword));

				// Marco el usuario como primer acceso para que cambie la contrasena
				this.marcarUsuarioPrimerIngreso(usuario);

				// Convierto el usuario a dto
				contrasenaDTO.setContrasena(randomPassword);

				this.usuarioService.save(usuario);
			}
		} catch (Exception e) {
			return ManejoErrores.errorGenerico(EndPointConstant.FIND_ONE, TipoMetodoConstant.GET, e.getMessage());
		}

		return new ResponseOKDto<ContrasenaDTO>(EndPointPathConstant.DESBLOQUEAR_USUARIO, TipoMetodoConstant.GET,
				CodigoRespuestaConstant.OK, contrasenaDTO);
	}

	@GetMapping(value = "/desbloquear/{id}")
	public ResponseDto desbloquearUsuario(@PathVariable Long id) {
		try {
			Optional<Usuario> value = this.usuarioService.findById(id);
			if (value.isPresent()) {
				Usuario usuario = value.get();
				usuario.setBloqueado(false);

				final String randomPassword = this.generateRandomPassword();
				usuario.setContrasena(PasswordEncrypt.encrypt(randomPassword));

				// Marco el usuario como primer acceso para que cambie la contrasena
				this.marcarUsuarioPrimerIngreso(usuario);

				// Convierto el usuario a dto
				UsuarioDTO usuarioDTO = this.usuarioBuilder.modelToDto(usuario);
				usuarioDTO.setContrasena(randomPassword);

				// Guardo el usuario
				this.usuarioService.save(usuario);

				return new ResponseOKDto<UsuarioDTO>(EndPointPathConstant.DESBLOQUEAR_USUARIO, TipoMetodoConstant.GET,
						CodigoRespuestaConstant.OK, usuarioDTO);
			} else {
				List<String> mensajesError = new ArrayList<String>();
				mensajesError.add(MensajeError.ELEMENT_NOTFOUND_MESSAGE);

				return new ResponseErrorDto(EndPointConstant.FIND_ONE, TipoMetodoConstant.GET,
						CodigoRespuestaConstant.ERROR, mensajesError);
			}
		} catch (Exception e) {
			return ManejoErrores.errorGenerico(EndPointConstant.FIND_ONE, TipoMetodoConstant.GET, e.getMessage());
		}
	}

	@GetMapping(value = "/existeusuarioactivo/{nombreUsuario}")
	public Boolean findUsuarioActivo(@PathVariable String nombreUsuario) {
		try {
			return this.usuarioService.existsByNombreUsuarioAndActivoTrue(nombreUsuario);
		} catch (Exception e) {
			e.printStackTrace();
			return Boolean.FALSE;
		}
	}

}
