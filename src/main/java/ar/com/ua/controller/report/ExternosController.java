package ar.com.ua.controller.report;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ua.constant.CodigoRespuestaConstant;
import ar.com.ua.constant.EndPointPathConstant;
import ar.com.ua.constant.TipoMetodoConstant;
import ar.com.ua.dto.report.ExternosResponseDTO;
import ar.com.ua.dto.response.ResponseDto;
import ar.com.ua.dto.response.ResponseErrorDto;
import ar.com.ua.dto.response.ResponseOKListDto;
import ar.com.ua.service.report.ExternosService;

@RequestMapping("/reporte/externos")
@RestController
public class ExternosController implements IReport {
	
	@Autowired
	private ExternosService extService;

	@Override
	public ResponseDto generarReporte(Map<String, String> params) {

		try {
			List<ExternosResponseDTO> extDto = this.extService.generarReporte(params);

			return new ResponseOKListDto<ExternosResponseDTO>(EndPointPathConstant.EXTERNOS,
					TipoMetodoConstant.GET, CodigoRespuestaConstant.OK, extDto);

		} catch (Exception e) {
			List<String> mensajesError = new ArrayList<String>();
			String messageException = e.getMessage();
			mensajesError.add(messageException);

			return new ResponseErrorDto(EndPointPathConstant.EXTERNOS, TipoMetodoConstant.GET,
					CodigoRespuestaConstant.ERROR, mensajesError);
		}
	}
}
