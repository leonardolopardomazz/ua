package ar.com.ua.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ua.builder.SeguridadContrasenaBuilder;
import ar.com.ua.constant.CodigoRespuestaConstant;
import ar.com.ua.constant.EndPointConstant;
import ar.com.ua.constant.EndPointPathConstant;
import ar.com.ua.constant.MensajeError;
import ar.com.ua.constant.TipoMetodoConstant;
import ar.com.ua.dto.SeguridadContrasenaDTO;
import ar.com.ua.dto.response.ResponseDto;
import ar.com.ua.dto.response.ResponseErrorDto;
import ar.com.ua.dto.response.ResponseOKDto;
import ar.com.ua.dto.response.ResponseOKListDto;
import ar.com.ua.model.SeguridadContrasena;
import ar.com.ua.service.SeguridadContrasenaService;

@RequestMapping("/seguridadcontrasena")
@RestController
public class SeguridadContrasenaController implements IABMController<SeguridadContrasenaDTO>, IListController<SeguridadContrasenaDTO> {

	@Autowired
	private SeguridadContrasenaService scService;
	
	@Autowired
	private SeguridadContrasenaBuilder scBuilder;
	
	
	private ResponseDto save(Long id, SeguridadContrasenaDTO dto, String tipoMetodoConstant) {
		dto.setId(id);
		return this.save(dto, tipoMetodoConstant);
	}

	private ResponseDto save(SeguridadContrasenaDTO dto, String tipoMetodoConstant) {
		try {
			SeguridadContrasena sc = scBuilder.dtoToModel(dto);
			SeguridadContrasena scGuardado = scService.save(sc);
			SeguridadContrasenaDTO scDto = scBuilder.modelToDto(scGuardado);
			
			return new ResponseOKDto<SeguridadContrasenaDTO>(EndPointPathConstant.SEGURIDAD_CONTRASENA, tipoMetodoConstant,
					CodigoRespuestaConstant.OK, scDto);
		} catch (Exception e) {
			List<String> mensajesError = new ArrayList<String>();
			String messageException = e.getMessage();
			mensajesError.add(messageException);

			return new ResponseErrorDto(EndPointPathConstant.EMPLEADO, tipoMetodoConstant,
					CodigoRespuestaConstant.ERROR, mensajesError);
		}
	}
	
	@Override
	public ResponseDto add(SeguridadContrasenaDTO dto) {
		return this.save(dto, TipoMetodoConstant.POST);
	}

	@Override
	public ResponseDto modify(Long id, SeguridadContrasenaDTO dto) {
		return this.save(id, dto, TipoMetodoConstant.PUT);
	}

	@Override
	public ResponseDto deleteById(Long id) {

		try {
			this.scService.deleteById(id);

			return new ResponseOKDto<SeguridadContrasenaDTO>(EndPointConstant.DELETE, TipoMetodoConstant.DELETE,
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
			Optional<SeguridadContrasena> value = this.scService.findById(id);
			if (value.isPresent()) {
				SeguridadContrasena sc = value.get();

				SeguridadContrasenaDTO scDto = this.scBuilder.modelToDto(sc);

				return new ResponseOKDto<SeguridadContrasenaDTO>(EndPointConstant.FIND_ONE, TipoMetodoConstant.GET,
						CodigoRespuestaConstant.OK, scDto);
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
	
	@GetMapping(value = "/vigente")
	public ResponseDto findVigente() {
		try {
			SeguridadContrasena sc = this.scService.findFirstByActivoTrueOrderByIdAsc();
			SeguridadContrasenaDTO scDto = this.scBuilder.modelToDto(sc);
						
			return new ResponseOKDto<SeguridadContrasenaDTO>(EndPointConstant.FIND_ONE, TipoMetodoConstant.GET,
					CodigoRespuestaConstant.OK, scDto);
		} catch (Exception e) {
			String messageException = e.getMessage();
			List<String> mensajes = new ArrayList<>();
			mensajes.add(messageException);
			return new ResponseErrorDto(EndPointConstant.FIND_ONE, TipoMetodoConstant.GET,
					CodigoRespuestaConstant.ERROR, mensajes);
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
			List<SeguridadContrasena> sc = (ArrayList<SeguridadContrasena>) this.scService.findAll();

			// Build Model List to Dto List
			List<SeguridadContrasenaDTO> scDto = this.scBuilder.modelListToDto(sc);

			// return
			return new ResponseOKListDto<SeguridadContrasenaDTO>(EndPointConstant.FIND_ALL, TipoMetodoConstant.GET,
					CodigoRespuestaConstant.OK, scDto);

		} catch (Exception e) {
			String messageException = e.getMessage();
			List<String> mensajes = new ArrayList<>();
			mensajes.add(messageException);
			return new ResponseErrorDto(EndPointConstant.FIND_ALL, TipoMetodoConstant.GET,
					CodigoRespuestaConstant.ERROR, mensajes);
		}
	}

}
