package ar.com.ua.wrapper.report;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.ua.dto.report.HistorialLaboralResponseDTO;
import ar.com.ua.repository.report.ParametrosRepository;

@Component
public class HistorialLaboralWrapper {

	@Autowired
	private ParametrosRepository repository;

	public HistorialLaboralResponseDTO result(List<String> data) {
		HistorialLaboralResponseDTO dto = new HistorialLaboralResponseDTO();
		dto.setNumeroLegajo(data.get(0));
		dto.setApellido(data.get(1));
		dto.setNombre(data.get(2));
		dto.setPuesto(data.get(3));
		dto.setFechaIngreso(data.get(4));
		dto.setFechaEgreso(data.get(5));
		dto.setDireccion(repository.descripcion(data.get(6)));
		return dto;
	}
}
