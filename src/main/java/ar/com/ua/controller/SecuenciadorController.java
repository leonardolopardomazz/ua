package ar.com.ua.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ua.builder.SecuenciadorBuilder;
import ar.com.ua.constant.CodigoRespuestaConstant;
import ar.com.ua.constant.EndPointConstant;
import ar.com.ua.constant.EndPointPathConstant;
import ar.com.ua.constant.MensajeError;
import ar.com.ua.constant.TipoMetodoConstant;
import ar.com.ua.dto.SecuenciadorDTO;
import ar.com.ua.dto.response.ResponseDto;
import ar.com.ua.dto.response.ResponseErrorDto;
import ar.com.ua.dto.response.ResponseOKDto;
import ar.com.ua.dto.response.ResponseOKListDto;
import ar.com.ua.model.HistorialIngresoCaidos;
import ar.com.ua.model.Secuenciador;
import ar.com.ua.service.HistorialIngresoCaidosService;
import ar.com.ua.service.SecuenciadorService;

@RequestMapping("/secuenciador")
@RestController
public class SecuenciadorController implements IABMController<SecuenciadorDTO>, IListController<SecuenciadorDTO> {

	@Autowired
	private SecuenciadorService secuenciadorService;

	@Autowired
	private HistorialIngresoCaidosService hicService;

	@Autowired
	private SecuenciadorBuilder secuenciadorBuilder;

	static Logger logger = Logger.getLogger(SecuenciadorController.class.getName());

	private ResponseDto save(Long id, SecuenciadorDTO dto, String tipoMetodoConstant) {
		// Setteo el id para la actualizacion
		dto.setId(id);
		return this.save(dto, tipoMetodoConstant);
	}

	private ResponseDto save(SecuenciadorDTO dto, String tipoMetodoConstant) {
		List<String> mensajesError = new ArrayList<String>();

		try {
			Secuenciador secuenciador = secuenciadorBuilder.dtoToModel(dto);
			Secuenciador secuenciadorGuardado = secuenciadorService.save(secuenciador);
			SecuenciadorDTO secuenciadorDto = secuenciadorBuilder.modelToDto(secuenciadorGuardado);
			return new ResponseOKDto<SecuenciadorDTO>(EndPointPathConstant.SECUENCIADOR, tipoMetodoConstant,
					CodigoRespuestaConstant.OK, secuenciadorDto);
		} catch (Exception e) {
			String messageException = e.getMessage();
			mensajesError.add(messageException);

			return new ResponseErrorDto(EndPointPathConstant.SECUENCIADOR, tipoMetodoConstant,
					CodigoRespuestaConstant.ERROR, mensajesError);
		}
	}

	/**
	 * Inserta un secuenciador a la tabla
	 * 
	 * @return ResponseDto
	 */
	@Override
	public ResponseDto add(SecuenciadorDTO dto) {
		return this.save(dto, TipoMetodoConstant.POST);
	}

	/**
	 * Actualiza una carga de familia en la tabla
	 */
	@Override
	public ResponseDto modify(@PathVariable Long id, SecuenciadorDTO dto) {
		return this.save(id, dto, TipoMetodoConstant.PUT);
	}

	/**
	 * Elimina un secuenciador de la tabla
	 */
	@Override
	public ResponseDto deleteById(@PathVariable Long id) {
		List<String> mensajesError = new ArrayList<String>();

		try {
			secuenciadorService.deleteById(id);

			return new ResponseOKDto<SecuenciadorDTO>(EndPointConstant.DELETE, TipoMetodoConstant.DELETE,
					CodigoRespuestaConstant.OK, null);
		} catch (Exception e) {
			String messageException = e.getMessage();
			mensajesError.add(messageException);
			return new ResponseErrorDto(EndPointConstant.DELETE, TipoMetodoConstant.DELETE,
					CodigoRespuestaConstant.ERROR, mensajesError);
		}
	}

