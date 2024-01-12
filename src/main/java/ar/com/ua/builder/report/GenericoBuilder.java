package ar.com.ua.builder.report;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.ua.dto.report.GenericoResponseDTO;
import ar.com.ua.wrapper.report.GenericoWrapper;

@Component
public class GenericoBuilder implements IBuilderResponse<List<?>, GenericoResponseDTO> {
	
	@Autowired
	private GenericoWrapper wrapper;
	
	@Override
	public List<GenericoResponseDTO> listToDto(List<?> list) {

		List<GenericoResponseDTO> listDto = new ArrayList<>();

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
