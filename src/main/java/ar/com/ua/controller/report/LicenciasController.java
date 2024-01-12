package ar.com.ua.controller.report;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ua.constant.CodigoRespuestaConstant;
import ar.com.ua.constant.EndPointPathConstant;
import ar.com.ua.constant.TipoMetodoConstant;
import ar.com.ua.dto.report.LicenciasDTO;
import ar.com.ua.dto.report.LicenciasResponseDTO;
import ar.com.ua.dto.response.ResponseDto;
import ar.com.ua.dto.response.ResponseErrorDto;
import ar.com.ua.dto.response.ResponseOKListDto;
import ar.com.ua.service.report.LicenciasService;

@RequestMapping("/reporte/licencias")
@RestController
public class LicenciasController implements IReport <LicenciasDTO> {
	
	@Autowired
	private LicenciasService service;

	@Override
	public ResponseDto generar(LicenciasDTO dto) {
		try {
			List<LicenciasResponseDTO> licenciasDto = this.service.generar(dto);

			return new ResponseOKListDto<LicenciasResponseDTO>(EndPointPathConstant.LICENCIAS,
					TipoMetodoConstant.POST, CodigoRespuestaConstant.OK, licenciasDto);

		} catch (Exception e) {
			List<String> mensajesError = new ArrayList<String>();
			String messageException = e.getMessage();
			mensajesError.add(messageException);

			return new ResponseErrorDto(EndPointPathConstant.LICENCIAS, TipoMetodoConstant.POST,
					CodigoRespuestaConstant.ERROR, mensajesError);
		}
	}
}
