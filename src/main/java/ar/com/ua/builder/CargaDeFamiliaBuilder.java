package ar.com.ua.builder;

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
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Convierte una Entidad (Model) a un Dto
	 */
	@Override
	public CargaDeFamiliaDTO modelToDto(CargaDeFamilia model) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Convierte una lista de la Entidad (Modelo) a una lista de Dto
	 */
	@Override
	public List<CargaDeFamiliaDTO> modelListToDto(List<CargaDeFamilia> list) {
		// TODO Auto-generated method stub
		return null;
	}

}
