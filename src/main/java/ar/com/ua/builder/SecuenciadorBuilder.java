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
		secuenciador.setEstado(dto.getEstado());
		secuenciador.setFechaRangoDesde(dto.getFechaRangoDesde());
		secuenciador.setFechaRangoHasta(dto.getFechaRangoHasta());
		secuenciador.setSecuencia(dto.getSecuencia());
		secuenciador.setActivo(dto.isActivo());
		return secuenciador;
	}

	@Override
	public SecuenciadorDTO modelToDto(Secuenciador model) {
		SecuenciadorDTO secuenciadorDto = new SecuenciadorDTO();
		secuenciadorDto.setId(model.getId());
		secuenciadorDto.setCodigo(model.getCodigo());
		secuenciadorDto.setEstado(model.getEstado());
		secuenciadorDto.setFechaRangoDesde(model.getFechaRangoDesde());
		secuenciadorDto.setFechaRangoHasta(model.getFechaRangoHasta());
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
			secuenciadorDto.setEstado(secuenciador.getEstado());
			secuenciadorDto.setFechaRangoDesde(secuenciador.getFechaRangoDesde());
			secuenciadorDto.setFechaRangoHasta(secuenciador.getFechaRangoHasta());
			secuenciadorDto.setSecuencia(secuenciador.getSecuencia());
			secuenciadorDto.setActivo(secuenciador.isActivo());

			listSecuenciadorDTO.add(secuenciadorDto);
		}

		return listSecuenciadorDTO;
	}

}
