package ar.com.ua.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.com.ua.dto.PuestoDTO;
import ar.com.ua.model.Puesto;

@Component
public class PuestoBuilder implements IBuilder<Puesto, PuestoDTO> {

	/**
	 * Convierte un Dto a una Entidad (Model)
	 */
	@Override
	public Puesto dtoToModel(PuestoDTO dto) {
		Puesto puesto = new Puesto();
		puesto.setId(dto.getId());
		puesto.setCodigoCentroDeCosto(dto.getCodigoCentroDeCosto());
		puesto.setActivo(dto.isActivo());
		puesto.setDescripcion(dto.getDescripcion());
		puesto.setCodigoCategoria(dto.getCodigoCategoria());
		puesto.setCodigoDireccion(dto.getCodigoCategoria());
		puesto.setCodigoGerencia(dto.getCodigoGerencia());
		puesto.setCodigoJefatura(dto.getCodigoJefatura());
		puesto.setCodigoPuestoAlQueReporta(dto.getCodigoPuestoAlQueReporta());
		
		return puesto;
	}

	/**
	 * Convierte una Entidad (Model) a un Dto
	 */
	@Override
	public PuestoDTO modelToDto(Puesto model) {
		PuestoDTO dto = new PuestoDTO();
		dto.setId(model.getId());
		dto.setCodigoCentroDeCosto(model.getCodigoCentroDeCosto());
		dto.setActivo(model.isActivo());
		dto.setDescripcion(model.getDescripcion());
		dto.setCodigoCategoria(model.getCodigoCategoria());
		dto.setCodigoDireccion(model.getCodigoCategoria());
		dto.setCodigoGerencia(model.getCodigoGerencia());
		dto.setCodigoJefatura(model.getCodigoJefatura());
		dto.setCodigoPuestoAlQueReporta(model.getCodigoPuestoAlQueReporta());
		
		return dto;
	}

	/**
	 * Convierte una lista de la Entidad (Modelo) a una lista de Dto
	 */
	@Override
	public List<PuestoDTO> modelListToDto(List<Puesto> list) {
		
		List<PuestoDTO> listPuestoDTO = new ArrayList<>();
		
		for (Puesto puesto : list) {
			PuestoDTO puestoDTO = new PuestoDTO();
			puestoDTO.setId(puesto.getId());
			puestoDTO.setCodigoCentroDeCosto(puesto.getCodigoCentroDeCosto());
			puestoDTO.setActivo(puesto.isActivo());
			puestoDTO.setDescripcion(puesto.getDescripcion());
			puestoDTO.setCodigoCategoria(puesto.getCodigoCategoria());
			puestoDTO.setCodigoDireccion(puesto.getCodigoCategoria());
			puestoDTO.setCodigoGerencia(puesto.getCodigoGerencia());
			puestoDTO.setCodigoJefatura(puesto.getCodigoJefatura());
			puestoDTO.setCodigoPuestoAlQueReporta(puesto.getCodigoPuestoAlQueReporta());
			
			listPuestoDTO.add(puestoDTO);
		}
		
		return listPuestoDTO;
	}

}
