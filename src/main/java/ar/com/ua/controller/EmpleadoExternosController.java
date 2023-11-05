package ar.com.ua.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ua.builder.EmpleadoExternoBuilder;
import ar.com.ua.constant.CodigoRespuestaConstant;
import ar.com.ua.constant.EndPointConstant;
import ar.com.ua.constant.EndPointPathConstant;
import ar.com.ua.constant.TipoMetodoConstant;
import ar.com.ua.dto.EmpleadoExternoDTO;
import ar.com.ua.dto.response.ResponseDto;
import ar.com.ua.dto.response.ResponseErrorDto;
import ar.com.ua.dto.response.ResponseOKDto;
import ar.com.ua.model.EmpleadoExterno;
import ar.com.ua.service.EmpleadoExternoService;

@RequestMapping("/empleadoexterno")
@RestController
public class EmpleadoExternosController implements IABMController<EmpleadoExternoDTO> {

	@Autowired
	private EmpleadoExternoService eexternoService;

	@Autowired
	private EmpleadoExternoBuilder eexternoBuilder;

	static Logger logger = Logger.getLogger(EmpleadoExternosController.class.getName());

	private ResponseDto save(EmpleadoExternoDTO dto, String tipoMetodoConstant) {
		List<String> mensajesError = new ArrayList<String>();

		try {
			EmpleadoExterno eexterno = eexternoBuilder.dtoToModel(dto);
			EmpleadoExterno eexternoGuardado = eexternoService.save(eexterno);
			EmpleadoExternoDTO eexternoDto = eexternoBuilder.modelToDto(eexternoGuardado);
			return new ResponseOKDto<EmpleadoExternoDTO>(EndPointPathConstant.EMPLEADO_EXTERNO, tipoMetodoConstant,
					CodigoRespuestaConstant.OK, eexternoDto);
		} catch (Exception e) {
			String messageException = e.getMessage();
			mensajesError.add(messageException);

			return new ResponseErrorDto(EndPointPathConstant.EMPLEADO_EXTERNO, tipoMetodoConstant,
					CodigoRespuestaConstant.ERROR, mensajesError);
		}
	}

	/**
	 * Inserta un empleado externo a la tabla
	 * 
	 * @return ResponseDto
	 */
	@Override
	public ResponseDto add(EmpleadoExternoDTO dto) {
		return this.save(dto, TipoMetodoConstant.POST);
	}

	/**
	 * Actualiza un Empleado externo en la tabla
	 */
	@Override
	public ResponseDto modify(@PathVariable Long id, EmpleadoExternoDTO dto) {
		return this.save(dto, TipoMetodoConstant.PUT);
	}

	/**
	 * Elimina un empleado externo de la tabla
	 */
	@Override
	public ResponseDto deleteById(@PathVariable Long id) {
		List<String> mensajesError = new ArrayList<String>();

		try {
			eexternoService.deleteById(id);

			return new ResponseOKDto<EmpleadoExternoDTO>(EndPointConstant.DELETE, TipoMetodoConstant.DELETE,
					CodigoRespuestaConstant.OK, null);
		} catch (Exception e) {
			String messageException = e.getMessage();
			mensajesError.add(messageException);
			return new ResponseErrorDto(EndPointConstant.DELETE, TipoMetodoConstant.DELETE,
					CodigoRespuestaConstant.ERROR, mensajesError);
		}
	}

}
