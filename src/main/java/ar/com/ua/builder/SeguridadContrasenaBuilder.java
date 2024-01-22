package ar.com.ua.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.com.ua.dto.SeguridadContrasenaDTO;
import ar.com.ua.model.SeguridadContrasena;

@Component
public class SeguridadContrasenaBuilder implements IBuilder<SeguridadContrasena, SeguridadContrasenaDTO> {

	@Override
	public SeguridadContrasena dtoToModel(SeguridadContrasenaDTO dto) {
		SeguridadContrasena sc = new SeguridadContrasena();
		sc.setId(dto.getId());
		sc.setFechaValidezFin(dto.getFechaValidezFin());
		sc.setFechaValidezInicio(dto.getFechaValidezInicio());
		sc.setPatron(dto.getPatron());
		sc.setRegla(dto.getRegla());
		sc.setActivo(dto.isActivo());
		return sc;
	}

	@Override
	public SeguridadContrasenaDTO modelToDto(SeguridadContrasena model) {
		SeguridadContrasenaDTO dto = new SeguridadContrasenaDTO();
		dto.setId(model.getId());
		dto.setFechaValidezFin(model.getFechaValidezFin());
		dto.setFechaValidezInicio(model.getFechaValidezInicio());
		dto.setPatron(model.getPatron());
		dto.setRegla(model.getRegla());
		dto.setActivo(model.isActivo());
		return dto;
	}

	@Override
	public List<SeguridadContrasenaDTO> modelListToDto(List<SeguridadContrasena> list) {

		List<SeguridadContrasenaDTO> listDto = new ArrayList<>();

		for (SeguridadContrasena sc : list) {
			SeguridadContrasenaDTO dto = new SeguridadContrasenaDTO();
			dto.setId(sc.getId());
			dto.setFechaValidezFin(sc.getFechaValidezFin());
			dto.setFechaValidezInicio(sc.getFechaValidezInicio());
			dto.setPatron(sc.getPatron());
			dto.setRegla(sc.getRegla());
			dto.setActivo(sc.isActivo());

			listDto.add(dto);
		}
		return listDto;
	}

}
