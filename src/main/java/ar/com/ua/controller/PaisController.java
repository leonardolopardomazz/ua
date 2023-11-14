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

import ar.com.ua.builder.PaisBuilder;
import ar.com.ua.constant.CodigoRespuestaConstant;
import ar.com.ua.constant.EndPointConstant;
import ar.com.ua.constant.EndPointPathConstant;
import ar.com.ua.constant.MensajeError;
import ar.com.ua.constant.TipoMetodoConstant;
import ar.com.ua.dto.PaisDTO;
import ar.com.ua.dto.response.ResponseDto;
import ar.com.ua.dto.response.ResponseErrorDto;
import ar.com.ua.dto.response.ResponseOKDto;
import ar.com.ua.dto.response.ResponseOKListDto;
import ar.com.ua.model.Pais;
import ar.com.ua.service.PaisService;

@RequestMapping("/pais")
@RestController
public class PaisController implements IABMController<PaisDTO>, IListController<PaisDTO> {

	@Autowired
	private PaisService paisService;

	@Autowired
	private PaisBuilder paisBuilder;

	static Logger logger = Logger.getLogger(PaisController.class.getName());
	
	private ResponseDto save(Long id, PaisDTO dto, String tipoMetodoConstant) {
		//Setteo el id para la actualizacion
		dto.setId(id);
		return this.save(dto, tipoMetodoConstant);
	}

	private ResponseDto save(PaisDTO dto, String tipoMetodoConstant) {
		List<String> mensajesError = new ArrayList<String>();

		try {
			Pais pais = paisBuilder.dtoToModel(dto);
			Pais paisGuardado = paisService.save(pais);
			PaisDTO paisDTO = paisBuilder.modelToDto(paisGuardado);
			return new ResponseOKDto<PaisDTO>(EndPointPathConstant.PAIS, tipoMetodoConstant,
					CodigoRespuestaConstant.OK, paisDTO);
		} catch (Exception e) {
			String messageException = e.getMessage();
			mensajesError.add(messageException);

			return new ResponseErrorDto(EndPointPathConstant.PAIS, tipoMetodoConstant,
					CodigoRespuestaConstant.ERROR, mensajesError);
		}
	}

	/**
	 * Inserta un pais a la tabla
	 * 
	 * @return ResponseDto
	 */
	@Override
	public ResponseDto add(PaisDTO dto) {
		return this.save(dto, TipoMetodoConstant.POST);
	}

	/**
	 * Actualiza un pais en la tabla
	 */
	@Override
	public ResponseDto modify(Long id, PaisDTO dto) {
		return this.save(id, dto, TipoMetodoConstant.PUT);
	}

	/**
	 * Elimina un pais de la tabla
	 */
	@Override
	public ResponseDto deleteById(@PathVariable Long id) {
		List<String> mensajesError = new ArrayList<String>();

		try {
			paisService.deleteById(id);

			return new ResponseOKDto<PaisDTO>(EndPointConstant.DELETE, TipoMetodoConstant.DELETE,
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
		Optional<Pais> value = paisService.findById(id);
		if (value.isPresent()) {
			Pais pais = value.get();

			// Builder Model to Dto
			PaisDTO paisDto = paisBuilder.modelToDto(pais);

			// return
			return new ResponseOKDto<PaisDTO>(EndPointConstant.FIND_ONE, TipoMetodoConstant.GET,
					CodigoRespuestaConstant.OK, paisDto);
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

			List<Pais> listPaises = paisService.findByDescripcion(descripcion);

			if (!listPaises.isEmpty()) {
				List<PaisDTO> listPaisDto = paisBuilder.modelListToDto(listPaises);

				return new ResponseOKListDto<PaisDTO>(EndPointConstant.FIND_ANY, TipoMetodoConstant.GET,
						CodigoRespuestaConstant.OK, listPaisDto);
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
			List<Pais> pais = (ArrayList<Pais>) paisService.findAll();

			// Build Model List to Dto List
			List<PaisDTO> paisDTO = paisBuilder.modelListToDto(pais);

			// return
			return new ResponseOKListDto<PaisDTO>(EndPointConstant.FIND_ALL, TipoMetodoConstant.GET,
					CodigoRespuestaConstant.OK, paisDTO);

		} catch (Exception e) {
			String messageException = e.getMessage();
			List<String> mensajes = new ArrayList<>();
			mensajes.add(messageException);
			return new ResponseErrorDto(EndPointConstant.FIND_ALL, TipoMetodoConstant.GET,
					CodigoRespuestaConstant.ERROR, mensajes);
		}
	}



}
