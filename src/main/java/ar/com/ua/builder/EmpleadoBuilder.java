package ar.com.ua.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.com.ua.dto.EmpleadoDTO;
import ar.com.ua.model.Empleado;

@Component
public class EmpleadoBuilder implements IBuilder<Empleado, EmpleadoDTO> {

	/**
	 * Convierte un Dto a una Entidad (Model)
	 */
	@Override
	public Empleado dtoToModel(EmpleadoDTO dto) {
		Empleado empleado = new Empleado();
		empleado.setAfiliadoSindicato(dto.isAfiliadoSindicato());
		empleado.setApellido(dto.getApellido());
		empleado.setCalleResidencia(dto.getCalleResidencia());
		empleado.setCbu(dto.getCbu());
		empleado.setCodigoBanco(dto.getCodigoBanco());
		empleado.setCodigoCategoriaConvenio(dto.getCodigoCategoriaConvenio());
		empleado.setCodigoCentroDeCosto(dto.getCodigoCentroDeCosto());
		empleado.setCodigoConvenio(dto.getCodigoConvenio());
		empleado.setCodigoDivision(dto.getCodigoDivision());
		empleado.setCodigoEstadoEmpleado(dto.getCodigoEstadoEmpleado());
		empleado.setCodigoFrecuenciaLiquidacion(dto.getCodigoFrecuenciaLiquidacion());
		empleado.setCodigoGeneracion(dto.getCodigoGeneracion());
		empleado.setCodigoGenero(dto.getCodigoGenero());
		empleado.setCodigoNacionalidad(dto.getCodigoNacionalidad());
		empleado.setCodigoObraSocial(dto.getCodigoObraSocial());
		empleado.setCodigoOficina(dto.getCodigoOficina());
		empleado.setCodigoPais(dto.getCodigoPais());
		empleado.setCodigoProvincia(dto.getCodigoProvincia());
		empleado.setCodigoPuesto(dto.getCodigoPuesto());
		empleado.setCodigoTipoContratacion(dto.getCodigoTipoContratacion());
		empleado.setCodigoTipoDocumento(dto.getCodigoTipoDocumento());
		empleado.setCodigoTipoEgreso(dto.getCodigoTipoEgreso());
		empleado.setCodigoTipoEmpleo(dto.getCodigoTipoEmpleo());
		empleado.setCodigoTipoJornada(dto.getCodigoTipoJornada());
		empleado.setDepartamentoResidencia(dto.getDepartamentoResidencia());
		empleado.setEmailLaboral(dto.getEmailLaboral());
		empleado.setEmailPersonal(dto.getEmailPersonal());
		empleado.setFechaEgreso(dto.getFechaEgreso());
		empleado.setFechaFinContrato(dto.getFechaFinContrato());
		empleado.setFechaIngreso(dto.getFechaIngreso());
		empleado.setFechaIngresoReconocida(dto.getFechaIngresoReconocida());
		empleado.setFechaNacimiento(dto.getFechaNacimiento());
		empleado.setFte(dto.getFte());
		empleado.setHorasSemanales(dto.getHorasSemanales());
		empleado.setId(dto.getId());
		empleado.setLocalidadResidencia(dto.getLocalidadResidencia());
		empleado.setNombre(dto.getNombre());
		empleado.setNombrePreferido(dto.getNombrePreferido());
		empleado.setNumeroDocumentoPersonal(dto.getNumeroDocumentoPersonal());
		empleado.setNumeroDocumentoLaboral(dto.getNumeroDocumentoLaboral());
		empleado.setNumeroLegajo(dto.getNumeroLegajo());
		empleado.setNumeroResidencia(dto.getNumeroResidencia());
		empleado.setObservaciones(dto.getObservaciones());
		empleado.setPisoResidencia(dto.getPisoResidencia());
		empleado.setSegundoNombre(dto.getSegundoNombre());
		empleado.setCodigoPaisResidencia(dto.getCodigoPaisResidencia());
		empleado.setCodigoEstadoCivil(dto.getCodigoEstadoCivil());
		empleado.setCodigoGrado(dto.getCodigoGrado());
		empleado.setCodigoPrepaga(dto.getCodigoPrepaga());
		
		return empleado;
	}

