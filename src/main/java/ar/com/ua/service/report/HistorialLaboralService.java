package ar.com.ua.service.report;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.ua.builder.report.HistorialLaboralBuilder;
import ar.com.ua.dto.report.HistorialLaboralDTO;
import ar.com.ua.dto.report.HistorialLaboralResponseDTO;
import ar.com.ua.repository.report.HistorialLaboralRepository;

@Component
public class HistorialLaboralService {

	@Autowired
	private HistorialLaboralBuilder hlBuilder;

	@Autowired
	private HistorialLaboralRepository hlRepository;

	public List<HistorialLaboralResponseDTO> generar(HistorialLaboralDTO hlDto) {

		List<String> resultado = this.hlRepository.reporte(hlDto.getPais(), hlDto.getIdDireccion(), hlDto.getEstado(),
				hlDto.getFechaIngresoDesde(), hlDto.getFechaIngresoHasta());

		return this.hlBuilder.listToDto(resultado);
	}

}
