package ar.com.ua.service.report;

import java.util.List;
import java.util.Map;

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

	public List<DirectoresResponseDTO>generarReporte(Map<String, String> params) {
		
		DirectoresDTO dto = this.directoresBuilder.mapToDto(params);

		List<String> resultado = this.directoresRepository.reporte(dto.getIdPais(), dto.getIdLugarTrabajo(),
				dto.getIdCategoria(), dto.getIdManager(), dto.getIdCargoManager(), dto.getIdDireccion(),
				dto.getIdGerencia(), dto.getIdJefatura(), dto.getIdDivision(), dto.getIdCentroDeCostos(),
				dto.getIdConvenio());

		return this.directoresBuilder.listToDto(resultado);
	}

}
