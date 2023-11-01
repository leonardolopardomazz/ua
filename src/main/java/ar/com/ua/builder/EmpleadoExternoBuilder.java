package ar.com.ua.builder;

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
		return null;
	}

	/**
	 * Convierte una Entidad (Model) a un Dto
	 */
	@Override
	public EmpleadoExternoDTO modelToDto(EmpleadoExterno model) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Convierte una lista de la Entidad (Modelo) a una lista de Dto
	 */
	@Override
	public List<EmpleadoExternoDTO> modelListToDto(List<EmpleadoExterno> list) {
		// TODO Auto-generated method stub
		return null;
	}

}
