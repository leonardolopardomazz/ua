package ar.com.ua.service.report;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.ua.builder.report.VueltaAlColegioBuilder;
import ar.com.ua.dto.report.VueltaAlColegioDTO;
import ar.com.ua.dto.report.VueltaAlColegioResponseDTO;
import ar.com.ua.dto.response.ResponseDto;
import ar.com.ua.repository.report.VueltaAlColegioRepository;

@Component
public class VueltaAlColegioService {

	@Autowired
	private VueltaAlColegioRepository repository;

	@Autowired
	private VueltaAlColegioBuilder vacBuilder;

	public ResponseDto generateVueltaAlColegio(Map<String, String> params) {
		VueltaAlColegioDTO dto = vacBuilder.mapToDto(params);
		List result = this.repository.reportVueltaAlColegio(dto.getApellido(), dto.getNumeroLegajo(),
				dto.getCodigoPuesto(), dto.getCodigoDireccion());
		
		String strArr[];
		
//		for(int i = 0 ; i < result.size() ; i ++){  
//			   try {
//			      strArr[i] = result[i].toString();
//			   } catch (NullPointerException ex) {
//			       // do some default initialization
//			   }
//			}  

		VueltaAlColegioResponseDTO vacDto = vacBuilder.listToDTo(result);

		// ResponseDto responseDto = new

		return null;
	}

}
