package ar.com.ua.builder;

import java.util.List;

import ar.com.ua.dto.PuestoDTO;
import ar.com.ua.model.Puesto;

public class PuestoBuilder implements IBuilder<Puesto, PuestoDTO> {

	/**
	 * Convierte un Dto a una Entidad (Model)
	 */
	@Override
	public Puesto dtoToModel(PuestoDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Convierte una Entidad (Model) a un Dto
	 */
	@Override
	public PuestoDTO modelToDto(Puesto model) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Convierte una lista de la Entidad (Modelo) a una lista de Dto
	 */
	@Override
	public List<PuestoDTO> modelListToDto(List<Puesto> list) {
		// TODO Auto-generated method stub
		return null;
	}

}
