package ar.com.ua.controller.report;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ua.constant.CodigoRespuestaConstant;
import ar.com.ua.constant.EndPointPathConstant;
import ar.com.ua.constant.TipoMetodoConstant;
import ar.com.ua.dto.report.GenericoDTO;
import ar.com.ua.dto.report.GenericoResponseDTO;
import ar.com.ua.dto.response.ResponseDto;
import ar.com.ua.dto.response.ResponseErrorDto;
import ar.com.ua.dto.response.ResponseOKListDto;
import ar.com.ua.service.report.GenericoService;

@RequestMapping("/reporte/generico")
@RestController
public class GenericoController implements IReport<GenericoDTO> {

	@Autowired
	private GenericoService service;

	@Override
	public ResponseDto generar(GenericoDTO dto) {
		try {
			List<GenericoResponseDTO> extDto = this.service.generar(dto);

			return new ResponseOKListDto<GenericoResponseDTO>(EndPointPathConstant.GENERICO, TipoMetodoConstant.POST,
					CodigoRespuestaConstant.OK, extDto);

		} catch (Exception e) {
			List<String> mensajesError = new ArrayList<String>();
			String messageException = e.getMessage();
			mensajesError.add(messageException);

			return new ResponseErrorDto(EndPointPathConstant.GENERICO, TipoMetodoConstant.POST,
					CodigoRespuestaConstant.ERROR, mensajesError);
		}
	}

}
