package ar.com.ua.controller.report;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ua.constant.CodigoRespuestaConstant;
import ar.com.ua.constant.EndPointPathConstant;
import ar.com.ua.constant.TipoMetodoConstant;
import ar.com.ua.dto.report.ExternosDTO;
import ar.com.ua.dto.report.ExternosResponseDTO;
import ar.com.ua.dto.response.ResponseDto;
import ar.com.ua.dto.response.ResponseErrorDto;
import ar.com.ua.dto.response.ResponseOKListDto;
import ar.com.ua.service.report.ExternosService;

@RequestMapping("/reporte/externos")
@RestController
public class ExternosController implements IReport<ExternosDTO> {
	
	@Autowired
	private ExternosService extService;

	@Override
	public ResponseDto generar(ExternosDTO dto) {
		try {
			List<ExternosResponseDTO> extDto = this.extService.generar(dto);

			return new ResponseOKListDto<ExternosResponseDTO>(EndPointPathConstant.EXTERNOS, TipoMetodoConstant.POST,
					CodigoRespuestaConstant.OK, extDto);

		} catch (Exception e) {
			List<String> mensajesError = new ArrayList<String>();
			String messageException = e.getMessage();
			mensajesError.add(messageException);

			return new ResponseErrorDto(EndPointPathConstant.EXTERNOS, TipoMetodoConstant.POST,
					CodigoRespuestaConstant.ERROR, mensajesError);
		}
	}
}
