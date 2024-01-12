package ar.com.ua.controller.report;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ua.constant.CodigoRespuestaConstant;
import ar.com.ua.constant.EndPointPathConstant;
import ar.com.ua.constant.TipoMetodoConstant;
import ar.com.ua.dto.report.CentroDeCostoDTO;
import ar.com.ua.dto.report.CentroDeCostoResponseDTO;
import ar.com.ua.dto.response.ResponseDto;
import ar.com.ua.dto.response.ResponseErrorDto;
import ar.com.ua.dto.response.ResponseOKListDto;
import ar.com.ua.service.report.CentroDeCostoService;

@RequestMapping("/reporte/centrodecosto")
@RestController
public class CentroDeCostoController implements IReport <CentroDeCostoDTO> {
	
	@Autowired
	private CentroDeCostoService cdcService;

	@Override
	public ResponseDto generar(CentroDeCostoDTO dto) {
		try {
			List<CentroDeCostoResponseDTO> cdcDto = this.cdcService.generar(dto);

			return new ResponseOKListDto<CentroDeCostoResponseDTO>(EndPointPathConstant.REPORTE_CENTRO_DE_COSTO,
					TipoMetodoConstant.POST, CodigoRespuestaConstant.OK, cdcDto);

		} catch (Exception e) {
			List<String> mensajesError = new ArrayList<String>();
			String messageException = e.getMessage();
			mensajesError.add(messageException);

			return new ResponseErrorDto(EndPointPathConstant.REPORTE_CENTRO_DE_COSTO, TipoMetodoConstant.POST,
					CodigoRespuestaConstant.ERROR, mensajesError);
		}
	}
}
