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

import ar.com.ua.builder.EmpleadoBuilder;
import ar.com.ua.commons.ManejoErrores;
import ar.com.ua.commons.ManejoSesion;
import ar.com.ua.constant.CodigoRespuestaConstant;
import ar.com.ua.constant.EndPointConstant;
import ar.com.ua.constant.EndPointPathConstant;
import ar.com.ua.constant.MensajeError;
import ar.com.ua.constant.PermisosConstant;
import ar.com.ua.constant.TipoMetodoConstant;
import ar.com.ua.controller.report.AccesoPermiso;
import ar.com.ua.dto.EmpleadoDTO;
import ar.com.ua.dto.response.ResponseDto;
import ar.com.ua.dto.response.ResponseErrorDto;
import ar.com.ua.dto.response.ResponseOKDto;
import ar.com.ua.dto.response.ResponseOKListDto;
import ar.com.ua.model.Empleado;
import ar.com.ua.model.Puesto;
import ar.com.ua.service.EmpleadoService;
import ar.com.ua.service.PuestoService;
import jakarta.servlet.http.HttpSession;

@RequestMapping("/empleado")
@RestController
public class EmpleadoController implements IABMController<EmpleadoDTO>, IListController<EmpleadoDTO> {

	@Autowired
	private EmpleadoService empleadoService;

	@Autowired
	private PuestoService puestoService;

	@Autowired
	private EmpleadoBuilder empleadoBuilder;

	@Autowired
	private ManejoSesion manejoSesion;

	@Autowired
	private AccesoPermiso accesoPermiso;

	static Logger logger = Logger.getLogger(EmpleadoController.class.getName());

	private boolean existeEnHistoricoIngresosCaido(List<Long> legajos, Long legajoAGuardar) {
		for (Long legajo : legajos) {
			if (legajo.equals(legajoAGuardar)) {
				return true;
			}
		}

		return false;

	}

	/**
	 * Inserta un empleado a la tabla
	 * 
	 * @return ResponseDto
	 */
	@Override
	public ResponseDto add(EmpleadoDTO dto) {
		try {
			// Chequeo de acceso al reporte
			boolean tieneAcceso = this.accesoPermiso.deteminarAccesoAlRecurso(PermisosConstant.PERMISO_EMPLEADO_ALTA);

			if (!tieneAcceso) {
				return ManejoErrores.errorGenerico(EndPointConstant.ADD, TipoMetodoConstant.POST,
						MensajeError.ACCESS_DENIED);
			}

			final Long numeroLegajoAGuardar = dto.getNumeroLegajo();
			Boolean existsNumeroLegajo = this.empleadoService.existsByNumeroLegajo(numeroLegajoAGuardar);

			List<Long> legajosEnHistoricoIngresoCaido = this.empleadoService.numerosLegajoEnHistoricoIngresoCaido();

			boolean existeEnHistoricoIngresosCaido = this.existeEnHistoricoIngresosCaido(legajosEnHistoricoIngresoCaido,
					numeroLegajoAGuardar);

			if (!existsNumeroLegajo || existeEnHistoricoIngresosCaido) {
				Empleado empleado = empleadoBuilder.dtoToModel(dto);
				Empleado empleadoGuardado = empleadoService.save(empleado);
				EmpleadoDTO empleadoDto = empleadoBuilder.modelToDto(empleadoGuardado);

				return new ResponseOKDto<EmpleadoDTO>(EndPointPathConstant.EMPLEADO, TipoMetodoConstant.POST,
						CodigoRespuestaConstant.OK, empleadoDto);
			}

			return ManejoErrores.errorGenerico(EndPointPathConstant.EMPLEADO, TipoMetodoConstant.POST,
					MensajeError.REPITED_NUMERO_LEGAJO);
		} catch (Exception e) {
			return ManejoErrores.errorGenerico(EndPointPathConstant.EMPLEADO, TipoMetodoConstant.POST, e.getMessage());
		}
	}

