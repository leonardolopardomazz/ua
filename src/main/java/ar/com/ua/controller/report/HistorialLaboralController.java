package ar.com.ua.controller.report;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ua.constant.CodigoRespuestaConstant;
import ar.com.ua.constant.EndPointPathConstant;
import ar.com.ua.constant.TipoMetodoConstant;
import ar.com.ua.dto.report.HistorialLaboralDTO;
import ar.com.ua.dto.report.HistorialLaboralResponseDTO;
import ar.com.ua.dto.response.ResponseDto;
import ar.com.ua.dto.response.ResponseErrorDto;
import ar.com.ua.dto.response.ResponseOKListDto;
import ar.com.ua.service.report.HistorialLaboralService;

@RequestMapping("/reporte/historiallaboral")
@RestController
public class HistorialLaboralController implements IReport<HistorialLaboralDTO> {

	@Autowired
	private HistorialLaboralService hlService;

	@Override
	public ResponseDto generar(HistorialLaboralDTO dto) {
		try {
			List<HistorialLaboralResponseDTO> hlDto = this.hlService.generar(dto);

			return new ResponseOKListDto<HistorialLaboralResponseDTO>(EndPointPathConstant.HISTORIAL_LABORAL,
					TipoMetodoConstant.GET, CodigoRespuestaConstant.OK, hlDto);

		} catch (Exception e) {
			List<String> mensajesError = new ArrayList<String>();
			String messageException = e.getMessage();
			mensajesError.add(messageException);

			return new ResponseErrorDto(EndPointPathConstant.HISTORIAL_LABORAL, TipoMetodoConstant.GET,
					CodigoRespuestaConstant.ERROR, mensajesError);
		}
	}
}
