package ar.com.ua.builder;

import java.util.ArrayList;
import java.util.List;

import ar.com.ua.dto.PaisDTO;
import ar.com.ua.model.Pais;

public class PaisBuilder implements IBuilder<Pais, PaisDTO> {

	@Override
	public Pais dtoToModel(PaisDTO dto) {
		Pais pais = new Pais();
		pais.setId(dto.getId());
		pais.setCodigo(dto.getCodigo());
		pais.setDescripcion(dto.getDescripcion());
		pais.setActivo(dto.isActivo());
		pais.setSecuenciador(dto.getSecuenciador());
		return pais;
	}

	@Override
	public PaisDTO modelToDto(Pais model) {
		PaisDTO paisDTO = new PaisDTO();
		paisDTO.setId(model.getId());
		paisDTO.setCodigo(model.getCodigo());
		paisDTO.setDescripcion(model.getDescripcion());
		paisDTO.setActivo(model.isActivo());
		paisDTO.setSecuenciador(model.getSecuenciador());
		return paisDTO;
	}

	@Override
	public List<PaisDTO> modelListToDto(List<Pais> list) {
		List<PaisDTO> listDTO = new ArrayList<>();

		for (Pais pais : list) {
			PaisDTO dto = new PaisDTO();
			dto.setId(pais.getId());
			dto.setActivo(pais.isActivo());
			dto.setCodigo(pais.getCodigo());
			dto.setDescripcion(pais.getDescripcion());
			dto.setSecuenciador(pais.getSecuenciador());

			listDTO.add(dto);
		}
		return listDTO;
	}

}
