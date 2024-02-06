package ar.com.ua.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.com.ua.dto.ParametrosSeguridadContrasenaDTO;
import ar.com.ua.model.ParametrosSeguridadContrasena;

@Component
public class ParametrosSeguridadContrasenaBuilder
		implements IBuilder<ParametrosSeguridadContrasena, ParametrosSeguridadContrasenaDTO> {

	@Override
	public ParametrosSeguridadContrasena dtoToModel(ParametrosSeguridadContrasenaDTO dto) {
		ParametrosSeguridadContrasena psc = new ParametrosSeguridadContrasena();
		psc.setId(dto.getId());
		psc.setCantidadReintentosValidos(dto.getCantidadReintentos());
		psc.setDiasValidezContrasena(dto.getDiasValidezContrasena());
		psc.setActivo(dto.isActivo());
		psc.setFechaValidezInicio(dto.getFechaValidezInicio());
		psc.setFechaValidezFin(dto.getFechaValidezFin());
		return psc;
	}

	@Override
	public ParametrosSeguridadContrasenaDTO modelToDto(ParametrosSeguridadContrasena model) {
		ParametrosSeguridadContrasenaDTO dto = new ParametrosSeguridadContrasenaDTO();
		dto.setId(model.getId());
		dto.setCantidadReintentos(model.getCantidadReintentosValidos());
		dto.setDiasValidezContrasena(model.getDiasValidezContrasena());
		dto.setActivo(model.isActivo());
		dto.setFechaValidezInicio(model.getFechaValidezInicio());
		dto.setFechaValidezFin(model.getFechaValidezFin());
		return dto;
	}

	@Override
	public List<ParametrosSeguridadContrasenaDTO> modelListToDto(List<ParametrosSeguridadContrasena> list) {
		List<ParametrosSeguridadContrasenaDTO> listDto = new ArrayList<>();

		for (ParametrosSeguridadContrasena psc : list) {
			ParametrosSeguridadContrasenaDTO dto = new ParametrosSeguridadContrasenaDTO();
			dto.setId(psc.getId());
			dto.setCantidadReintentos(psc.getCantidadReintentosValidos());
			dto.setDiasValidezContrasena(psc.getDiasValidezContrasena());
			dto.setActivo(psc.isActivo());
			dto.setFechaValidezInicio(psc.getFechaValidezInicio());
			dto.setFechaValidezFin(psc.getFechaValidezFin());
			
			listDto.add(dto);
		}

		return listDto;
	}

}