	/**
	 * Convierte una Entidad (Model) a un Dto
	 */
	@Override
	public EmpleadoDTO modelToDto(Empleado model) {
		EmpleadoDTO empleadoDto = new EmpleadoDTO();
		empleadoDto.setAfiliadoSindicato(model.isAfiliadoSindicato());
		empleadoDto.setApellido(model.getApellido());
		empleadoDto.setCalleResidencia(model.getCalleResidencia());
		empleadoDto.setCbu(model.getCbu());
		empleadoDto.setCodigoBanco(model.getCodigoBanco());
		empleadoDto.setCodigoCategoriaConvenio(model.getCodigoCategoriaConvenio());
		empleadoDto.setCodigoCentroDeCosto(model.getCodigoCentroDeCosto());
		empleadoDto.setCodigoConvenio(model.getCodigoConvenio());
		empleadoDto.setCodigoDivision(model.getCodigoDivision());
		empleadoDto.setCodigoEstadoEmpleado(model.getCodigoEstadoEmpleado());
		empleadoDto.setCodigoFrecuenciaLiquidacion(model.getCodigoFrecuenciaLiquidacion());
		empleadoDto.setCodigoGeneracion(model.getCodigoGeneracion());
		empleadoDto.setCodigoGenero(model.getCodigoGenero());
		empleadoDto.setCodigoNacionalidad(model.getCodigoNacionalidad());
		empleadoDto.setCodigoObraSocial(model.getCodigoObraSocial());
		empleadoDto.setCodigoOficina(model.getCodigoOficina());
		empleadoDto.setCodigoPais(model.getCodigoPais());
		empleadoDto.setCodigoProvincia(model.getCodigoProvincia());
		empleadoDto.setCodigoPuesto(model.getCodigoPuesto());
		empleadoDto.setCodigoTipoContratacion(model.getCodigoTipoContratacion());
		empleadoDto.setCodigoTipoDocumento(model.getCodigoTipoDocumento());
		empleadoDto.setCodigoTipoEgreso(model.getCodigoTipoEgreso());
		empleadoDto.setCodigoTipoEmpleo(model.getCodigoTipoEmpleo());
		empleadoDto.setCodigoTipoJornada(model.getCodigoTipoJornada());
		empleadoDto.setDepartamentoResidencia(model.getDepartamentoResidencia());
		empleadoDto.setEmailLaboral(model.getEmailLaboral());
		empleadoDto.setEmailPersonal(model.getEmailPersonal());
		empleadoDto.setFechaEgreso(model.getFechaEgreso());
		empleadoDto.setFechaFinContrato(model.getFechaFinContrato());
		empleadoDto.setFechaIngreso(model.getFechaIngreso());
		empleadoDto.setFechaIngresoReconocida(model.getFechaIngresoReconocida());
		empleadoDto.setFechaNacimiento(model.getFechaNacimiento());
		empleadoDto.setFte(model.getFte());
		empleadoDto.setHorasSemanales(model.getHorasSemanales());
		empleadoDto.setId(model.getId());
		empleadoDto.setLocalidadResidencia(model.getLocalidadResidencia());
		empleadoDto.setNombre(model.getNombre());
		empleadoDto.setNombrePreferido(model.getNombrePreferido());
		empleadoDto.setNumeroDocumentoPersonal(model.getNumeroDocumentoPersonal());
		empleadoDto.setNumeroDocumentoLaboral(model.getNumeroDocumentoLaboral());
		empleadoDto.setNumeroLegajo(model.getNumeroLegajo());
		empleadoDto.setNumeroResidencia(model.getNumeroResidencia());
		empleadoDto.setObservaciones(model.getObservaciones());
		empleadoDto.setPisoResidencia(model.getPisoResidencia());
		empleadoDto.setSegundoNombre(model.getSegundoNombre());
		empleadoDto.setCodigoPaisResidencia(model.getCodigoPaisResidencia());
		empleadoDto.setCodigoEstadoCivil(model.getCodigoEstadoCivil());
		empleadoDto.setCodigoGrado(model.getCodigoGrado());
		empleadoDto.setCodigoPrepaga(model.getCodigoPrepaga());
		
		return empleadoDto;
	}

