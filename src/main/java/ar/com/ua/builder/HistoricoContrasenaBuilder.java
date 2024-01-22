package ar.com.ua.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.com.ua.dto.HistoricoContrasenaDTO;
import ar.com.ua.model.HistoricoContrasena;

@Component
public class HistoricoContrasenaBuilder implements IBuilder<HistoricoContrasena, HistoricoContrasenaDTO> {

	@Override
	public HistoricoContrasena dtoToModel(HistoricoContrasenaDTO dto) {
		HistoricoContrasena hc = new HistoricoContrasena();
		hc.setId(dto.getId());
		hc.setUsuario(dto.getUsuario());
		hc.setContrasena(dto.getContrasena());
		hc.setFechaCambioContrasena(dto.getFechaCambioContrasena());
		return hc;
	}

	@Override
	public HistoricoContrasenaDTO modelToDto(HistoricoContrasena model) {
		HistoricoContrasenaDTO dto = new HistoricoContrasenaDTO();
		dto.setId(model.getId());
		dto.setUsuario(model.getUsuario());
		dto.setContrasena(model.getContrasena());
		dto.setFechaCambioContrasena(model.getFechaCambioContrasena());
		return dto;
	}

	@Override
	public List<HistoricoContrasenaDTO> modelListToDto(List<HistoricoContrasena> list) {

		List<HistoricoContrasenaDTO> listDto = new ArrayList<>();

		for (HistoricoContrasena hc : list) {
			HistoricoContrasenaDTO dto = new HistoricoContrasenaDTO();
			dto.setId(hc.getId());
			dto.setUsuario(hc.getUsuario());
			dto.setContrasena(hc.getContrasena());
			dto.setFechaCambioContrasena(hc.getFechaCambioContrasena());
			listDto.add(dto);
		}

		return listDto;
	}

}
