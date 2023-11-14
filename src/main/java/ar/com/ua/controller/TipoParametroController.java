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

import ar.com.ua.builder.TipoParametroBuilder;
import ar.com.ua.constant.CodigoRespuestaConstant;
import ar.com.ua.constant.EndPointConstant;
import ar.com.ua.constant.EndPointPathConstant;
import ar.com.ua.constant.MensajeError;
import ar.com.ua.constant.TipoMetodoConstant;
import ar.com.ua.dto.TipoParametroDTO;
import ar.com.ua.dto.response.ResponseDto;
import ar.com.ua.dto.response.ResponseErrorDto;
import ar.com.ua.dto.response.ResponseOKDto;
import ar.com.ua.dto.response.ResponseOKListDto;
import ar.com.ua.model.TipoParametro;
import ar.com.ua.service.TipoParametroService;

@RequestMapping("/tipoparametro")
@RestController
public class TipoParametroController implements IABMController<TipoParametroDTO>, IListController<TipoParametroDTO> {

	@Autowired
	private TipoParametroService tpService;

	@Autowired
	private TipoParametroBuilder tpBuilder;

	static Logger logger = Logger.getLogger(TipoParametroController.class.getName());

	private ResponseDto save(TipoParametroDTO dto, String tipoMetodoConstant) {
		List<String> mensajesError = new ArrayList<String>();

		try {
			TipoParametro cdf = tpBuilder.dtoToModel(dto);
			TipoParametro cdfGuardada = tpService.save(cdf);
			TipoParametroDTO cdfDto = tpBuilder.modelToDto(cdfGuardada);
			return new ResponseOKDto<TipoParametroDTO>(EndPointPathConstant.TIPO_PARAMETRO, tipoMetodoConstant,
					CodigoRespuestaConstant.OK, cdfDto);
		} catch (Exception e) {
			String messageException = e.getMessage();
			mensajesError.add(messageException);

			return new ResponseErrorDto(EndPointPathConstant.TIPO_PARAMETRO, tipoMetodoConstant,
					CodigoRespuestaConstant.ERROR, mensajesError);
		}
	}

	/**
	 * Inserta un tipo parametro a la tabla
	 * 
	 * @return ResponseDto
	 */
	@Override
	public ResponseDto add(TipoParametroDTO dto) {
		return this.save(dto, TipoMetodoConstant.POST);
	}

	/**
	 * Actualiza un tipo parametro en la tabla
	 */
	@Override
	public ResponseDto modify(@PathVariable Long id, TipoParametroDTO dto) {
		return this.save(dto, TipoMetodoConstant.PUT);
	}

	/**
	 * Elimina un tipo parametro de la tabla
	 */
	@Override
	public ResponseDto deleteById(@PathVariable Long id) {
		List<String> mensajesError = new ArrayList<String>();

		try {
			tpService.deleteById(id);

			return new ResponseOKDto<TipoParametroDTO>(EndPointConstant.DELETE, TipoMetodoConstant.DELETE,
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
		Optional<TipoParametro> value = tpService.findById(id);
		if (value.isPresent()) {
			TipoParametro tp = value.get();

			// Builder Model to Dto
			TipoParametroDTO tpDto = tpBuilder.modelToDto(tp);

			// return
			return new ResponseOKDto<TipoParametroDTO>(EndPointConstant.FIND_ONE, TipoMetodoConstant.GET,
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

			List<TipoParametro> listTp = tpService.findByDescripcion(descripcion);

			if (!listTp.isEmpty()) {
				List<TipoParametroDTO> listTpDto = tpBuilder.modelListToDto(listTp);

				return new ResponseOKListDto<TipoParametroDTO>(EndPointConstant.FIND_ANY, TipoMetodoConstant.GET,
						CodigoRespuestaConstant.OK, listTpDto);
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
			List<TipoParametro> tp = (ArrayList<TipoParametro>) tpService.findAll();

			// Build Model List to Dto List
			List<TipoParametroDTO> tpDTO = tpBuilder.modelListToDto(tp);

			// return
			return new ResponseOKListDto<TipoParametroDTO>(EndPointConstant.FIND_ALL, TipoMetodoConstant.GET,
					CodigoRespuestaConstant.OK, tpDTO);

		} catch (Exception e) {
			String messageException = e.getMessage();
			List<String> mensajes = new ArrayList<>();
			mensajes.add(messageException);
			return new ResponseErrorDto(EndPointConstant.FIND_ALL, TipoMetodoConstant.GET,
					CodigoRespuestaConstant.ERROR, mensajes);
		}
	}

}
