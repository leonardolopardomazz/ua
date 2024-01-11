package ar.com.ua.service.report;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.ua.builder.report.DirectoresBuilder;
import ar.com.ua.dto.report.DirectoresDTO;
import ar.com.ua.dto.report.DirectoresResponseDTO;
import ar.com.ua.repository.report.DirectoresRepository;

@Component
public class DirectoresService {

	@Autowired
	private DirectoresBuilder directoresBuilder;

	@Autowired
	private DirectoresRepository directoresRepository;

	public List<DirectoresResponseDTO> generar(DirectoresDTO dto) {

		List<String> resultado = this.directoresRepository.reporte(dto.getEstado(), dto.getIdDireccion(),
				dto.getIdGerencia());

		return this.directoresBuilder.listToDto(resultado);
	}

}
