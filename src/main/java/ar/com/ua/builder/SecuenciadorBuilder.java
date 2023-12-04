package ar.com.ua.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.com.ua.dto.SecuenciadorDTO;
import ar.com.ua.model.Secuenciador;

@Component
public class SecuenciadorBuilder implements IBuilder<Secuenciador, SecuenciadorDTO> {

	@Override
	public Secuenciador dtoToModel(SecuenciadorDTO dto) {
		Secuenciador secuenciador = new Secuenciador();
		secuenciador.setId(dto.getId());
		secuenciador.setCodigo(dto.getCodigo());
		secuenciador.setRangoDesde(dto.getRangoDesde());
		secuenciador.setRangoHasta(dto.getRangoHasta());
		secuenciador.setSecuencia(dto.getSecuencia());
		secuenciador.setActivo(dto.isActivo());
		return secuenciador;
	}

	@Override
	public SecuenciadorDTO modelToDto(Secuenciador model) {
		SecuenciadorDTO secuenciadorDto = new SecuenciadorDTO();
		secuenciadorDto.setId(model.getId());
		secuenciadorDto.setCodigo(model.getCodigo());
		secuenciadorDto.setRangoDesde(model.getRangoDesde());
		secuenciadorDto.setRangoHasta(model.getRangoHasta());
		secuenciadorDto.setSecuencia(model.getSecuencia());
		secuenciadorDto.setActivo(model.isActivo());
		return secuenciadorDto;
	}

	@Override
	public List<SecuenciadorDTO> modelListToDto(List<Secuenciador> list) {

		List<SecuenciadorDTO> listSecuenciadorDTO = new ArrayList<>();

		for (Secuenciador secuenciador : list) {
			SecuenciadorDTO secuenciadorDto = new SecuenciadorDTO();
			secuenciadorDto.setId(secuenciador.getId());
			secuenciadorDto.setCodigo(secuenciador.getCodigo());
			secuenciadorDto.setRangoDesde(secuenciador.getRangoDesde());
			secuenciadorDto.setRangoHasta(secuenciador.getRangoHasta());
			secuenciadorDto.setSecuencia(secuenciador.getSecuencia());
			secuenciadorDto.setActivo(secuenciador.isActivo());

			listSecuenciadorDTO.add(secuenciadorDto);
		}

		return listSecuenciadorDTO;
	}

}
