package ar.com.ua.builder.report;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.ua.dto.report.CentroDeCostoResponseDTO;
import ar.com.ua.wrapper.report.CentroDeCostosWrapper;

@Component
public class CentroDeCostoBuilder implements IBuilderResponse<List<?>, CentroDeCostoResponseDTO> {

	@Autowired
	private CentroDeCostosWrapper wrapper;

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