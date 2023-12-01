package ar.com.ua.controller;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ua.builder.HistorialIngreslCaidosBuilder;
import ar.com.ua.constant.CodigoRespuestaConstant;
import ar.com.ua.constant.EndPointConstant;
import ar.com.ua.constant.EndPointPathConstant;
import ar.com.ua.constant.MensajeError;
import ar.com.ua.constant.TipoMetodoConstant;
import ar.com.ua.dto.HistorialIngresoCaidosDTO;
import ar.com.ua.dto.response.ResponseDto;
import ar.com.ua.dto.response.ResponseErrorDto;
import ar.com.ua.dto.response.ResponseOKDto;
import ar.com.ua.dto.response.ResponseOKListDto;
import ar.com.ua.model.HistorialIngresoCaidos;
import ar.com.ua.service.HistorialIngreslCaidosService;

@RequestMapping("/historialingresoscaidos")
@RestController
public class HistorialIngresosCaidosController implements IABMController<HistorialIngresoCaidosDTO>, IListController<HistorialIngresoCaidosDTO> {

	@Autowired
	private HistorialIngreslCaidosService hicService;

	@Autowired
	private HistorialIngreslCaidosBuilder hicBuilder;

	static Logger logger = Logger.getLogger(HistorialIngresosCaidosController.class.getName());

	private ResponseDto save(Long id, HistorialIngresoCaidosDTO dto, String tipoMetodoConstant) {
		// Setteo el id para la actualizacion
		dto.setId(id);
		return this.save(dto, tipoMetodoConstant);
	}

	private ResponseDto save(HistorialIngresoCaidosDTO dto, String tipoMetodoConstant) {
		try {
			HistorialIngresoCaidos hic = hicBuilder.dtoToModel(dto);
			HistorialIngresoCaidos hicGuardado = hicService.save(hic);
			HistorialIngresoCaidosDTO hicDto = hicBuilder.modelToDto(hicGuardado);
			return new ResponseOKDto<HistorialIngresoCaidosDTO>(EndPointPathConstant.HISTORIAL_DE_INGRESOS_CAIDOS,
					tipoMetodoConstant, CodigoRespuestaConstant.OK, hicDto);
		} catch (Exception e) {
			List<String> mensajesError = new ArrayList<String>();
			String messageException = e.getMessage();
			mensajesError.add(messageException);

			return new ResponseErrorDto(EndPointPathConstant.HISTORIAL_DE_INGRESOS_CAIDOS, tipoMetodoConstant,
					CodigoRespuestaConstant.ERROR, mensajesError);
		}
	}

	@Override
	public ResponseDto add(HistorialIngresoCaidosDTO dto) {
		return this.save(dto, TipoMetodoConstant.POST);
	}

	@Override
	public ResponseDto modify(Long id, HistorialIngresoCaidosDTO dto) {
		return this.save(id, dto, TipoMetodoConstant.PUT);
	}

	@Override
	public ResponseDto deleteById(Long id) {

		try {
			hicService.deleteById(id);

			return new ResponseOKDto<HistorialIngresoCaidosDTO>(EndPointConstant.DELETE, TipoMetodoConstant.DELETE,
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
			Optional<HistorialIngresoCaidos> value = hicService.findById(id);
			if (value.isPresent()) {
				HistorialIngresoCaidos hic = value.get();

				HistorialIngresoCaidosDTO hicDto = hicBuilder.modelToDto(hic);

				return new ResponseOKDto<HistorialIngresoCaidosDTO>(EndPointConstant.FIND_ONE, TipoMetodoConstant.GET,
						CodigoRespuestaConstant.OK, hicDto);
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
		return null;
	}

	@Override
	public ResponseDto findAll() {
		try {
			// List
			List<HistorialIngresoCaidos> hic = (ArrayList<HistorialIngresoCaidos>) hicService.findAll();

			// Build Model List to Dto List
			List<HistorialIngresoCaidosDTO> hicDto = hicBuilder.modelListToDto(hic);

			// return
			return new ResponseOKListDto<HistorialIngresoCaidosDTO>(EndPointConstant.FIND_ALL, TipoMetodoConstant.GET,
					CodigoRespuestaConstant.OK, hicDto);

		} catch (Exception e) {
			String messageException = e.getMessage();
			List<String> mensajes = new ArrayList<>();
			mensajes.add(messageException);
			return new ResponseErrorDto(EndPointConstant.FIND_ALL, TipoMetodoConstant.GET,
					CodigoRespuestaConstant.ERROR, mensajes);
		}
	}

}