	/**
	 * Actualiza un empleado en la tabla
	 */
	@Override
	public ResponseDto modify(@PathVariable Long id, EmpleadoDTO dto) {
		try {
			// Chequeo de acceso al reporte
			boolean tieneAcceso = this.accesoPermiso
					.deteminarAccesoAlRecurso(PermisosConstant.PERMISO_EMPLEADO_MODIFICACION);

			if (!tieneAcceso) {
				return ManejoErrores.errorGenerico(EndPointConstant.MODIFY, TipoMetodoConstant.PUT,
						MensajeError.ACCESS_DENIED);
			}

			final Long numeroLegajoAModificar = dto.getNumeroLegajo();
			dto.setId(id);

			boolean mismoEmpleado = false;

			Optional<Empleado> value = this.empleadoService.findById(id);

			if (value.isPresent()) {
				Empleado empleadoRecuperado = value.get();
				Long numeroLegajoDelEmpleado = empleadoRecuperado.getNumeroLegajo();

				if (numeroLegajoDelEmpleado.equals(numeroLegajoAModificar)) {
					mismoEmpleado = true;
				}
			}

			Boolean existsNumeroLegajo = this.empleadoService.existsByNumeroLegajo(numeroLegajoAModificar);

			if ((mismoEmpleado || !existsNumeroLegajo) || (!mismoEmpleado & !existsNumeroLegajo)) {
				Empleado empleado = empleadoBuilder.dtoToModel(dto);
				Empleado empleadoGuardado = empleadoService.save(empleado);
				EmpleadoDTO empleadoDto = empleadoBuilder.modelToDto(empleadoGuardado);

				return new ResponseOKDto<EmpleadoDTO>(EndPointPathConstant.EMPLEADO, TipoMetodoConstant.PUT,
						CodigoRespuestaConstant.OK, empleadoDto);
			}

			return ManejoErrores.errorGenerico(EndPointPathConstant.EMPLEADO, TipoMetodoConstant.PUT,
					MensajeError.REPITED_NUMERO_LEGAJO);
		} catch (Exception e) {
			return ManejoErrores.errorGenerico(EndPointPathConstant.EMPLEADO, TipoMetodoConstant.PUT, e.getMessage());
		}
	}

	/**
	 * Elimina un empleado de la tabla
	 */
	@Override
	public ResponseDto deleteById(@PathVariable Long id) {

		try {
			// Chequeo de acceso al reporte
			boolean tieneAcceso = this.accesoPermiso.deteminarAccesoAlRecurso(PermisosConstant.PERMISO_EMPLEADO_BAJA);
			if (!tieneAcceso) {
				return ManejoErrores.errorGenerico(EndPointConstant.DELETE, TipoMetodoConstant.DELETE,
						MensajeError.ACCESS_DENIED);
			}

			empleadoService.deleteById(id);

			return new ResponseOKDto<EmpleadoDTO>(EndPointConstant.DELETE, TipoMetodoConstant.DELETE,
					CodigoRespuestaConstant.OK, null);
		} catch (Exception e) {
			return ManejoErrores.errorGenerico(EndPointPathConstant.EMPLEADO, TipoMetodoConstant.DELETE,
					e.getMessage());
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
		try {
			String numeroLegajo = params.get("numeroLegajo");

			List<Empleado> listModel = empleadoService.findByNumeroLegajo(Long.parseLong(numeroLegajo));

			if (!listModel.isEmpty()) {
				List<EmpleadoDTO> listDto = empleadoBuilder.modelListToDto(listModel);

				return new ResponseOKListDto<EmpleadoDTO>(EndPointConstant.FIND_ANY, TipoMetodoConstant.GET,
						CodigoRespuestaConstant.OK, listDto);
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
			return new ResponseErrorDto(EndPointConstant.FIND_ANY, TipoMetodoConstant.DELETE,
					CodigoRespuestaConstant.ERROR, mensajesError);
		}
	}

	@Override
	public ResponseDto findAll() {
		try {

			HttpSession httpSession = this.manejoSesion.getHttpSession();
			httpSession.getAttribute("rolesUsuario");

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

	@GetMapping(value = "/existeempleadoenpuesto/{id}")
	public Boolean existeEmpleadoEnPuesto(@PathVariable Long id) {
		Optional<Puesto> value = this.puestoService.findById(id);
		
		if (value.isPresent()) {
			Puesto puesto = value.get();
			return this.empleadoService.existsByCodigoPuesto(puesto);
		} else {
			return false;
		}
		

	}

	// @PutMapping(value = "/{id}")
	// public ResponseDto changeState(@PathVariable Long id, @RequestBody
	// EmpleadoDTO dto) {
	//
	//
	// return this.save(id, dto, TipoMetodoConstant.PUT);
	// }

}
