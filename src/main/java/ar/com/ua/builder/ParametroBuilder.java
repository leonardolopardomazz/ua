package ar.com.ua.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.com.ua.dto.ParametroDTO;
import ar.com.ua.model.Parametro;

@Component
public class ParametroBuilder implements IBuilder<Parametro, ParametroDTO> {

	/**
	 * Convierte un Dto a una Entidad (Model)
	 */
	@Override
	public Parametro dtoToModel(ParametroDTO dto) {
		Parametro parametro = new Parametro();
		parametro.setId(dto.getId());
		parametro.setCodigo(dto.getCodigo());
		parametro.setDescripcion(dto.getDescripcion());
		parametro.setTexto1(dto.getTexto1());
		parametro.setTexto2(dto.getTexto2());
		parametro.setTipoParametro(dto.getTipoParametro());
		parametro.setActivo(dto.isActivo());
		return parametro;
	}

	/**
	 * Convierte una Entidad (Model) a un Dto
	 */
	@Override
	public ParametroDTO modelToDto(Parametro model) {
		ParametroDTO dto = new ParametroDTO();
		dto.setId(model.getId());
		dto.setCodigo(model.getCodigo());
		dto.setDescripcion(model.getDescripcion());
		dto.setTexto1(model.getTexto1());
		dto.setTexto2(model.getTexto2());
		dto.setTipoParametro(model.getTipoParametro());
		dto.setActivo(model.isActivo());
		return dto;
	}

	/**
	 * Convierte una lista de la Entidad (Modelo) a una lista de Dto
	 */
	@Override
	public List<ParametroDTO> modelListToDto(List<Parametro> list) {
		List<ParametroDTO> listParametroDto = new ArrayList<>();
		for (Parametro parametro : list) {
			ParametroDTO dto = new ParametroDTO();
			dto.setId(parametro.getId());
			dto.setCodigo(parametro.getCodigo());
			dto.setDescripcion(parametro.getDescripcion());
			dto.setTexto1(parametro.getTexto1());
			dto.setTexto2(parametro.getTexto2());
			dto.setTipoParametro(parametro.getTipoParametro());
			dto.setActivo(parametro.isActivo());

			listParametroDto.add(dto);
		}
		return listParametroDto;
	}

}
