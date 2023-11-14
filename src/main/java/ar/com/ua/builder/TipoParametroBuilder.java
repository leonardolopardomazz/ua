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
		tp.setActivo(dto.isActivo());
		tp.setCodigo(dto.getCodigo());
		tp.setDescripcion(dto.getDescripcion());

		return tp;
	}

	@Override
	public TipoParametroDTO modelToDto(TipoParametro model) {
		TipoParametroDTO tpDto = new TipoParametroDTO();
		tpDto.setActivo(model.isActivo());
		tpDto.setCodigo(model.getCodigo());
		tpDto.setDescripcion(model.getDescripcion());

		return tpDto;
	}

	@Override
	public List<TipoParametroDTO> modelListToDto(List<TipoParametro> list) {

		List<TipoParametroDTO> listTpDto = new ArrayList<>();

		for (TipoParametro tp : list) {
			TipoParametroDTO tpDto = new TipoParametroDTO();
			tpDto.setActivo(tp.isActivo());
			tpDto.setCodigo(tp.getCodigo());
			tpDto.setDescripcion(tp.getDescripcion());

			listTpDto.add(tpDto);
		}
		return listTpDto;
	}

}
