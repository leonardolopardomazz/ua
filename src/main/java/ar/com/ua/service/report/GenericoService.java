package ar.com.ua.service.report;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.ua.builder.report.GenericoBuilder;
import ar.com.ua.dto.report.GenericoDTO;
import ar.com.ua.dto.report.GenericoResponseDTO;
import ar.com.ua.projection.report.GenericoProjection;
import ar.com.ua.repository.report.GenericoRepository;

@Component
public class GenericoService {
	
	@Autowired
	private GenericoBuilder builder;

	@Autowired
	private GenericoRepository repository;

	public List<GenericoResponseDTO> generar(GenericoDTO dto) {

		List<GenericoProjection> resultado = this.repository.reporte(dto.getEstadoEmpleado(), dto.getIdDireccion(), dto.getIdGerencia());

		return this.builder.listToDto(resultado);
	}

}
