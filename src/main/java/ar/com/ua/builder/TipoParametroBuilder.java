package ar.com.ua.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.com.ua.dto.TipoParametroDTO;
import ar.com.ua.model.TipoParametro;

@Component
public class TipoParametroBuilder implements IBuilder<TipoParametro, TipoParametroDTO> {

	@Override
	public TipoParametro dtoToModel(TipoParametroDTO dto) {
		TipoParametro tp = new TipoParametro();
		tp.setId(dto.getId());
		tp.setCodigo(dto.getCodigo());
		tp.setDescripcion(dto.getDescripcion());
		tp.setActivo(dto.isActivo());
		return tp;
	}

	@Override
	public TipoParametroDTO modelToDto(TipoParametro model) {
		TipoParametroDTO tpDto = new TipoParametroDTO();
		tpDto.setId(model.getId());
		tpDto.setCodigo(model.getCodigo());
		tpDto.setDescripcion(model.getDescripcion());
		tpDto.setActivo(model.isActivo());
		return tpDto;
	}

	@Override
	public List<TipoParametroDTO> modelListToDto(List<TipoParametro> list) {

		List<TipoParametroDTO> listTpDto = new ArrayList<>();

		for (TipoParametro tp : list) {
			TipoParametroDTO tpDto = new TipoParametroDTO();
			tpDto.setId(tp.getId());
			tpDto.setCodigo(tp.getCodigo());
			tpDto.setDescripcion(tp.getDescripcion());
			tpDto.setActivo(tp.isActivo());

			listTpDto.add(tpDto);
		}
		return listTpDto;
	}

}
