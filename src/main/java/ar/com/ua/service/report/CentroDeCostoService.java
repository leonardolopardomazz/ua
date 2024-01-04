package ar.com.ua.service.report;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.ua.builder.report.CentroDeCostoBuilder;
import ar.com.ua.dto.report.CentroDeCostoDTO;
import ar.com.ua.dto.report.CentroDeCostoResponseDTO;
import ar.com.ua.repository.report.CentroDeCostoRepository;

@Component
public class CentroDeCostoService {

	@Autowired
	private CentroDeCostoBuilder cdcBuilder;

	@Autowired
	private CentroDeCostoRepository cdcRepository;

	public List<CentroDeCostoResponseDTO>generarReporte(Map<String, String> params) {

		CentroDeCostoDTO cdcDto = this.cdcBuilder.mapToDto(params);

		List<String> resultado = this.cdcRepository.reporteCentroDeCosto(cdcDto.getIdCentroDeCosto(),
				cdcDto.getEstado(), cdcDto.getIdDireccion(), cdcDto.getIdGerencia());

		return this.cdcBuilder.listToDto(resultado);
	}

}
