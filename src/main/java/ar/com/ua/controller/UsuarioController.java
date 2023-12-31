package ar.com.ua.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ua.builder.UsuarioBuilder;
import ar.com.ua.constant.CodigoRespuestaConstant;
import ar.com.ua.constant.EndPointConstant;
import ar.com.ua.constant.EndPointPathConstant;
import ar.com.ua.constant.MensajeError;
import ar.com.ua.constant.TipoMetodoConstant;
import ar.com.ua.dto.UsuarioDTO;
import ar.com.ua.dto.response.ResponseDto;
import ar.com.ua.dto.response.ResponseErrorDto;
import ar.com.ua.dto.response.ResponseOKDto;
import ar.com.ua.dto.response.ResponseOKListDto;
import ar.com.ua.model.Usuario;
import ar.com.ua.service.EmpleadoService;
import ar.com.ua.service.UsuarioService;

@RequestMapping("/usuario")
@RestController
public class UsuarioController implements IABMController<UsuarioDTO>, IListController<UsuarioDTO> {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private EmpleadoService empleadoService;

	@Autowired
	private UsuarioBuilder usuarioBuilder;

	static Logger logger = Logger.getLogger(UsuarioController.class.getName());
	
	/**
	 * Validacion existe Numero legajo en la tabla Empleado
	 * @param dto
	 * @throws Exception
	 */
	private void existeNumeroLegajo(UsuarioDTO dto) throws Exception {
		boolean existeNumeroLegajo = this.empleadoService.existsByNumeroLegajo(dto.getNumeroLegajo());
		if(!existeNumeroLegajo) {throw new Exception("El numero de legajo no existe en la tabla usuario");}
	}

	private ResponseDto save(Long id, UsuarioDTO dto, String tipoMetodoConstant) {
		// Setteo el id para la actualizacion
		dto.setId(id);
		return this.save(dto, tipoMetodoConstant);
	}

	private ResponseDto save(UsuarioDTO dto, String tipoMetodoConstant) {
		try {
			Usuario usuario = usuarioBuilder.dtoToModel(dto);

			//Validacion existe Numero legajo en la tabla Empleado
			this.existeNumeroLegajo(dto);
			
			Usuario usuarioGuardado = usuarioService.save(usuario);
			UsuarioDTO usuarioDto = usuarioBuilder.modelToDto(usuarioGuardado);
			return new ResponseOKDto<UsuarioDTO>(EndPointPathConstant.USUARIO, tipoMetodoConstant,
					CodigoRespuestaConstant.OK, usuarioDto);
		} catch (Exception e) {
			List<String> mensajesError = new ArrayList<String>();
			String messageException = e.getMessage();
			mensajesError.add(messageException);

			return new ResponseErrorDto(EndPointPathConstant.USUARIO, tipoMetodoConstant, CodigoRespuestaConstant.ERROR,
					mensajesError);
		}
	}

	/**
	 * Inserta un usuario a la tabla
	 * 
	 * @return ResponseDto
	 */
	@Override
	public ResponseDto add(UsuarioDTO dto) {
		return this.save(dto, TipoMetodoConstant.POST);
	}

	/**
	 * Actualiza un usuario en la tabla
	 */
	@Override
	public ResponseDto modify(@PathVariable Long id, UsuarioDTO dto) {
		return this.save(id, dto, TipoMetodoConstant.PUT);
	}

	/**
	 * Elimina un usuario de la tabla
	 */
	@Override
	public ResponseDto deleteById(@PathVariable Long id) {

		try {
			usuarioService.deleteById(id);

			return new ResponseOKDto<UsuarioDTO>(EndPointConstant.DELETE, TipoMetodoConstant.DELETE,
					CodigoRespuestaConstant.OK, null);
		} catch (Exception e) {
			List<String> mensajesError = new ArrayList<String>();
			String messageException = e.getMessage();
			mensajesError.add(messageException);
			return new ResponseErrorDto(EndPointConstant.DELETE, TipoMetodoConstant.DELETE,
					CodigoRespuestaConstant.ERROR, mensajesError);
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
				List<String> mensajesError = new ArrayList<String>();
				mensajesError.add(MensajeError.ELEMENT_NOTFOUND_MESSAGE);

				return new ResponseErrorDto(EndPointConstant.FIND_ONE, TipoMetodoConstant.GET,
						CodigoRespuestaConstant.ERROR, mensajesError);
			}
		} catch (Exception e) {
			List<String> mensajesError = new ArrayList<String>();
			String messageException = e.getMessage();
			mensajesError.add(messageException);
			return new ResponseErrorDto(EndPointConstant.FIND_ONE, TipoMetodoConstant.GET,
					CodigoRespuestaConstant.ERROR, mensajesError);
		}
	}

	@Override
	public ResponseDto findAny(@RequestParam Map<String, String> params) {

		try {
			String nombreUsuario = params.get("nombreUsuario");

			List<Usuario> listUsuarios = usuarioService.findByNombreUsuario(nombreUsuario);

			if (!listUsuarios.isEmpty()) {
				List<UsuarioDTO> listUsuariosDto = usuarioBuilder.modelListToDto(listUsuarios);

				return new ResponseOKListDto<UsuarioDTO>(EndPointConstant.FIND_ANY, TipoMetodoConstant.GET,
						CodigoRespuestaConstant.OK, listUsuariosDto);
			} else {
				List<String> mensajesError = new ArrayList<String>();
				mensajesError.add(MensajeError.ELEMENT_NOTFOUND_MESSAGE);

				return new ResponseErrorDto(EndPointConstant.FIND_ANY, TipoMetodoConstant.GET,
						CodigoRespuestaConstant.ERROR, mensajesError);
			}

		} catch (Exception e) {
			List<String> mensajesError = new ArrayList<String>();
			String messageException = e.getMessage();
			mensajesError.add(messageException);
			return new ResponseErrorDto(EndPointConstant.FIND_ANY, TipoMetodoConstant.GET,
					CodigoRespuestaConstant.ERROR, mensajesError);
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
			String messageException = e.getMessage();
			List<String> mensajes = new ArrayList<>();
			mensajes.add(messageException);
			return new ResponseErrorDto(EndPointConstant.FIND_ALL, TipoMetodoConstant.GET,
					CodigoRespuestaConstant.ERROR, mensajes);
		}
	}

}
