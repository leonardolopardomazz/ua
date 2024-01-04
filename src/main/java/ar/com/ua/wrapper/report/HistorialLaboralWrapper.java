package ar.com.ua.wrapper.report;

import java.util.List;

import org.springframework.stereotype.Component;

import ar.com.ua.dto.report.HistorialLaboralResponseDTO;

@Component
public class HistorialLaboralWrapper {

	public HistorialLaboralResponseDTO result(List<String> data) {
		HistorialLaboralResponseDTO dto = new HistorialLaboralResponseDTO();
		dto.setNumeroLegajo(data.get(0));
		dto.setApellido(data.get(1));
		dto.setNombre(data.get(2));
		dto.setPuesto(data.get(3));
		dto.setFechaIngresoReconocida(data.get(4));
		dto.setFechaEgreso(data.get(5));
		return dto;
	}
}
