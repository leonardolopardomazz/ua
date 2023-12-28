package ar.com.ua.builder.report;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.ua.dto.report.VueltaAlColegioDTO;
import ar.com.ua.dto.report.VueltaAlColegioResponseDTO;
import ar.com.ua.wrapper.report.VueltaAlColegioWrapper;

@Component
public class VueltaAlColegioBuilder implements IBuilder<Map<String, String>, VueltaAlColegioDTO>,
		IBuilderResponse<List<?>, VueltaAlColegioResponseDTO> {

	@Autowired
	private VueltaAlColegioWrapper wrapper;

	private List<String> arrayToList(String[] queryResult) {
		List<String> parserResult = new ArrayList<>();
		for (String result : queryResult) {
			parserResult.add(result);
		}
		return parserResult;
	}

	private boolean isNotNull(String field) {
		if (field != null) {
			return true;
		}
		return false;
	}

	@Override
	public VueltaAlColegioDTO mapToDto(Map<String, String> map) {
		VueltaAlColegioDTO dto = new VueltaAlColegioDTO();

		dto.setPais(map.get("pais"));
		dto.setNumeroLegajo(map.get("numeroLegajo"));
		dto.setApellido(map.get("apellido"));

		String direccion = map.get("codigoDireccion");
		if (isNotNull(direccion)) {
			dto.setCodigoDireccion(Long.valueOf(direccion));
		}

		String codigoPuesto = map.get("codigoPuesto");
		if (isNotNull(codigoPuesto)) {
			dto.setCodigoDireccion(Long.valueOf(codigoPuesto));
		}

		String estadoEmpleado = map.get("estadoEmpleado");
		if (isNotNull(estadoEmpleado)) {
			dto.setEstadoEmpleado(Boolean.getBoolean(estadoEmpleado));
		}
		return dto;
	}

	@Override
	public VueltaAlColegioResponseDTO listToDTo(List<?> list) {
		VueltaAlColegioResponseDTO dto = new VueltaAlColegioResponseDTO();

		try {
			String[] queryResult = list.get(0).toString().split(",");
			List<String> parserResult = arrayToList(queryResult);
			List<String> initialData = parserResult.subList(0, 3);

			int size = parserResult.size();
			List<String> dates = parserResult.subList(3, size);

			dto = wrapper.result(initialData, dates);

			return dto;
		} catch (Exception e) {
			throw e;
		} 
	}

}
