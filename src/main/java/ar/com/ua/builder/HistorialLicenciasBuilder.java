package ar.com.ua.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.com.ua.dto.HistorialLicenciasDTO;
import ar.com.ua.model.HistorialLicencias;

@Component
public class HistorialLicenciasBuilder implements IBuilder<HistorialLicencias, HistorialLicenciasDTO> {

	@Override
	public HistorialLicencias dtoToModel(HistorialLicenciasDTO dto) {
		HistorialLicencias hl = new HistorialLicencias();
		hl.setId(dto.getId());
		hl.setFechaInicio(dto.getFechaInicio());
		hl.setFechaFin(dto.getFechaFin());
		hl.setNumeroLegajo(dto.getNumeroLegajo());
		hl.setActivo(dto.isActivo());

		return hl;
	}

	@Override
	public HistorialLicenciasDTO modelToDto(HistorialLicencias model) {
		HistorialLicenciasDTO dto = new HistorialLicenciasDTO();
		dto.setId(model.getId());
		dto.setFechaInicio(model.getFechaInicio());
		dto.setFechaFin(model.getFechaFin());
		dto.setNumeroLegajo(model.getNumeroLegajo());
		dto.setActivo(model.isActivo());

		return dto;
	}

	@Override
	public List<HistorialLicenciasDTO> modelListToDto(List<HistorialLicencias> list) {

		List<HistorialLicenciasDTO> listDto = new ArrayList<>();

		for (HistorialLicencias hl : list) {
			HistorialLicenciasDTO dto = new HistorialLicenciasDTO();
			dto.setId(hl.getId());
			dto.setFechaInicio(hl.getFechaInicio());
			dto.setFechaFin(hl.getFechaFin());
			dto.setNumeroLegajo(hl.getNumeroLegajo());
			dto.setActivo(hl.isActivo());

			listDto.add(dto);
		}

		return listDto;
	}

}
