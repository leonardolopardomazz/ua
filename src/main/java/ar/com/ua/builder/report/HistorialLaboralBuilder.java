package ar.com.ua.builder.report;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.ua.dto.report.HistorialLaboralResponseDTO;
import ar.com.ua.wrapper.report.HistorialLaboralWrapper;

@Component
public class HistorialLaboralBuilder implements IBuilderResponse<List<?>, HistorialLaboralResponseDTO> {

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

}
