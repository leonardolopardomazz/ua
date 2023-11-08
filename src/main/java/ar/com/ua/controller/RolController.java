package ar.com.ua.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ua.builder.RolBuilder;
import ar.com.ua.builder.RolPermisoBuilder;
import ar.com.ua.builder.RolUsuarioBuilder;
import ar.com.ua.constant.CodigoRespuestaConstant;
import ar.com.ua.constant.EndPointConstant;
import ar.com.ua.constant.EndPointPathConstant;
import ar.com.ua.constant.MensajeError;
import ar.com.ua.constant.TipoMetodoConstant;
import ar.com.ua.dto.RolDTO;
import ar.com.ua.dto.RolPermisoDTO;
import ar.com.ua.dto.RolUsuarioDTO;
import ar.com.ua.dto.response.ResponseDto;
import ar.com.ua.dto.response.ResponseErrorDto;
import ar.com.ua.dto.response.ResponseOKDto;
import ar.com.ua.dto.response.ResponseOKListDto;
import ar.com.ua.model.Rol;
import ar.com.ua.model.RolPermiso;
import ar.com.ua.model.RolUsuario;
import ar.com.ua.service.RolPermisoService;
import ar.com.ua.service.RolService;
import ar.com.ua.service.RolUsuarioService;

@RequestMapping("/rol")
@RestController
public class RolController implements IABMController<RolDTO>, IListController<RolDTO> {

	@Autowired
	private RolService rolService;

	@Autowired
	private RolUsuarioService rolUsuarioService;

	@Autowired
	private RolPermisoService rolPermisoService;

	@Autowired
	private RolBuilder rolBuilder;

	@Autowired
	private RolUsuarioBuilder rolUsuarioBuilder;

	@Autowired
	private RolPermisoBuilder rolPermisoBuilder;

	static Logger logger = Logger.getLogger(RolController.class.getName());

	private ResponseDto save(Long id, RolDTO dto, String tipoMetodoConstant) {
		// Setteo el id para la actualizacion
		dto.setCodigo(id);
		return this.save(dto, tipoMetodoConstant);
	}

	private ResponseDto save(RolDTO dto, String tipoMetodoConstant) {
		List<String> mensajesError = new ArrayList<String>();

		try {
			Rol rol = rolBuilder.dtoToModel(dto);
			Rol rolGuardado = rolService.save(rol);
			RolDTO rolDto = rolBuilder.modelToDto(rolGuardado);
			return new ResponseOKDto<RolDTO>(EndPointPathConstant.ROL, tipoMetodoConstant, CodigoRespuestaConstant.OK,
					rolDto);
		} catch (Exception e) {
			String messageException = e.getMessage();
			mensajesError.add(messageException);

			return new ResponseErrorDto(EndPointPathConstant.ROL, tipoMetodoConstant, CodigoRespuestaConstant.ERROR,
					mensajesError);
		}
	}

	/**
	 * Inserta un rol a la tabla
	 * 
	 * @return ResponseDto
	 */
	@Override
	public ResponseDto add(RolDTO dto) {
		return this.save(dto, TipoMetodoConstant.POST);
	}

	/**
	 * Actualiza un rol en la tabla
	 */
	@Override
	public ResponseDto modify(@PathVariable Long id, RolDTO dto) {
		return this.save(id, dto, TipoMetodoConstant.PUT);
	}

	/**
	 * Elimina un rol de la tabla
	 */
	@Override
	public ResponseDto deleteById(@PathVariable Long id) {
		List<String> mensajesError = new ArrayList<String>();

		try {
			rolService.deleteById(id);

			return new ResponseOKDto<RolDTO>(EndPointConstant.DELETE, TipoMetodoConstant.DELETE,
					CodigoRespuestaConstant.OK, null);
		} catch (Exception e) {
			String messageException = e.getMessage();
			mensajesError.add(messageException);
			return new ResponseErrorDto(EndPointConstant.DELETE, TipoMetodoConstant.DELETE,
					CodigoRespuestaConstant.ERROR, mensajesError);
		}
	}

	// Relacion roles-usuarios
	@PostMapping(value = "/usuario")
	public ResponseDto addRolToUsuario(@RequestBody RolUsuarioDTO dto) {
		try {
			RolUsuario rolUsuario = rolUsuarioBuilder.dtoToModel(dto);
			this.rolUsuarioService.customSave(rolUsuario);

			return new ResponseOKDto<RolDTO>(EndPointConstant.ADD, TipoMetodoConstant.POST, CodigoRespuestaConstant.OK,
					null);
		} catch (Exception e) {
			List<String> mensajesError = new ArrayList<String>();
			String messageException = e.getMessage();
			mensajesError.add(messageException);
			return new ResponseErrorDto(EndPointConstant.ADD, TipoMetodoConstant.POST, CodigoRespuestaConstant.ERROR,
					mensajesError);
		}
	}

	// Relacion roles-permisos
	@PostMapping(value = "/permiso")
	public ResponseDto addRolToPermiso(@RequestBody RolPermisoDTO dto) {
		try {
			RolPermiso rolPermiso = rolPermisoBuilder.dtoToModel(dto);
			this.rolPermisoService.customSave(rolPermiso);

			return new ResponseOKDto<RolDTO>(EndPointConstant.ADD, TipoMetodoConstant.POST, CodigoRespuestaConstant.OK,
					null);
		} catch (Exception e) {
			List<String> mensajesError = new ArrayList<String>();
			String messageException = e.getMessage();
			mensajesError.add(messageException);
			return new ResponseErrorDto(EndPointConstant.ADD, TipoMetodoConstant.POST, CodigoRespuestaConstant.ERROR,
					mensajesError);
		}
	}

	@Override
	public ResponseDto findOne(Long id) {
		// Get model object
		Optional<Rol> value = rolService.findById(id);
		if (value.isPresent()) {
			Rol rol = value.get();

			// Builder Model to Dto
			RolDTO rolDto = rolBuilder.modelToDto(rol);

			// return
			return new ResponseOKDto<RolDTO>(EndPointConstant.FIND_ONE, TipoMetodoConstant.GET,
					CodigoRespuestaConstant.OK, rolDto);
		} else {
			List<String> mensajesError = new ArrayList<String>();
			mensajesError.add(MensajeError.ELEMENT_NOTFOUND_MESSAGE);

			return new ResponseErrorDto(EndPointConstant.FIND_ONE, TipoMetodoConstant.GET,
					CodigoRespuestaConstant.ERROR, mensajesError);
		}
	}

	@Override
	public ResponseDto findAny(Map<String, String> requestParams) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseDto findAll() {
		try {
			// List
			List<Rol> roles = (ArrayList<Rol>) rolService.findAll();

			// Build Model List to Dto List
			List<RolDTO> listDto = rolBuilder.modelListToDto(roles);

			// return
			return new ResponseOKListDto<RolDTO>(EndPointConstant.FIND_ALL, TipoMetodoConstant.GET,
					CodigoRespuestaConstant.OK, listDto);

		} catch (Exception e) {
			String messageException = e.getMessage();
			List<String> mensajes = new ArrayList<>();
			mensajes.add(messageException);
			return new ResponseErrorDto(EndPointConstant.FIND_ALL, TipoMetodoConstant.GET,
					CodigoRespuestaConstant.ERROR, mensajes);
		}
	}

}
