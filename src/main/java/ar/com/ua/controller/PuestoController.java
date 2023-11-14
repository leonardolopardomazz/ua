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

import ar.com.ua.builder.PuestoBuilder;
import ar.com.ua.constant.CodigoRespuestaConstant;
import ar.com.ua.constant.EndPointConstant;
import ar.com.ua.constant.EndPointPathConstant;
import ar.com.ua.constant.MensajeError;
import ar.com.ua.constant.TipoMetodoConstant;
import ar.com.ua.dto.PuestoDTO;
import ar.com.ua.dto.response.ResponseDto;
import ar.com.ua.dto.response.ResponseErrorDto;
import ar.com.ua.dto.response.ResponseOKDto;
import ar.com.ua.dto.response.ResponseOKListDto;
import ar.com.ua.model.Puesto;
import ar.com.ua.service.PuestoService;

@RequestMapping("/puesto")
@RestController
public class PuestoController implements IABMController<PuestoDTO>, IListController<PuestoDTO> {

	@Autowired
	private PuestoService puestoService;

	@Autowired
	private PuestoBuilder puestoBuilder;

	static Logger logger = Logger.getLogger(PuestoController.class.getName());
	
	private ResponseDto save(Long id, PuestoDTO dto, String tipoMetodoConstant) {
		//Setteo el id para la actualizacion
		dto.setId(id);
		return this.save(dto, tipoMetodoConstant);
	} 

	private ResponseDto save(PuestoDTO dto, String tipoMetodoConstant) {
		List<String> mensajesError = new ArrayList<String>();

		try {
			Puesto puesto = puestoBuilder.dtoToModel(dto);
			Puesto puestoGuardado = puestoService.save(puesto);
			PuestoDTO puestoDto = puestoBuilder.modelToDto(puestoGuardado);
			return new ResponseOKDto<PuestoDTO>(EndPointPathConstant.PUESTO, tipoMetodoConstant,
					CodigoRespuestaConstant.OK, puestoDto);
		} catch (Exception e) {
			String messageException = e.getMessage();
			mensajesError.add(messageException);

			return new ResponseErrorDto(EndPointPathConstant.PUESTO, tipoMetodoConstant,
					CodigoRespuestaConstant.ERROR, mensajesError);
		}
	}

	/**
	 * Inserta una carga de familia a la tabla
	 * 
	 * @return ResponseDto
	 */
	@Override
	public ResponseDto add(PuestoDTO dto) {
		return this.save(dto, TipoMetodoConstant.POST);
	}

	/**
	 * Actualiza una carga de familia en la tabla
	 */
	@Override
	public ResponseDto modify(@PathVariable Long id,PuestoDTO dto) {
		return this.save(id, dto, TipoMetodoConstant.PUT);
	}

	/**
	 * Elimina una carga de familia de la tabla
	 */
	@Override
	public ResponseDto deleteById(@PathVariable Long id) {
		List<String> mensajesError = new ArrayList<String>();

		try {
			puestoService.deleteById(id);

			return new ResponseOKDto<PuestoDTO>(EndPointConstant.DELETE, TipoMetodoConstant.DELETE,
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
		Optional<Puesto> value = puestoService.findById(id);
		if (value.isPresent()) {
			Puesto tp = value.get();

			// Builder Model to Dto
			PuestoDTO tpDto = puestoBuilder.modelToDto(tp);

			// return
			return new ResponseOKDto<PuestoDTO>(EndPointConstant.FIND_ONE, TipoMetodoConstant.GET,
					CodigoRespuestaConstant.OK, tpDto);
		} else {
			List<String> mensajesError = new ArrayList<String>();
			mensajesError.add(MensajeError.ELEMENT_NOTFOUND_MESSAGE);

			return new ResponseErrorDto(EndPointConstant.FIND_ONE, TipoMetodoConstant.GET,
					CodigoRespuestaConstant.ERROR, mensajesError);
		}
	}

	@Override
	public ResponseDto findAny(Map<String, String> params) {
		try {
			String descripcion = params.get("descripcion");

			List<Puesto> listPuesto = puestoService.findByDescripcion(descripcion);

			if (!listPuesto.isEmpty()) {
				List<PuestoDTO> listPuestoDto = puestoBuilder.modelListToDto(listPuesto);

				return new ResponseOKListDto<PuestoDTO>(EndPointConstant.FIND_ANY, TipoMetodoConstant.GET,
						CodigoRespuestaConstant.OK, listPuestoDto);
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
			return new ResponseErrorDto(EndPointConstant.FIND_ANY, TipoMetodoConstant.DELETE,
					CodigoRespuestaConstant.ERROR, mensajesError);
		}
	}

	@Override
	public ResponseDto findAll() {
		try {
			// List
			List<Puesto> puesto = (ArrayList<Puesto>) puestoService.findAll();

			// Build Model List to Dto List
			List<PuestoDTO> puestoDTO = puestoBuilder.modelListToDto(puesto);

			// return
			return new ResponseOKListDto<PuestoDTO>(EndPointConstant.FIND_ALL, TipoMetodoConstant.GET,
					CodigoRespuestaConstant.OK, puestoDTO);

		} catch (Exception e) {
			String messageException = e.getMessage();
			List<String> mensajes = new ArrayList<>();
			mensajes.add(messageException);
			return new ResponseErrorDto(EndPointConstant.FIND_ALL, TipoMetodoConstant.GET,
					CodigoRespuestaConstant.ERROR, mensajes);
		}
	}

}
