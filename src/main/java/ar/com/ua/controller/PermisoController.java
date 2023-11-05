package ar.com.ua.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ua.builder.PermisoBuilder;
import ar.com.ua.constant.CodigoRespuestaConstant;
import ar.com.ua.constant.EndPointConstant;
import ar.com.ua.constant.EndPointPathConstant;
import ar.com.ua.constant.MensajeError;
import ar.com.ua.constant.TipoMetodoConstant;
import ar.com.ua.dto.PermisoDTO;
import ar.com.ua.dto.response.ResponseDto;
import ar.com.ua.dto.response.ResponseErrorDto;
import ar.com.ua.dto.response.ResponseOKDto;
import ar.com.ua.dto.response.ResponseOKListDto;
import ar.com.ua.model.Permiso;
import ar.com.ua.service.PermisoService;

@RequestMapping("/permiso")
@RestController
public class PermisoController implements IABMController<PermisoDTO>, IListController<PermisoDTO> {

	@Autowired
	private PermisoService permisoService;

	@Autowired
	private PermisoBuilder permisoBuilder;

	static Logger logger = Logger.getLogger(PermisoController.class.getName());
	
	private ResponseDto save(Long id, PermisoDTO dto, String tipoMetodoConstant) {
		//Setteo el id para la actualizacion
		dto.setCodigo(id);
		return this.save(dto, tipoMetodoConstant);
	}

	private ResponseDto save(PermisoDTO dto, String tipoMetodoConstant) {
		List<String> mensajesError = new ArrayList<String>();

		try {
			Permiso permiso = permisoBuilder.dtoToModel(dto);
			Permiso permisoGuardado = permisoService.save(permiso);
			PermisoDTO permisoDTO = permisoBuilder.modelToDto(permisoGuardado);
			return new ResponseOKDto<PermisoDTO>(EndPointPathConstant.PERMISO, tipoMetodoConstant,
					CodigoRespuestaConstant.OK, permisoDTO);
		} catch (Exception e) {
			String messageException = e.getMessage();
			mensajesError.add(messageException);

			return new ResponseErrorDto(EndPointPathConstant.PERMISO, tipoMetodoConstant,
					CodigoRespuestaConstant.ERROR, mensajesError);
		}
	}

	/**
	 * Inserta una carga de familia a la tabla
	 * 
	 * @return ResponseDto
	 */
	@Override
	public ResponseDto add(PermisoDTO dto) {
		return this.save(dto, TipoMetodoConstant.POST);
	}

	/**
	 * Actualiza una carga de familia en la tabla
	 */
	@Override
	public ResponseDto modify(@PathVariable Long id, PermisoDTO dto) {
		return this.save(id, dto, TipoMetodoConstant.PUT);
	}

	/**
	 * Elimina una carga de familia de la tabla
	 */
	@Override
	public ResponseDto deleteById(@PathVariable Long id) {
		List<String> mensajesError = new ArrayList<String>();

		try {
			permisoService.deleteById(id);

			return new ResponseOKDto<PermisoDTO>(EndPointConstant.DELETE, TipoMetodoConstant.DELETE,
					CodigoRespuestaConstant.OK, null);
		} catch (Exception e) {
			String messageException = e.getMessage();
			mensajesError.add(messageException);
			return new ResponseErrorDto(EndPointConstant.DELETE, TipoMetodoConstant.DELETE,
					CodigoRespuestaConstant.ERROR, mensajesError);
		}
	}

	@Override
	public ResponseDto findOne(Long id) {

		// Get model object
		Optional<Permiso> value = permisoService.findById(id);
		if (value.isPresent()) {
			Permiso permiso = value.get();

			// Builder Model to Dto
			PermisoDTO permisoDto = permisoBuilder.modelToDto(permiso);

			// return
			return new ResponseOKDto<PermisoDTO>(EndPointConstant.FIND_ONE, TipoMetodoConstant.GET,
					CodigoRespuestaConstant.OK, permisoDto);
		} else {
			List<String> mensajesError = new ArrayList<String>();
			mensajesError.add(MensajeError.ELEMENT_NOTFOUND_MESSAGE);

			return new ResponseErrorDto(EndPointConstant.FIND_ONE, TipoMetodoConstant.POST,
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
			List<Permiso> permisos = (ArrayList<Permiso>) permisoService.findAll();

			// Build Model List to Dto List
			List<PermisoDTO> PermisoDTO = permisoBuilder.modelListToDto(permisos);

			// return
			return new ResponseOKListDto<PermisoDTO>(EndPointConstant.FIND_ALL, TipoMetodoConstant.GET,
					CodigoRespuestaConstant.OK, PermisoDTO);

		} catch (Exception e) {
			String messageException = e.getMessage();
			List<String> mensajes = new ArrayList<>();
			mensajes.add(messageException);
			return new ResponseErrorDto(EndPointConstant.FIND_ALL, TipoMetodoConstant.GET,
					CodigoRespuestaConstant.ERROR, mensajes);
		}
	}

}
