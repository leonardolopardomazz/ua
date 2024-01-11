package ar.com.ua.builder.report;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.ua.dto.report.DirectoresResponseDTO;
import ar.com.ua.wrapper.report.DirectoresWrapper;

@Component
public class DirectoresBuilder
		implements IBuilderResponse<List<?>, DirectoresResponseDTO> {

	@Autowired
	private DirectoresWrapper wrapper;

	@Override
	public List<DirectoresResponseDTO> listToDto(List<?> list) {
		List<DirectoresResponseDTO> listDto = new ArrayList<>();

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
