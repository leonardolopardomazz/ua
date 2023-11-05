package ar.com.ua.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ua.builder.CargaDeFamiliaBuilder;
import ar.com.ua.constant.CodigoRespuestaConstant;
import ar.com.ua.constant.EndPointConstant;
import ar.com.ua.constant.EndPointPathConstant;
import ar.com.ua.constant.TipoMetodoConstant;
import ar.com.ua.dto.CargaDeFamiliaDTO;
import ar.com.ua.dto.response.ResponseDto;
import ar.com.ua.dto.response.ResponseErrorDto;
import ar.com.ua.dto.response.ResponseOKDto;
import ar.com.ua.model.CargaDeFamilia;
import ar.com.ua.service.CargaDeFamiliaService;

@RequestMapping("/cargadefamilia")
@RestController
public class CargaDeFamiliaController implements IABMController<CargaDeFamiliaDTO> {

	@Autowired
	private CargaDeFamiliaService cdfService;

	@Autowired
	private CargaDeFamiliaBuilder cdfBuilder;

	static Logger logger = Logger.getLogger(CargaDeFamiliaController.class.getName());

	private ResponseDto save(CargaDeFamiliaDTO dto, String tipoMetodoConstant) {
		List<String> mensajesError = new ArrayList<String>();

		try {
			CargaDeFamilia cdf = cdfBuilder.dtoToModel(dto);
			CargaDeFamilia cdfGuardada = cdfService.save(cdf);
			CargaDeFamiliaDTO cdfDto = cdfBuilder.modelToDto(cdfGuardada);
			return new ResponseOKDto<CargaDeFamiliaDTO>(EndPointPathConstant.CARGA_DE_FAMILIA, tipoMetodoConstant,
					CodigoRespuestaConstant.OK, cdfDto);
		} catch (Exception e) {
			String messageException = e.getMessage();
			mensajesError.add(messageException);

			return new ResponseErrorDto(EndPointPathConstant.CARGA_DE_FAMILIA, tipoMetodoConstant,
					CodigoRespuestaConstant.ERROR, mensajesError);
		}
	}

	/**
	 * Inserta una carga de familia a la tabla
	 * 
	 * @return ResponseDto
	 */
	@Override
	public ResponseDto add(CargaDeFamiliaDTO dto) {
		return this.save(dto, TipoMetodoConstant.POST);
	}

	/**
	 * Actualiza una carga de familia en la tabla
	 */
	@Override
	public ResponseDto modify(@PathVariable Long id, CargaDeFamiliaDTO dto) {
		return this.save(dto, TipoMetodoConstant.PUT);
	}

	/**
	 * Elimina una carga de familia de la tabla
	 */
	@Override
	public ResponseDto deleteById(@PathVariable Long id) {
		List<String> mensajesError = new ArrayList<String>();

		try {
			cdfService.deleteById(id);

			return new ResponseOKDto<CargaDeFamiliaDTO>(EndPointConstant.DELETE, TipoMetodoConstant.DELETE,
					CodigoRespuestaConstant.OK, null);
		} catch (Exception e) {
			String messageException = e.getMessage();
			mensajesError.add(messageException);
			return new ResponseErrorDto(EndPointConstant.DELETE, TipoMetodoConstant.DELETE,
					CodigoRespuestaConstant.ERROR, mensajesError);
		}
	}

}
