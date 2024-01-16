package ar.com.ua.controller.report;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ua.constant.CodigoRespuestaConstant;
import ar.com.ua.constant.EndPointPathConstant;
import ar.com.ua.constant.TipoMetodoConstant;
import ar.com.ua.dto.report.InternationalDataCollectionDTO;
import ar.com.ua.dto.report.InternationalDataCollectionResponseDTO;
import ar.com.ua.dto.response.ResponseDto;
import ar.com.ua.dto.response.ResponseErrorDto;
import ar.com.ua.dto.response.ResponseOKListDto;
import ar.com.ua.service.report.InternationalDataCollectionService;

@RequestMapping("/reporte/idc")
@RestController
public class InternationalDataCollectionController implements IReport<InternationalDataCollectionDTO> {

	@Autowired
	private InternationalDataCollectionService service;

	@Override
	public ResponseDto generar(InternationalDataCollectionDTO dto) {
		try {
			List<InternationalDataCollectionResponseDTO> idcDto = this.service.generar(dto);

			return new ResponseOKListDto<InternationalDataCollectionResponseDTO>(
					EndPointPathConstant.INTERNATION_DATA_COLLECTION, TipoMetodoConstant.POST,
					CodigoRespuestaConstant.OK, idcDto);

		} catch (Exception e) {
			List<String> mensajesError = new ArrayList<String>();
			String messageException = e.getMessage();
			mensajesError.add(messageException);

			return new ResponseErrorDto(EndPointPathConstant.INTERNATION_DATA_COLLECTION, TipoMetodoConstant.POST,
					CodigoRespuestaConstant.ERROR, mensajesError);
		}
	}

}
