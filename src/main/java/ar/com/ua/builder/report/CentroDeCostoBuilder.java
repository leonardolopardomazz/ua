package ar.com.ua.builder.report;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.ua.dto.report.CentroDeCostoDTO;
import ar.com.ua.dto.report.CentroDeCostoResponseDTO;
import ar.com.ua.wrapper.report.CentroDeCostosWrapper;

@Component
public class CentroDeCostoBuilder implements IBuilder<Map<String, String>, CentroDeCostoDTO>,
		IBuilderResponse<List<?>, CentroDeCostoResponseDTO> {

	@Autowired
	private CentroDeCostosWrapper wrapper;

	@Override
	public CentroDeCostoDTO mapToDto(Map<String, String> map) {
		CentroDeCostoDTO dto = new CentroDeCostoDTO();

		dto.setEstado(map.get("estado"));

		String idCentroDeCosto = map.get("idCentroDeCosto");
		if (CommonsValidator.isNotNull(idCentroDeCosto)) {
			dto.setIdCentroDeCosto(idCentroDeCosto);
		}

		String idDireccion = map.get("idDireccion");
		if (CommonsValidator.isNotNull(idDireccion)) {
			dto.setIdDireccion(idDireccion);
		}
		
		String idGerencia = map.get("idGerencia");
		if (CommonsValidator.isNotNull(idGerencia)) {
			dto.setIdGerencia(idGerencia);
		}

		return dto;
	}

	@Override
	public List<CentroDeCostoResponseDTO> listToDto(List<?> list) {

		List<CentroDeCostoResponseDTO> listDto = new ArrayList<>();
		
		try {
			for (Object object : list) {
				List<String> parseResult = CommonsBuilder.arrayToList(object.toString().split(","));

				listDto.add(wrapper.result(parseResult));
			}
		} catch (Exception e) {
			throw e;
		}

		return listDto;
	}      

}