	private Long setNumeroLegajoIfExistsInHistorialIngresoCaido(String codigo) {
		try {
			Long numeroLegajo = null;
			// Si existe un ingreso caido, tengo que detectar cual es el legajo que se le
			// asignó a ese empleado según el país.
			if (this.hicService.count() != 0) {
				List<HistorialIngresoCaidos> hics = this.hicService.findAllByEmpleadoIsNotNull();

				
				for (HistorialIngresoCaidos hic : hics) {
					if (hic.getEmpleado().getCodigoPais().getSecuenciador().getCodigo().equals(codigo) && hic.isActivo() == true) {
						hic.setActivo(false);
						this.hicService.save(hic);
						numeroLegajo = hic.getEmpleado().getNumeroLegajo();
					}
				}
			}
			return numeroLegajo;
		} catch (Exception e) {
			throw e;
		}
	}

	@GetMapping(value = "/secuencia/{codigo}")
	public ResponseDto getMaxValue(@PathVariable String codigo) {

		try {

			Long numeroLegajo = setNumeroLegajoIfExistsInHistorialIngresoCaido(codigo);

			Secuenciador secuenciador = this.secuenciadorService.findByCodigo(codigo);
			if (numeroLegajo != null) {
				secuenciador.setSecuencia(numeroLegajo);
			} else {
				secuenciador.setSecuencia(secuenciador.getSecuencia() + 1);
			}

			SecuenciadorDTO secuenciadorDto = secuenciadorBuilder.modelToDto(secuenciador);

			return new ResponseOKDto<SecuenciadorDTO>(EndPointConstant.FIND_ONE, TipoMetodoConstant.GET,
					CodigoRespuestaConstant.OK, secuenciadorDto);
		} catch (Exception e) {
			List<String> mensajesError = new ArrayList<String>();
			String messageException = e.getMessage();
			mensajesError.add(messageException);
			return new ResponseErrorDto(EndPointConstant.FIND_ONE, TipoMetodoConstant.GET,
					CodigoRespuestaConstant.ERROR, mensajesError);
		}
	}

	@Override
	public ResponseDto findOne(Long id) {

		try {
			Optional<Secuenciador> value = secuenciadorService.findById(id);
			if (value.isPresent()) {
				Secuenciador secuenciador = value.get();

				SecuenciadorDTO secuenciadorDto = secuenciadorBuilder.modelToDto(secuenciador);

				return new ResponseOKDto<SecuenciadorDTO>(EndPointConstant.FIND_ONE, TipoMetodoConstant.GET,
						CodigoRespuestaConstant.OK, secuenciadorDto);
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
		try {
			String codigo = params.get("codigo");
			Secuenciador model = secuenciadorService.findByCodigo(codigo);

			if (model != null) {
				SecuenciadorDTO dto = secuenciadorBuilder.modelToDto(model);

				return new ResponseOKDto<SecuenciadorDTO>(EndPointConstant.FIND_ANY, TipoMetodoConstant.GET,
						CodigoRespuestaConstant.OK, dto);
			} else {
				List<String> mensajesError = new ArrayList<String>();
				mensajesError.add(MensajeError.ELEMENT_NOTFOUND_MESSAGE);

				return new ResponseErrorDto(EndPointConstant.FIND_ANY, TipoMetodoConstant.GET,
						CodigoRespuestaConstant.ERROR, mensajesError);
			}

		} catch (Exception e) {
			List<String> mensajesError = new ArrayList<String>();
			String messageException = e.getMessage();
			mensajesError.add(messageException);
			return new ResponseErrorDto(EndPointConstant.FIND_ANY, TipoMetodoConstant.GET,
					CodigoRespuestaConstant.ERROR, mensajesError);
		}
	}

	@Override
	public ResponseDto findAll() {
		try {
			// List
			List<Secuenciador> secuenciador = (ArrayList<Secuenciador>) secuenciadorService.findAll();

			// Build Model List to Dto List
			List<SecuenciadorDTO> secuenciadorDto = secuenciadorBuilder.modelListToDto(secuenciador);

			// return
			return new ResponseOKListDto<SecuenciadorDTO>(EndPointConstant.FIND_ALL, TipoMetodoConstant.GET,
					CodigoRespuestaConstant.OK, secuenciadorDto);

		} catch (Exception e) {
			String messageException = e.getMessage();
			List<String> mensajes = new ArrayList<>();
			mensajes.add(messageException);
			return new ResponseErrorDto(EndPointConstant.FIND_ALL, TipoMetodoConstant.GET,
					CodigoRespuestaConstant.ERROR, mensajes);
		}
	}

}
