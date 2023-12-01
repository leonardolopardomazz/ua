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

import ar.com.ua.builder.CargaDeFamiliaBuilder;
import ar.com.ua.constant.CodigoRespuestaConstant;
import ar.com.ua.constant.EndPointConstant;
import ar.com.ua.constant.EndPointPathConstant;
import ar.com.ua.constant.MensajeError;
import ar.com.ua.constant.TipoMetodoConstant;
import ar.com.ua.dto.CargaDeFamiliaDTO;
import ar.com.ua.dto.response.ResponseDto;
import ar.com.ua.dto.response.ResponseErrorDto;
import ar.com.ua.dto.response.ResponseOKDto;
import ar.com.ua.dto.response.ResponseOKListDto;
import ar.com.ua.model.CargaDeFamilia;
import ar.com.ua.service.CargaDeFamiliaService;

@RequestMapping("/cargadefamilia")
@RestController
public class CargaDeFamiliaController implements IABMController<CargaDeFamiliaDTO>, IListController<CargaDeFamiliaDTO> {

	@Autowired
	private CargaDeFamiliaService cdfService;

	@Autowired
	private CargaDeFamiliaBuilder cdfBuilder;

	static Logger logger = Logger.getLogger(CargaDeFamiliaController.class.getName());
	
	private ResponseDto save(Long id, CargaDeFamiliaDTO dto, String tipoMetodoConstant) {
		// Setteo el id para la actualizacion
		dto.setId(id);
		return this.save(dto, tipoMetodoConstant);
	}

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
		return this.save(id, dto, TipoMetodoConstant.PUT);
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

	@Override
	public ResponseDto findOne(Long id) {
		try {
			Optional<CargaDeFamilia> value = cdfService.findById(id);
			if (value.isPresent()) {
				CargaDeFamilia cdf = value.get();

				CargaDeFamiliaDTO cdfDto = cdfBuilder.modelToDto(cdf);

				return new ResponseOKDto<CargaDeFamiliaDTO>(EndPointConstant.FIND_ONE, TipoMetodoConstant.GET,
						CodigoRespuestaConstant.OK, cdfDto);
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

	//FIXME ver filtros
	@Override
	public ResponseDto findAny(Map<String, String> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseDto findAll() {
		try {
			// List
			List<CargaDeFamilia> cdf = (ArrayList<CargaDeFamilia>) cdfService.findAll();

			// Build Model List to Dto List
			List<CargaDeFamiliaDTO> cdfDto = cdfBuilder.modelListToDto(cdf);

			// return
			return new ResponseOKListDto<CargaDeFamiliaDTO>(EndPointConstant.FIND_ALL, TipoMetodoConstant.GET,
					CodigoRespuestaConstant.OK, cdfDto);

		} catch (Exception e) {
			String messageException = e.getMessage();
			List<String> mensajes = new ArrayList<>();
			mensajes.add(messageException);
			return new ResponseErrorDto(EndPointConstant.FIND_ALL, TipoMetodoConstant.GET,
					CodigoRespuestaConstant.ERROR, mensajes);
		}
	}

}
