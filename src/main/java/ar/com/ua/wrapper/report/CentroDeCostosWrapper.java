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
		dto.setDireccion(repository.descripcion(data.get(3)));
		dto.setIdGerencia(data.get(4));
		dto.setGerencia(repository.descripcion(data.get(4)));
		dto.setCodigoCentroDeCosto(repository.codigo(data.get(5)));
		dto.setDescripcionCentroDeCosto(repository.descripcion(data.get(5)));
		dto.setFte(repository.texto2(data.get(6)));
		return dto;
	}

}
