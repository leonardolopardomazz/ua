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

import ar.com.ua.builder.EmpleadoBuilder;
import ar.com.ua.constant.CodigoRespuestaConstant;
import ar.com.ua.constant.EndPointConstant;
import ar.com.ua.constant.EndPointPathConstant;
import ar.com.ua.constant.MensajeError;
import ar.com.ua.constant.TipoMetodoConstant;
import ar.com.ua.dto.EmpleadoDTO;
import ar.com.ua.dto.response.ResponseDto;
import ar.com.ua.dto.response.ResponseErrorDto;
import ar.com.ua.dto.response.ResponseOKDto;
import ar.com.ua.dto.response.ResponseOKListDto;
import ar.com.ua.model.Empleado;
import ar.com.ua.service.EmpleadoService;

@RequestMapping("/empleado")
@RestController
public class EmpleadoController implements IABMController<EmpleadoDTO>, IListController<EmpleadoDTO> {

	@Autowired
	private EmpleadoService empleadoService;

	@Autowired
	private EmpleadoBuilder empleadoBuilder;

	static Logger logger = Logger.getLogger(EmpleadoController.class.getName());

	private ResponseDto save(Long id, EmpleadoDTO dto, String tipoMetodoConstant) {
		dto.setId(id);
		return this.save(dto, tipoMetodoConstant);
	}

	private ResponseDto save(EmpleadoDTO dto, String tipoMetodoConstant) {
		List<String> mensajesError = new ArrayList<String>();

		try {
			Empleado empleado = empleadoBuilder.dtoToModel(dto);
			Empleado empleadoGuardado = empleadoService.save(empleado);
			EmpleadoDTO eexternoDto = empleadoBuilder.modelToDto(empleadoGuardado);
			return new ResponseOKDto<EmpleadoDTO>(EndPointPathConstant.EMPLEADO, tipoMetodoConstant,
					CodigoRespuestaConstant.OK, eexternoDto);
		} catch (Exception e) {
			String messageException = e.getMessage();
			mensajesError.add(messageException);

			return new ResponseErrorDto(EndPointPathConstant.EMPLEADO, tipoMetodoConstant,
					CodigoRespuestaConstant.ERROR, mensajesError);
		}
	}

	/**
	 * Inserta un empleado a la tabla
	 * 
	 * @return ResponseDto
	 */
	@Override
	public ResponseDto add(EmpleadoDTO dto) {
		return this.save(dto, TipoMetodoConstant.POST);
	}

	/**
	 * Actualiza un empleado en la tabla
	 */
	@Override
	public ResponseDto modify(@PathVariable Long id, EmpleadoDTO dto) {
		return this.save(id, dto, TipoMetodoConstant.PUT);
	}

	/**
	 * Elimina un empleado de la tabla
	 */
	@Override
	public ResponseDto deleteById(@PathVariable Long id) {
		List<String> mensajesError = new ArrayList<String>();

		try {
			empleadoService.deleteById(id);

			return new ResponseOKDto<EmpleadoDTO>(EndPointConstant.DELETE, TipoMetodoConstant.DELETE,
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
			Optional<Empleado> value = empleadoService.findById(id);
			if (value.isPresent()) {
				Empleado empleado = value.get();

				EmpleadoDTO empleadoDto = empleadoBuilder.modelToDto(empleado);

				return new ResponseOKDto<EmpleadoDTO>(EndPointConstant.FIND_ONE, TipoMetodoConstant.GET,
						CodigoRespuestaConstant.OK, empleadoDto);
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
			List<Empleado> empleado = (ArrayList<Empleado>) empleadoService.findAll();

			// Build Model List to Dto List
			List<EmpleadoDTO> empleadoDto = empleadoBuilder.modelListToDto(empleado);

			// return
			return new ResponseOKListDto<EmpleadoDTO>(EndPointConstant.FIND_ALL, TipoMetodoConstant.GET,
					CodigoRespuestaConstant.OK, empleadoDto);

		} catch (Exception e) {
			String messageException = e.getMessage();
			List<String> mensajes = new ArrayList<>();
			mensajes.add(messageException);
			return new ResponseErrorDto(EndPointConstant.FIND_ALL, TipoMetodoConstant.GET,
					CodigoRespuestaConstant.ERROR, mensajes);
		}
	}

//	@PutMapping(value = "/{id}")
//	public ResponseDto changeState(@PathVariable Long id, @RequestBody EmpleadoDTO dto) {
//		
//		
//		return this.save(id, dto, TipoMetodoConstant.PUT);
//	}

}
