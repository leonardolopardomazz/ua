package ar.com.ua.builder;

import java.util.List;

import ar.com.ua.dto.ParametroDTO;
import ar.com.ua.model.Parametro;

public class ParametroBuilder implements IBuilder<Parametro, ParametroDTO> {

	/**
	 * Convierte un Dto a una Entidad (Model)
	 */
	@Override
	public Parametro dtoToModel(ParametroDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Convierte una Entidad (Model) a un Dto
	 */
	@Override
	public ParametroDTO modelToDto(Parametro model) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Convierte una lista de la Entidad (Modelo) a una lista de Dto
	 */
	@Override
	public List<ParametroDTO> modelListToDto(List<Parametro> list) {
		// TODO Auto-generated method stub
		return null;
	}

}
