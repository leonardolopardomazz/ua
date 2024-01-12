package ar.com.ua.builder.report;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.ua.dto.report.LicenciasResponseDTO;
import ar.com.ua.wrapper.report.LicenciasWrapper;

@Component
public class LicenciasBuilder implements IBuilderResponse<List<?>, LicenciasResponseDTO>  {
	
	@Autowired
	private LicenciasWrapper wrapper;

	@Override
	public List<LicenciasResponseDTO> listToDto(List<?> list) {
		List<LicenciasResponseDTO> listDto = new ArrayList<>();
		
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
