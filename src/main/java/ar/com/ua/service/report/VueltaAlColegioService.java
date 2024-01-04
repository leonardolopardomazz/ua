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
		
		/*
		 * 		CentroDeCostoDTO cdcDto = this.cdcBuilder.mapToDto(params);

		List<String> resultado = this.cdcRepository.reporteCentroDeCosto(cdcDto);

		Integer idDireccion = Integer.getInteger(params.get("idDireccion"));
		String descripcionDireccion = paramRepository.descripcion(idDireccion);

		Integer idGerencia = Integer.getInteger(params.get("idGerencia"));
		String descripcionGerencia = paramRepository.descripcion(idGerencia);

		Integer idCentroDeCostos = Integer.getInteger(params.get("idcentrodecostos"));
		String descripcionCentroDeCostos = paramRepository.descripcion(idCentroDeCostos);

		return this.cdcBuilder.listToDTo(resultado);
		 */
		
		
		VueltaAlColegioDTO dto = vacBuilder.mapToDto(params);
		
		List<String> result = this.repository.reporteVueltaAlColegio(dto.getApellido(), dto.getNumeroLegajo(),
				dto.getCodigoPuesto(), dto.getCodigoDireccion());

		List<VueltaAlColegioResponseDTO> vacDto = vacBuilder.listToDto(result);
		return vacDto;
	}

}
