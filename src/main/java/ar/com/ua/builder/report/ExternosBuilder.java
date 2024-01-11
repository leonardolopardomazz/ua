package ar.com.ua.builder.report;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.ua.dto.report.ExternosResponseDTO;
import ar.com.ua.wrapper.report.ExternosWrapper;

@Component
public class ExternosBuilder implements IBuilderResponse<List<?>, ExternosResponseDTO> {

	@Autowired
	private ExternosWrapper wrapper;

	@Override
	public List<ExternosResponseDTO> listToDto(List<?> list) {
		List<ExternosResponseDTO> listDto = new ArrayList<>();

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