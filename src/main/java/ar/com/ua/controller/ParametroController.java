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

import ar.com.ua.builder.ParametroBuilder;
import ar.com.ua.commons.ManejoErrores;
import ar.com.ua.constant.CodigoRespuestaConstant;
import ar.com.ua.constant.EndPointConstant;
import ar.com.ua.constant.EndPointPathConstant;
import ar.com.ua.constant.MensajeError;
import ar.com.ua.constant.PermisosConstant;
import ar.com.ua.constant.TipoMetodoConstant;
import ar.com.ua.controller.report.AccesoPermiso;
import ar.com.ua.dto.ParametroDTO;
import ar.com.ua.dto.response.ResponseDto;
import ar.com.ua.dto.response.ResponseErrorDto;
import ar.com.ua.dto.response.ResponseOKDto;
import ar.com.ua.dto.response.ResponseOKListDto;
import ar.com.ua.model.Parametro;
import ar.com.ua.service.ParametroService;

@RequestMapping("/parametro")
@RestController
public class ParametroController implements IABMController<ParametroDTO>, IListController<ParametroDTO> {

	@Autowired
	private ParametroService parametroService;

	@Autowired
	private ParametroBuilder parametroBuilder;

	@Autowired
	private AccesoPermiso accesoPermiso;

	static Logger logger = Logger.getLogger(ParametroController.class.getName());

	private ResponseDto save(Long id, ParametroDTO dto, String tipoMetodoConstant) {
		// Setteo el id para la actualizacion
		dto.setId(id);
		return this.save(dto, tipoMetodoConstant);
	}

	private ResponseDto save(ParametroDTO dto, String tipoMetodoConstant) {

		try {
			Parametro parametro = parametroBuilder.dtoToModel(dto);
			Parametro parametroGuardado = parametroService.save(parametro);
			ParametroDTO parametroDto = parametroBuilder.modelToDto(parametroGuardado);
			return new ResponseOKDto<ParametroDTO>(EndPointPathConstant.PARAMETRO, tipoMetodoConstant,
					CodigoRespuestaConstant.OK, parametroDto);
		} catch (Exception e) {
			return ManejoErrores.errorGenerico(EndPointPathConstant.PARAMETRO, TipoMetodoConstant.POST, e.getMessage());
		}
	}

	/**
	 * Inserta una carga de familia a la tabla
	 * 
	 * @return ResponseDto
	 */
	@Override
	public ResponseDto add(ParametroDTO dto) {
		try {
			// Chequeo de acceso al reporte
			boolean tieneAcceso = this.accesoPermiso
					.deteminarAccesoAlRecurso(PermisosConstant.PERMISO_TABLAS_PARAMETRICAS_ALTA);

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
	 * Actualiza una carga de familia en la tabla
	 */
	@Override
	public ResponseDto modify(@PathVariable Long id, ParametroDTO dto) {
		try {
			// Chequeo de acceso al reporte
			boolean tieneAcceso = this.accesoPermiso
					.deteminarAccesoAlRecurso(PermisosConstant.PERMISO_TABLAS_PARAMETRICAS_MODIFICACION);

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
	 * Elimina una carga de familia de la tabla
	 */
	@Override
	public ResponseDto deleteById(@PathVariable Long id) {
		List<String> mensajesError = new ArrayList<String>();

		try {
			// Chequeo de acceso al reporte
			boolean tieneAcceso = this.accesoPermiso
					.deteminarAccesoAlRecurso(PermisosConstant.PERMISO_TABLAS_PARAMETRICAS_BAJA);

			if (!tieneAcceso) {
				return ManejoErrores.errorGenerico(EndPointConstant.DELETE, TipoMetodoConstant.DELETE,
						MensajeError.ACCESS_DENIED);
			}

			parametroService.deleteById(id);

			return new ResponseOKDto<ParametroDTO>(EndPointConstant.DELETE, TipoMetodoConstant.DELETE,
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
		try {
			Optional<Parametro> value = parametroService.findById(id);
			if (value.isPresent()) {
				Parametro parametro = value.get();

				ParametroDTO parametroDto = parametroBuilder.modelToDto(parametro);

				return new ResponseOKDto<ParametroDTO>(EndPointConstant.FIND_ONE, TipoMetodoConstant.GET,
						CodigoRespuestaConstant.OK, parametroDto);
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
	public ResponseDto findAny(Map<String, String> params) {
		try {
			String descripcion = params.get("descripcion");

			List<Parametro> listModel = parametroService.findByDescripcion(descripcion);

			if (!listModel.isEmpty()) {
				List<ParametroDTO> listDto = parametroBuilder.modelListToDto(listModel);

				return new ResponseOKListDto<ParametroDTO>(EndPointConstant.FIND_ANY, TipoMetodoConstant.GET,
						CodigoRespuestaConstant.OK, listDto);
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
			List<Parametro> parametro = (ArrayList<Parametro>) parametroService.findAll();

			// Build Model List to Dto List
			List<ParametroDTO> parametroDto = parametroBuilder.modelListToDto(parametro);

			// return
			return new ResponseOKListDto<ParametroDTO>(EndPointConstant.FIND_ALL, TipoMetodoConstant.GET,
					CodigoRespuestaConstant.OK, parametroDto);

		} catch (Exception e) {
			String messageException = e.getMessage();
			List<String> mensajes = new ArrayList<>();
			mensajes.add(messageException);
			return new ResponseErrorDto(EndPointConstant.FIND_ALL, TipoMetodoConstant.GET,
					CodigoRespuestaConstant.ERROR, mensajes);
		}
	}

}
