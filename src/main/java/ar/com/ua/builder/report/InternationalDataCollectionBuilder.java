package ar.com.ua.builder.report;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.ua.dto.report.InternationalDataCollectionResponseDTO;
import ar.com.ua.wrapper.report.InternationalDataCollectionWrapper;

@Component
public class InternationalDataCollectionBuilder implements IBuilderResponse<List<?>, InternationalDataCollectionResponseDTO>  {
	
	@Autowired
	private InternationalDataCollectionWrapper wrapper;

	@Override
	public List<InternationalDataCollectionResponseDTO> listToDto(List<?> list) {
		
		List<InternationalDataCollectionResponseDTO> listDto = new ArrayList<>();
		
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
