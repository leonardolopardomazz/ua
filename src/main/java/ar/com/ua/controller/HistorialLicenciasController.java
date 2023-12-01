package ar.com.ua.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ua.builder.HistorialLicenciasBuilder;
import ar.com.ua.constant.CodigoRespuestaConstant;
import ar.com.ua.constant.EndPointConstant;
import ar.com.ua.constant.EndPointPathConstant;
import ar.com.ua.constant.MensajeError;
import ar.com.ua.constant.TipoMetodoConstant;
import ar.com.ua.dto.HistorialLicenciasDTO;
import ar.com.ua.dto.response.ResponseDto;
import ar.com.ua.dto.response.ResponseErrorDto;
import ar.com.ua.dto.response.ResponseOKDto;
import ar.com.ua.dto.response.ResponseOKListDto;
import ar.com.ua.model.HistorialLicencias;
import ar.com.ua.service.HistorialLicenciasService;

@RequestMapping("/historiallicencias")
@RestController
public class HistorialLicenciasController implements IABMController<HistorialLicenciasDTO>, IListController<HistorialLicenciasDTO> {
	
	@Autowired
	private HistorialLicenciasService hlService;

	@Autowired
	private HistorialLicenciasBuilder hlBuilder;
	
	static Logger logger = Logger.getLogger(HistorialLicenciasController.class.getName());
	
	private ResponseDto save(Long id, HistorialLicenciasDTO dto, String tipoMetodoConstant) {
		// Setteo el id para la actualizacion
		dto.setId(id);
		return this.save(dto, tipoMetodoConstant);
	}
	
	private ResponseDto save(HistorialLicenciasDTO dto, String tipoMetodoConstant) {
		List<String> mensajesError = new ArrayList<String>();

		try {
			HistorialLicencias hl = hlBuilder.dtoToModel(dto);
			HistorialLicencias hlGuardado = hlService.save(hl);
			HistorialLicenciasDTO hlDto = hlBuilder.modelToDto(hlGuardado);
			return new ResponseOKDto<HistorialLicenciasDTO>(EndPointPathConstant.HISTORIAL_DE_LICENCIAS, tipoMetodoConstant,
					CodigoRespuestaConstant.OK, hlDto);
		} catch (Exception e) {
			String messageException = e.getMessage();
			mensajesError.add(messageException);

			return new ResponseErrorDto(EndPointPathConstant.HISTORIAL_DE_LICENCIAS, tipoMetodoConstant,
					CodigoRespuestaConstant.ERROR, mensajesError);
		}
	}

	@Override
	public ResponseDto add(HistorialLicenciasDTO dto) {
		return this.save(dto, TipoMetodoConstant.POST);
	}

	@Override
	public ResponseDto modify(Long id, HistorialLicenciasDTO dto) {
		return this.save(id, dto, TipoMetodoConstant.PUT);
	}

	@Override
	public ResponseDto deleteById(Long id) {
		List<String> mensajesError = new ArrayList<String>();

		try {
			hlService.deleteById(id);

			return new ResponseOKDto<HistorialLicenciasDTO>(EndPointConstant.DELETE, TipoMetodoConstant.DELETE,
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
			Optional<HistorialLicencias> value = hlService.findById(id);
			if (value.isPresent()) {
				HistorialLicencias hl = value.get();

				HistorialLicenciasDTO hlDto = hlBuilder.modelToDto(hl);

				return new ResponseOKDto<HistorialLicenciasDTO>(EndPointConstant.FIND_ONE, TipoMetodoConstant.GET,
						CodigoRespuestaConstant.OK, hlDto);
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseDto findAll() {
		try {
			// List
			List<HistorialLicencias> hl = (ArrayList<HistorialLicencias>) hlService.findAll();

			// Build Model List to Dto List
			List<HistorialLicenciasDTO> hlDto = hlBuilder.modelListToDto(hl);

			// return
			return new ResponseOKListDto<HistorialLicenciasDTO>(EndPointConstant.FIND_ALL, TipoMetodoConstant.GET,
					CodigoRespuestaConstant.OK, hlDto);

		} catch (Exception e) {
			String messageException = e.getMessage();
			List<String> mensajes = new ArrayList<>();
			mensajes.add(messageException);
			return new ResponseErrorDto(EndPointConstant.FIND_ALL, TipoMetodoConstant.GET,
					CodigoRespuestaConstant.ERROR, mensajes);
		}
	}

}
