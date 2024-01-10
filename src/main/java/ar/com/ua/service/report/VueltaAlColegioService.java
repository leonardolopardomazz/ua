package ar.com.ua.service.report;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.ua.builder.report.VueltaAlColegioBuilder;
import ar.com.ua.dto.report.VueltaAlColegioDTO;
import ar.com.ua.dto.report.VueltaAlColegioResponseDTO;
import ar.com.ua.repository.report.VueltaAlColegioRepository;

@Component
public class VueltaAlColegioService {

	@Autowired
	private VueltaAlColegioRepository repository;

	@Autowired
	private VueltaAlColegioBuilder vacBuilder;

	public List<VueltaAlColegioResponseDTO> generarReporte(Map<String, String> params) {
		
		VueltaAlColegioDTO dto = vacBuilder.mapToDto(params);
		
		List<String> result = this.repository.reporte(dto.getPais());

		List<VueltaAlColegioResponseDTO> vacDto = vacBuilder.listToDto(result);
		return vacDto;
	}

}
