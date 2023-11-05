package ar.com.ua.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ua.builder.EmpleadoBuilder;
import ar.com.ua.constant.CodigoRespuestaConstant;
import ar.com.ua.constant.EndPointConstant;
import ar.com.ua.constant.EndPointPathConstant;
import ar.com.ua.constant.TipoMetodoConstant;
import ar.com.ua.dto.EmpleadoDTO;
import ar.com.ua.dto.response.ResponseDto;
import ar.com.ua.dto.response.ResponseErrorDto;
import ar.com.ua.dto.response.ResponseOKDto;
import ar.com.ua.model.Empleado;
import ar.com.ua.service.EmpleadoService;

@RequestMapping("/empleado")
@RestController
public class EmpleadoController implements IABMController<EmpleadoDTO> {

	@Autowired
	private EmpleadoService empleadoService;

	@Autowired
	private EmpleadoBuilder empleadoBuilder;

	static Logger logger = Logger.getLogger(EmpleadoController.class.getName());

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
	 * Inserta un empleado externo a la tabla
	 * 
	 * @return ResponseDto
	 */
	@Override
	public ResponseDto add(EmpleadoDTO dto) {
		return this.save(dto, TipoMetodoConstant.POST);
	}

	/**
	 * Actualiza un Empleado externo en la tabla
	 */
	@Override
	public ResponseDto modify(@PathVariable Long id, EmpleadoDTO dto) {
		return this.save(dto, TipoMetodoConstant.PUT);
	}

	/**
	 * Elimina un empleado externo de la tabla
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

}
