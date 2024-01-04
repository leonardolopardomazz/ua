package ar.com.ua.builder.report;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.ua.dto.report.HistorialLaboralDTO;
import ar.com.ua.dto.report.HistorialLaboralResponseDTO;
import ar.com.ua.wrapper.report.HistorialLaboralWrapper;

@Component
public class HistorialLaboralBuilder implements IBuilder<Map<String, String>, HistorialLaboralDTO>,
		IBuilderResponse<List<?>, HistorialLaboralResponseDTO> {

	@Autowired
	private HistorialLaboralWrapper wrapper;

	@Override
	public List<HistorialLaboralResponseDTO> listToDto(List<?> list) {

		List<HistorialLaboralResponseDTO> listDto = new ArrayList<>();

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

	@Override
	public HistorialLaboralDTO mapToDto(Map<String, String> map) {

		HistorialLaboralDTO dto = new HistorialLaboralDTO();

		String idPais = map.get("idPais");
		if (CommonsValidator.isNotNull(idPais)) {
			dto.setIdPais(idPais);
		}

		String idDireccion = map.get("idDireccion");
		if (CommonsValidator.isNotNull(idDireccion)) {
			dto.setIdDireccion(idDireccion);
		}

		dto.setEstado(map.get("estado"));

		String fechaIngresoDesde = map.get("fechaIngresoDesde");
		if (CommonsValidator.isNotNull(fechaIngresoDesde)) {
			dto.setFechaIngresoDesde(fechaIngresoDesde);
		}

		String fechaIngresoHasta = map.get("fechaIngresoHasta");
		if (CommonsValidator.isNotNull(fechaIngresoHasta)) {
			dto.setFechaIngresoHasta(fechaIngresoHasta);
		}

		return dto;
	}

}
