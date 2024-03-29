package ar.com.ua.service.report;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.ua.builder.report.InternationalDataCollectionBuilder;
import ar.com.ua.dto.report.InternationalDataCollectionDTO;
import ar.com.ua.dto.report.InternationalDataCollectionResponseDTO;
import ar.com.ua.projection.report.InternationalDataCollectionProjection;
import ar.com.ua.repository.report.InternationalDataCollectionRepository;

@Component
public class InternationalDataCollectionService {

	@Autowired
	private InternationalDataCollectionBuilder builder;

	@Autowired
	private InternationalDataCollectionRepository repository;

	public List<InternationalDataCollectionResponseDTO> generar(InternationalDataCollectionDTO dto) {

		List<InternationalDataCollectionProjection> resultado = this.repository.reporte(dto.getFechaHasta());
		return this.builder.listToDto(resultado);
	}

}
