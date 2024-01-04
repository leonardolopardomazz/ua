package ar.com.ua.wrapper.report;

import java.util.List;

import org.springframework.stereotype.Component;

import ar.com.ua.dto.report.CentroDeCostoResponseDTO;

@Component
public class CentroDeCostosWrapper {

	public CentroDeCostoResponseDTO result(List<String> data) {
		CentroDeCostoResponseDTO dto = new CentroDeCostoResponseDTO();
		dto.setNumeroLegajo(data.get(0));
		dto.setApellido(data.get(1));
		dto.setNombre(data.get(2));
		dto.setIdDireccion(data.get(3));
		dto.setDireccion(data.get(4));		
		dto.setIdGerencia(data.get(5));
		dto.setGerencia(data.get(6));
		dto.setCodigoCentroDeCosto(data.get(7));
		dto.setDescripcionCentroDeCosto(data.get(8));
		dto.setFte(data.get(9));
		return dto;
	}

}
