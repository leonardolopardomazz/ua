package ar.com.ua.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ua.builder.HistorialPuestosBuilder;
import ar.com.ua.constant.CodigoRespuestaConstant;
import ar.com.ua.constant.EndPointConstant;
import ar.com.ua.constant.EndPointPathConstant;
import ar.com.ua.constant.MensajeError;
import ar.com.ua.constant.TipoMetodoConstant;
import ar.com.ua.dto.HistorialPuestosDTO;
import ar.com.ua.dto.response.ResponseDto;
import ar.com.ua.dto.response.ResponseErrorDto;
import ar.com.ua.dto.response.ResponseOKDto;
import ar.com.ua.dto.response.ResponseOKListDto;
import ar.com.ua.model.HistorialPuestos;
import ar.com.ua.service.HistorialPuestosService;

@RequestMapping("/historialpuestos")
@RestController
public class HistorialPuestosController implements IABMController<HistorialPuestosDTO>, IListController<HistorialPuestosDTO> {

	@Autowired
	private HistorialPuestosService hpService;

	@Autowired
	private HistorialPuestosBuilder hpBuilder;

	static Logger logger = Logger.getLogger(HistorialLicenciasController.class.getName());

	private ResponseDto save(Long id, HistorialPuestosDTO dto, String tipoMetodoConstant) {
		// Setteo el id para la actualizacion
		dto.setId(id);
		return this.save(dto, tipoMetodoConstant);
	}

	private ResponseDto save(HistorialPuestosDTO dto, String tipoMetodoConstant) {
		List<String> mensajesError = new ArrayList<String>();

		try {
			HistorialPuestos hp = hpBuilder.dtoToModel(dto);
			HistorialPuestos hpGuardado = hpService.save(hp);
			HistorialPuestosDTO hpDto = hpBuilder.modelToDto(hpGuardado);
			return new ResponseOKDto<HistorialPuestosDTO>(EndPointPathConstant.HISTORIAL_DE_PUESTOS, tipoMetodoConstant,
					CodigoRespuestaConstant.OK, hpDto);
		} catch (Exception e) {
			String messageException = e.getMessage();
			mensajesError.add(messageException);

			return new ResponseErrorDto(EndPointPathConstant.HISTORIAL_DE_PUESTOS, tipoMetodoConstant,
					CodigoRespuestaConstant.ERROR, mensajesError);
		}
	}

	@Override
	public ResponseDto add(HistorialPuestosDTO dto) {
		return this.save(dto, TipoMetodoConstant.POST);
	}

	@Override
	public ResponseDto modify(Long id, HistorialPuestosDTO dto) {
		return this.save(id, dto, TipoMetodoConstant.PUT);
	}

	@Override
	public ResponseDto deleteById(Long id) {
		try {
			hpService.deleteById(id);

			return new ResponseOKDto<HistorialPuestosDTO>(EndPointConstant.DELETE, TipoMetodoConstant.DELETE,
					CodigoRespuestaConstant.OK, null);
		} catch (Exception e) {
			List<String> mensajesError = new ArrayList<String>();
			String messageException = e.getMessage();
			mensajesError.add(messageException);
			return new ResponseErrorDto(EndPointConstant.DELETE, TipoMetodoConstant.DELETE,
					CodigoRespuestaConstant.ERROR, mensajesError);
		}
	}

	@Override
	public ResponseDto findOne(Long id) {
		try {
			Optional<HistorialPuestos> value = hpService.findById(id);
			if (value.isPresent()) {
				HistorialPuestos hp = value.get();

				HistorialPuestosDTO hpDto = hpBuilder.modelToDto(hp);

				return new ResponseOKDto<HistorialPuestosDTO>(EndPointConstant.FIND_ONE, TipoMetodoConstant.GET,
						CodigoRespuestaConstant.OK, hpDto);
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
			List<HistorialPuestos> hp = (ArrayList<HistorialPuestos>) hpService.findAll();

			// Build Model List to Dto List
			List<HistorialPuestosDTO> hpDto = hpBuilder.modelListToDto(hp);

			// return
			return new ResponseOKListDto<HistorialPuestosDTO>(EndPointConstant.FIND_ALL, TipoMetodoConstant.GET,
					CodigoRespuestaConstant.OK, hpDto);

		} catch (Exception e) {
			String messageException = e.getMessage();
			List<String> mensajes = new ArrayList<>();
			mensajes.add(messageException);
			return new ResponseErrorDto(EndPointConstant.FIND_ALL, TipoMetodoConstant.GET,
					CodigoRespuestaConstant.ERROR, mensajes);
		}
	}

}
