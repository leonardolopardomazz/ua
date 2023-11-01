package ar.com.ua.builder;

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
		return null;
	}

	/**
	 * Convierte una Entidad (Model) a un Dto
	 */
	@Override
	public EmpleadoDTO modelToDto(Empleado model) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Convierte una lista de la Entidad (Modelo) a una lista de Dto
	 */
	@Override
	public List<EmpleadoDTO> modelListToDto(List<Empleado> list) {
		// TODO Auto-generated method stub
		return null;
	}

}