	/**
	 * Convierte una lista de la Entidad (Modelo) a una lista de Dto
	 */
	@Override
	public List<EmpleadoDTO> modelListToDto(List<Empleado> list) {

		List<EmpleadoDTO> listEmpleadoDto = new ArrayList<>();
		
		for (Empleado empleado : list) {
			EmpleadoDTO empleadoDto = new EmpleadoDTO();
			empleadoDto.setAfiliadoSindicato(empleado.isAfiliadoSindicato());
			empleadoDto.setApellido(empleado.getApellido());
			empleadoDto.setCalleResidencia(empleado.getCalleResidencia());
			empleadoDto.setCbu(empleado.getCbu());
			empleadoDto.setCodigoBanco(empleado.getCodigoBanco());
			empleadoDto.setCodigoCategoriaConvenio(empleado.getCodigoCategoriaConvenio());
			empleadoDto.setCodigoCentroDeCosto(empleado.getCodigoCentroDeCosto());
			empleadoDto.setCodigoConvenio(empleado.getCodigoConvenio());
			empleadoDto.setCodigoDivision(empleado.getCodigoDivision());
			empleadoDto.setCodigoEstadoEmpleado(empleado.getCodigoEstadoEmpleado());
			empleadoDto.setCodigoFrecuenciaLiquidacion(empleado.getCodigoFrecuenciaLiquidacion());
			empleadoDto.setCodigoGeneracion(empleado.getCodigoGeneracion());
			empleadoDto.setCodigoGenero(empleado.getCodigoGenero());
			empleadoDto.setCodigoNacionalidad(empleado.getCodigoNacionalidad());
			empleadoDto.setCodigoObraSocial(empleado.getCodigoObraSocial());
			empleadoDto.setCodigoOficina(empleado.getCodigoOficina());
			empleadoDto.setCodigoPais(empleado.getCodigoPais());
			empleadoDto.setCodigoProvincia(empleado.getCodigoProvincia());
			empleadoDto.setCodigoPuesto(empleado.getCodigoPuesto());
			empleadoDto.setCodigoTipoContratacion(empleado.getCodigoTipoContratacion());
			empleadoDto.setCodigoTipoDocumento(empleado.getCodigoTipoDocumento());
			empleadoDto.setCodigoTipoEgreso(empleado.getCodigoTipoEgreso());
			empleadoDto.setCodigoTipoEmpleo(empleado.getCodigoTipoEmpleo());
			empleadoDto.setCodigoTipoJornada(empleado.getCodigoTipoJornada());
			empleadoDto.setDepartamentoResidencia(empleado.getDepartamentoResidencia());
			empleadoDto.setEmailLaboral(empleado.getEmailLaboral());
			empleadoDto.setEmailPersonal(empleado.getEmailPersonal());
			empleadoDto.setFechaEgreso(empleado.getFechaEgreso());
			empleadoDto.setFechaFinContrato(empleado.getFechaFinContrato());
			empleadoDto.setFechaIngreso(empleado.getFechaIngreso());
			empleadoDto.setFechaIngresoReconocida(empleado.getFechaIngresoReconocida());
			empleadoDto.setFechaNacimiento(empleado.getFechaNacimiento());
			empleadoDto.setFte(empleado.getFte());
			empleadoDto.setHorasSemanales(empleado.getHorasSemanales());
			empleadoDto.setId(empleado.getId());
			empleadoDto.setLocalidadResidencia(empleado.getLocalidadResidencia());
			empleadoDto.setNombre(empleado.getNombre());
			empleadoDto.setNombrePreferido(empleado.getNombrePreferido());
			empleadoDto.setNumeroDocumentoPersonal(empleado.getNumeroDocumentoPersonal());
			empleadoDto.setNumeroDocumentoLaboral(empleado.getNumeroDocumentoLaboral());
			empleadoDto.setNumeroLegajo(empleado.getNumeroLegajo());
			empleadoDto.setNumeroResidencia(empleado.getNumeroResidencia());
			empleadoDto.setObservaciones(empleado.getObservaciones());
			empleadoDto.setPisoResidencia(empleado.getPisoResidencia());
			empleadoDto.setSegundoNombre(empleado.getSegundoNombre());
			empleadoDto.setCodigoPaisResidencia(empleado.getCodigoPaisResidencia());
			empleadoDto.setCodigoEstadoCivil(empleado.getCodigoEstadoCivil());
			empleadoDto.setCodigoGrado(empleado.getCodigoGrado());
			empleadoDto.setCodigoPrepaga(empleado.getCodigoPrepaga());
			
			listEmpleadoDto.add(empleadoDto);
		}
		return listEmpleadoDto;
	}

}
