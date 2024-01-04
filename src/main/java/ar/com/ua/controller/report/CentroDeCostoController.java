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
import ar.com.ua.dto.report.CentroDeCostoResponseDTO;
import ar.com.ua.dto.response.ResponseDto;
import ar.com.ua.dto.response.ResponseErrorDto;
import ar.com.ua.dto.response.ResponseOKListDto;
import ar.com.ua.service.report.CentroDeCostoService;

@RequestMapping("/reporte/centrodecosto")
@RestController
public class CentroDeCostoController implements IReport {
	
	@Autowired
	private CentroDeCostoService cdcService;

	@Override
	public ResponseDto generarReporte(Map<String, String> params) {

		try {
			List<CentroDeCostoResponseDTO> cdcDto = this.cdcService.generarReporte(params);

			return new ResponseOKListDto<CentroDeCostoResponseDTO>(EndPointPathConstant.REPORTE_CENTRO_DE_COSTO,
					TipoMetodoConstant.GET, CodigoRespuestaConstant.OK, cdcDto);

		} catch (Exception e) {
			List<String> mensajesError = new ArrayList<String>();
			String messageException = e.getMessage();
			mensajesError.add(messageException);

			return new ResponseErrorDto(EndPointPathConstant.REPORTE_CENTRO_DE_COSTO, TipoMetodoConstant.GET,
					CodigoRespuestaConstant.ERROR, mensajesError);
		}
	}
}
