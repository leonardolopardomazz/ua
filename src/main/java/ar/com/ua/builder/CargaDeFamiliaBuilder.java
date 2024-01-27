package ar.com.ua.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.com.ua.dto.CargaDeFamiliaDTO;
import ar.com.ua.model.CargaDeFamilia;

@Component
public class CargaDeFamiliaBuilder implements IBuilder<CargaDeFamilia, CargaDeFamiliaDTO> {

	/**
	 * Convierte un Dto a una Entidad (Model)
	 */
	@Override
	public CargaDeFamilia dtoToModel(CargaDeFamiliaDTO dto) {
		CargaDeFamilia cdf = new CargaDeFamilia();
		cdf.setId(dto.getId());
		cdf.setNombre(dto.getNombre());
		cdf.setApellido(dto.getApellido());
		cdf.setCodigoParentesco(dto.getCodigoParentesco());
		cdf.setCodigoTipoDocumento(dto.getCodigoTipoDocumento());
		cdf.setFechaNacimiento(dto.getFechaNacimiento());
		cdf.setNumeroDocumento(dto.getNumeroDocumento());
		cdf.setNumeroLegajo(dto.getNumeroLegajo());
		cdf.setActivo(dto.isActivo());
		cdf.setEmpleado(dto.getEmpleado());
		return cdf;
	}

	/**
	 * Convierte una Entidad (Model) a un Dto
	 */
	@Override
	public CargaDeFamiliaDTO modelToDto(CargaDeFamilia model) {
		CargaDeFamiliaDTO dto = new CargaDeFamiliaDTO();
		dto.setId(model.getId());
		dto.setNombre(model.getNombre());
		dto.setApellido(model.getApellido());
		dto.setCodigoParentesco(model.getCodigoParentesco());
		dto.setCodigoTipoDocumento(model.getCodigoTipoDocumento());
		dto.setFechaNacimiento(model.getFechaNacimiento());
		dto.setNumeroDocumento(model.getNumeroDocumento());
		dto.setNumeroLegajo(model.getNumeroLegajo());
		dto.setActivo(model.isActivo());
		dto.setEmpleado(model.getEmpleado());
		return dto;
	}

	/**
	 * Convierte una lista de la Entidad (Modelo) a una lista de Dto
	 */
	@Override
	public List<CargaDeFamiliaDTO> modelListToDto(List<CargaDeFamilia> list) {
		List<CargaDeFamiliaDTO> listCdfDto = new ArrayList<>();

		for (CargaDeFamilia cdf : list) {
			CargaDeFamiliaDTO dto = new CargaDeFamiliaDTO();
			dto.setId(cdf.getId());
			dto.setNombre(cdf.getNombre());
			dto.setApellido(cdf.getApellido());
			dto.setCodigoParentesco(cdf.getCodigoParentesco());
			dto.setCodigoTipoDocumento(cdf.getCodigoTipoDocumento());
			dto.setFechaNacimiento(cdf.getFechaNacimiento());
			dto.setNumeroDocumento(cdf.getNumeroDocumento());
			dto.setNumeroLegajo(cdf.getNumeroLegajo());
			dto.setActivo(cdf.isActivo());
			dto.setEmpleado(cdf.getEmpleado());

			listCdfDto.add(dto);
		}

		return listCdfDto;
	}

}
