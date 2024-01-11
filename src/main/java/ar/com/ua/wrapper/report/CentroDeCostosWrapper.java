package ar.com.ua.wrapper.report;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.ua.dto.report.CentroDeCostoResponseDTO;
import ar.com.ua.repository.report.ParametrosRepository;

@Component
public class CentroDeCostosWrapper {
	
	@Autowired
	private ParametrosRepository repository;

	public CentroDeCostoResponseDTO result(List<String> data) {
		CentroDeCostoResponseDTO dto = new CentroDeCostoResponseDTO();
		dto.setNumeroLegajo(data.get(0));
		dto.setApellido(data.get(1));
		dto.setNombre(data.get(2));
		dto.setIdDireccion(data.get(3));
		dto.setDireccion(data.get(4));		
		dto.setIdGerencia(data.get(5));
		dto.setGerencia(repository.descripcion(data.get(5)));
		dto.setCodigoCentroDeCosto(data.get(6));
		dto.setDescripcionCentroDeCosto(data.get(7));
		dto.setFte(data.get(8));
		return dto;
	}

}
