package ar.com.ua.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.com.ua.dto.EmpleadoExternoDTO;
import ar.com.ua.model.EmpleadoExterno;

@Component
public class EmpleadoExternoBuilder implements IBuilder<EmpleadoExterno, EmpleadoExternoDTO> {

	/**
	 * Convierte un Dto a una Entidad (Model)
	 */
	@Override
	public EmpleadoExterno dtoToModel(EmpleadoExternoDTO dto) {
		EmpleadoExterno externo = new EmpleadoExterno();
		externo.setId(dto.getId());
		externo.setActivo(dto.isActivo());
		externo.setApellido(dto.getApellido());
		externo.setCodigoDireccion(dto.getCodigoDireccion());
		externo.setCodigoDivision(dto.getCodigoDivision());
		externo.setCodigoGenero(dto.getCodigoGenero());
		externo.setCodigoGerencia(dto.getCodigoGerencia());
		externo.setCodigoJefatura(dto.getCodigoJefatura());
		externo.setCodigoNacionalidad(dto.getCodigoNacionalidad());
		externo.setCodigoPais(dto.getCodigoPais());
		externo.setCodigoProveedor(dto.getCodigoProveedor());
		externo.setCodigoPuesto(dto.getCodigoPuesto());
		externo.setCodigoTipoDocumento(dto.getCodigoTipoDocumento());
		externo.setEmailPersonal(dto.getEmailPersonal());
		externo.setFechaEgreso(dto.getFechaEgreso());
		externo.setFechaIngreso(dto.getFechaIngreso());
		externo.setNombre(dto.getNombre());
		externo.setNumeroDocumento(dto.getNumeroDocumento());
		externo.setNumeroLegajo(dto.getNumeroLegajoExterno());
		externo.setNumeroDocumentoLaboral(dto.getNumeroDocumentoLaboral());

		return externo;
	}

	/**
	 * Convierte una Entidad (Model) a un Dto
	 */
	@Override
	public EmpleadoExternoDTO modelToDto(EmpleadoExterno model) {
		EmpleadoExternoDTO dto = new EmpleadoExternoDTO();
		dto.setId(model.getId());
		dto.setActivo(model.isActivo());
		dto.setApellido(model.getApellido());
		dto.setCodigoDireccion(model.getCodigoDireccion());
		dto.setCodigoDivision(model.getCodigoDivision());
		dto.setCodigoGenero(model.getCodigoGenero());
		dto.setCodigoGerencia(model.getCodigoGerencia());
		dto.setCodigoJefatura(model.getCodigoJefatura());
		dto.setCodigoNacionalidad(model.getCodigoNacionalidad());
		dto.setCodigoPais(model.getCodigoPais());
		dto.setCodigoProveedor(model.getCodigoProveedor());
		dto.setCodigoPuesto(model.getCodigoPuesto());
		dto.setCodigoTipoDocumento(model.getCodigoTipoDocumento());
		dto.setEmailPersonal(model.getEmailPersonal());
		dto.setFechaEgreso(model.getFechaEgreso());
		dto.setFechaIngreso(model.getFechaIngreso());
		dto.setNombre(model.getNombre());
		dto.setNumeroDocumento(model.getNumeroDocumento());
		dto.setNumeroLegajoExterno(model.getNumeroLegajo());
		dto.setNumeroDocumentoLaboral(model.getNumeroDocumentoLaboral());

		return dto;
	}

	/**
	 * Convierte una lista de la Entidad (Modelo) a una lista de Dto
	 */
	@Override
	public List<EmpleadoExternoDTO> modelListToDto(List<EmpleadoExterno> list) {
		List<EmpleadoExternoDTO> listDto = new ArrayList<>();

		for (EmpleadoExterno listExterno : list) {
			EmpleadoExternoDTO dto = new EmpleadoExternoDTO();
			dto.setId(listExterno.getId());
			dto.setActivo(listExterno.isActivo());
			dto.setApellido(listExterno.getApellido());
			dto.setCodigoDireccion(listExterno.getCodigoDireccion());
			dto.setCodigoDivision(listExterno.getCodigoDivision());
			dto.setCodigoGenero(listExterno.getCodigoGenero());
			dto.setCodigoGerencia(listExterno.getCodigoGerencia());
			dto.setCodigoJefatura(listExterno.getCodigoJefatura());
			dto.setCodigoNacionalidad(listExterno.getCodigoNacionalidad());
			dto.setCodigoPais(listExterno.getCodigoPais());
			dto.setCodigoProveedor(listExterno.getCodigoProveedor());
			dto.setCodigoPuesto(listExterno.getCodigoPuesto());
			dto.setCodigoTipoDocumento(listExterno.getCodigoTipoDocumento());
			dto.setEmailPersonal(listExterno.getEmailPersonal());
			dto.setFechaEgreso(listExterno.getFechaEgreso());
			dto.setFechaIngreso(listExterno.getFechaIngreso());
			dto.setNombre(listExterno.getNombre());
			dto.setNumeroDocumento(listExterno.getNumeroDocumento());
			dto.setNumeroLegajoExterno(listExterno.getNumeroLegajo());
			dto.setNumeroDocumentoLaboral(listExterno.getNumeroDocumentoLaboral());

			listDto.add(dto);
		}
		return listDto;
	}

}
