package ar.com.ua.wrapper.report;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.ua.dto.report.HistorialLaboralResponseDTO;
import ar.com.ua.model.Parametro;
import ar.com.ua.repository.report.ParametrosRepository;

@Component
public class HistorialLaboralWrapper {

	@Autowired
	private ParametrosRepository parametroRepository;

	private String descripcion(String id) {
		Parametro param = parametroRepository.getParametro(id);
		if (param != null) {
			return param.getDescripcion();
		} else {
			return "";
		}
	}

	public HistorialLaboralResponseDTO result(List<String> data) {
		HistorialLaboralResponseDTO dto = new HistorialLaboralResponseDTO();
		dto.setNumeroLegajo(data.get(0));
		dto.setApellido(data.get(1));
		dto.setNombre(data.get(2));
		dto.setPuesto(data.get(3));
		dto.setFechaInicioPuesto(data.get(4));
		dto.setFechaFinPuesto(data.get(5));
		dto.setDireccion(descripcion(data.get(6)));
		return dto;
	}
}
