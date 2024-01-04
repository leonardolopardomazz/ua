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

	@Override
	public VueltaAlColegioDTO mapToDto(Map<String, String> map) {
		VueltaAlColegioDTO dto = new VueltaAlColegioDTO();

		dto.setPais(map.get("pais"));
		dto.setNumeroLegajo(map.get("numeroLegajo"));
		dto.setApellido(map.get("apellido"));

		String direccion = map.get("codigoDireccion");
		if (CommonsValidator.isNotNull(direccion)) {
			dto.setCodigoDireccion(Long.valueOf(direccion));
		}

		String codigoPuesto = map.get("codigoPuesto");
		if (CommonsValidator.isNotNull(codigoPuesto)) {
			dto.setCodigoDireccion(Long.valueOf(codigoPuesto));
		}

		String estadoEmpleado = map.get("estadoEmpleado");
		if (CommonsValidator.isNotNull(estadoEmpleado)) {
			dto.setEstadoEmpleado(Boolean.getBoolean(estadoEmpleado));
		}
		return dto;
	}

	@Override
	public List<VueltaAlColegioResponseDTO> listToDto(List<?> list) {

		List<VueltaAlColegioResponseDTO> listDto = new ArrayList<>();
		try {
			for (Object object : list) {
				List<String> parserResult = CommonsBuilder.arrayToList(object.toString().split(","));
				List<String> initialData = parserResult.subList(0, 3);

				int size = parserResult.size();
				List<String> dates = parserResult.subList(3, size);

				listDto.add(wrapper.result(initialData, dates));
			}
			return listDto;
		} catch (Exception e) {
			throw e;
		}
	}

}
