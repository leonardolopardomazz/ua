package ar.com.ua.controller.report;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ua.constant.CodigoRespuestaConstant;
import ar.com.ua.constant.EndPointPathConstant;
import ar.com.ua.constant.TipoMetodoConstant;
import ar.com.ua.dto.report.VueltaAlColegioDTO;
import ar.com.ua.dto.report.VueltaAlColegioResponseDTO;
import ar.com.ua.dto.response.ResponseDto;
import ar.com.ua.dto.response.ResponseErrorDto;
import ar.com.ua.dto.response.ResponseOKListDto;
import ar.com.ua.service.report.VueltaAlColegioService;

@RequestMapping("/reporte/vueltaalcolegio")
@RestController
public class VueltaAlColegioController implements IReport<VueltaAlColegioDTO> {

	@Autowired
	private VueltaAlColegioService reporteService;

	@Override
	public ResponseDto generar(@RequestBody VueltaAlColegioDTO dto) {

		try {
			List<VueltaAlColegioResponseDTO> vacDto = this.reporteService.generar(dto);

			return new ResponseOKListDto<VueltaAlColegioResponseDTO>(EndPointPathConstant.REPORTE_VUELTA_AL_COLEGIO,
					TipoMetodoConstant.GET, CodigoRespuestaConstant.OK, vacDto);

		} catch (Exception e) {
			List<String> mensajesError = new ArrayList<String>();
			String messageException = e.getMessage();
			mensajesError.add(messageException);

			return new ResponseErrorDto(EndPointPathConstant.REPORTE_VUELTA_AL_COLEGIO, TipoMetodoConstant.GET,
					CodigoRespuestaConstant.ERROR, mensajesError);
		}
	}

}
