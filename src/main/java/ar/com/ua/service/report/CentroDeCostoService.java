package ar.com.ua.service.report;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.ua.builder.report.CentroDeCostoBuilder;
import ar.com.ua.dto.report.CentroDeCostoDTO;
import ar.com.ua.dto.report.CentroDeCostoResponseDTO;
import ar.com.ua.projection.report.CentroDeCostoProjection;
import ar.com.ua.repository.report.CentroDeCostoRepository;

@Component
public class CentroDeCostoService {

	@Autowired
	private CentroDeCostoBuilder cdcBuilder;

	@Autowired
	private CentroDeCostoRepository cdcRepository;

	public List<CentroDeCostoResponseDTO> generar(CentroDeCostoDTO dto) {

		try {
			List<CentroDeCostoProjection> resultado = this.cdcRepository.reporte(dto.getIdCentroDeCosto(), dto.getEstado(),
					dto.getIdDireccion());

			return this.cdcBuilder.listToDto(resultado);
		} catch (Exception e) {
			throw e;
		}
	}

}
