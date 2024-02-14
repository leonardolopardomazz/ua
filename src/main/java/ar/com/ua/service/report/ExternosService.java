package ar.com.ua.service.report;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.ua.builder.report.ExternosBuilder;
import ar.com.ua.dto.report.ExternosDTO;
import ar.com.ua.dto.report.ExternosResponseDTO;
import ar.com.ua.projection.report.ExternosProjection;
import ar.com.ua.repository.report.ExternosRepository;

@Component
public class ExternosService {

	@Autowired
	private ExternosBuilder builder;

	@Autowired
	private ExternosRepository extRepository;

	public List<ExternosResponseDTO> generar(ExternosDTO extDto) {

		List<ExternosProjection> resultado = this.extRepository.reporte(extDto.getActivo());

		return this.builder.listToDto(resultado);
	}

}
