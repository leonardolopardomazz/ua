package ar.com.ua.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ua.builder.ParametrosSeguridadContrasenaBuilder;
import ar.com.ua.commons.ManejoErrores;
import ar.com.ua.constant.CodigoRespuestaConstant;
import ar.com.ua.constant.EndPointConstant;
import ar.com.ua.constant.EndPointPathConstant;
import ar.com.ua.constant.MensajeError;
import ar.com.ua.constant.TipoMetodoConstant;
import ar.com.ua.dto.ParametrosSeguridadContrasenaDTO;
import ar.com.ua.dto.response.ResponseDto;
import ar.com.ua.dto.response.ResponseErrorDto;
import ar.com.ua.dto.response.ResponseOKDto;
import ar.com.ua.dto.response.ResponseOKListDto;
import ar.com.ua.model.ParametrosSeguridadContrasena;
import ar.com.ua.service.ParametrosSeguridadContrasenaService;

@RequestMapping("/parametrosseguridadcontrasena")
@RestController
public class ParametrosSeguridadContrasenaController
		implements IABMController<ParametrosSeguridadContrasenaDTO>, IListController<ParametrosSeguridadContrasenaDTO> {

	@Autowired
	private ParametrosSeguridadContrasenaService pscService;

	@Autowired
	private ParametrosSeguridadContrasenaBuilder pscBuilder;

	private ResponseDto save(Long id, ParametrosSeguridadContrasenaDTO dto, String tipoMetodoConstant) {
		// Setteo el id para la actualizacion
		dto.setId(id);
		return this.save(dto, tipoMetodoConstant);
	}

	private ResponseDto save(ParametrosSeguridadContrasenaDTO dto, String tipoMetodoConstant) {
		try {
			ParametrosSeguridadContrasena psc = pscBuilder.dtoToModel(dto);
			ParametrosSeguridadContrasena pscGuardada = pscService.save(psc);
			ParametrosSeguridadContrasenaDTO cdfDto = pscBuilder.modelToDto(pscGuardada);
			return new ResponseOKDto<ParametrosSeguridadContrasenaDTO>(
					EndPointPathConstant.PARAMETROS_SEGURIDAD_CONTRASENA, tipoMetodoConstant,
					CodigoRespuestaConstant.OK, cdfDto);
		} catch (Exception e) {
			return ManejoErrores.errorGenerico(EndPointConstant.ADD, TipoMetodoConstant.POST, e.getMessage());
		}
	}

	@Override
	public ResponseDto add(ParametrosSeguridadContrasenaDTO dto) {
		return this.save(dto, TipoMetodoConstant.POST);
	}

	@Override
	public ResponseDto modify(Long id, ParametrosSeguridadContrasenaDTO dto) {
		return this.save(id, dto, TipoMetodoConstant.PUT);
	}

	@Override
	public ResponseDto deleteById(Long id) {
		try {
			this.pscService.deleteById(id);

			return new ResponseOKDto<ParametrosSeguridadContrasenaDTO>(EndPointConstant.DELETE,
					TipoMetodoConstant.DELETE, CodigoRespuestaConstant.OK, null);
		} catch (Exception e) {
			return ManejoErrores.errorGenerico(EndPointConstant.DELETE, TipoMetodoConstant.DELETE, e.getMessage());
		}
	}

	@Override
	public ResponseDto findOne(Long id) {
		try {
			Optional<ParametrosSeguridadContrasena> value = pscService.findById(id);
			if (value.isPresent()) {
				ParametrosSeguridadContrasena psc = value.get();

				ParametrosSeguridadContrasenaDTO pscDto = pscBuilder.modelToDto(psc);

				return new ResponseOKDto<ParametrosSeguridadContrasenaDTO>(EndPointConstant.FIND_ONE,
						TipoMetodoConstant.GET, CodigoRespuestaConstant.OK, pscDto);
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
			List<ParametrosSeguridadContrasena> psc = (ArrayList<ParametrosSeguridadContrasena>) pscService.findAll();

			// Build Model List to Dto List
			List<ParametrosSeguridadContrasenaDTO> pscDto = pscBuilder.modelListToDto(psc);

			// return
			return new ResponseOKListDto<ParametrosSeguridadContrasenaDTO>(EndPointConstant.FIND_ALL,
					TipoMetodoConstant.GET, CodigoRespuestaConstant.OK, pscDto);

		} catch (Exception e) {
			String messageException = e.getMessage();
			List<String> mensajes = new ArrayList<>();
			mensajes.add(messageException);
			return new ResponseErrorDto(EndPointConstant.FIND_ALL, TipoMetodoConstant.GET,
					CodigoRespuestaConstant.ERROR, mensajes);
		}
	}

	@GetMapping(value = "/activo")
	public ResponseDto findActive() {
		try {
			List<ParametrosSeguridadContrasena> listPsc = this.pscService.findByActivoTrue();
			List<ParametrosSeguridadContrasenaDTO> listPscDto = pscBuilder.modelListToDto(listPsc);

			return new ResponseOKListDto<ParametrosSeguridadContrasenaDTO>(EndPointConstant.FIND_ONE,
					TipoMetodoConstant.GET, CodigoRespuestaConstant.OK, listPscDto);

		} catch (Exception e) {
			return ManejoErrores.errorGenerico(EndPointConstant.FIND_ONE, TipoMetodoConstant.GET, e.getMessage());
		}
	}

	@GetMapping(value = "/cantidadactivos")
	public int countActive() {
		try {
			int cantidadActivos = this.pscService.countByActivoTrue();
			return cantidadActivos;
		} catch (Exception e) {
			throw e;
		}
	}
}
