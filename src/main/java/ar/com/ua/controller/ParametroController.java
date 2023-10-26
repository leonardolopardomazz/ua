package ar.com.ua.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ua.builder.ParametroBuilder;
import ar.com.ua.constant.CodigoRespuestaConstant;
import ar.com.ua.constant.EndPointConstant;
import ar.com.ua.constant.EndPointPathConstant;
import ar.com.ua.constant.TipoMetodoConstant;
import ar.com.ua.dto.ParametroDTO;
import ar.com.ua.dto.response.ResponseDto;
import ar.com.ua.dto.response.ResponseErrorDto;
import ar.com.ua.dto.response.ResponseOKDto;
import ar.com.ua.model.Parametro;
import ar.com.ua.service.ParametroService;

@RequestMapping("/parametro")
@RestController
public class ParametroController implements IABMController<ParametroDTO> {

	@Autowired
	private ParametroService parametroService;

	@Autowired
	private ParametroBuilder parametroBuilder;

	static Logger logger = Logger.getLogger(ParametroController.class.getName());

	private ResponseDto save(ParametroDTO dto, String tipoMetodoConstant) {
		List<String> mensajesError = new ArrayList<String>();

		try {
			Parametro parametro = parametroBuilder.dtoToModel(dto);
			Parametro parametroGuardado = parametroService.save(parametro);
			ParametroDTO parametroDto = parametroBuilder.modelToDto(parametroGuardado);
			return new ResponseOKDto<ParametroDTO>(EndPointPathConstant.PARAMETRO, tipoMetodoConstant,
					CodigoRespuestaConstant.OK, parametroDto);
		} catch (Exception e) {
			String messageException = e.getMessage();
			mensajesError.add(messageException);

			return new ResponseErrorDto(EndPointPathConstant.PARAMETRO, tipoMetodoConstant,
					CodigoRespuestaConstant.ERROR, mensajesError);
		}
	}

	/**
	 * Inserta una carga de familia a la tabla
	 * 
	 * @return ResponseDto
	 */
	@Override
	public ResponseDto add(ParametroDTO dto) {
		return this.save(dto, TipoMetodoConstant.POST);
	}

	/**
	 * Actualiza una carga de familia en la tabla
	 */
	@Override
	public ResponseDto modify(ParametroDTO dto) {
		return this.save(dto, TipoMetodoConstant.PUT);
	}

	/**
	 * Elimina una carga de familia de la tabla
	 */
	@Override
	public ResponseDto deleteById(ParametroDTO dto) {
		List<String> mensajesError = new ArrayList<String>();

		try {
			Parametro parametro = parametroBuilder.dtoToModel(dto);
			parametroService.delete(parametro);

			return new ResponseOKDto<ParametroDTO>(EndPointConstant.DELETE, TipoMetodoConstant.DELETE,
					CodigoRespuestaConstant.OK, dto);
		} catch (Exception e) {
			String messageException = e.getMessage();
			mensajesError.add(messageException);
			return new ResponseErrorDto(EndPointConstant.DELETE, TipoMetodoConstant.DELETE,
					CodigoRespuestaConstant.ERROR, mensajesError);
		}
	}

}
