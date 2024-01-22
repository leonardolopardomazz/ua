package ar.com.ua.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ua.builder.HistoricoContrasenaBuilder;
import ar.com.ua.constant.CodigoRespuestaConstant;
import ar.com.ua.constant.EndPointConstant;
import ar.com.ua.constant.EndPointPathConstant;
import ar.com.ua.constant.TipoMetodoConstant;
import ar.com.ua.dto.HistoricoContrasenaDTO;
import ar.com.ua.dto.response.ResponseDto;
import ar.com.ua.dto.response.ResponseErrorDto;
import ar.com.ua.dto.response.ResponseOKDto;
import ar.com.ua.dto.response.ResponseOKListDto;
import ar.com.ua.model.HistoricoContrasena;
import ar.com.ua.service.HistoricoContrasenaService;

@RequestMapping("/historicocontrasena")
@RestController
public class HistoricoContrasenaController
		implements IABMController<HistoricoContrasenaDTO>, IListController<HistoricoContrasenaDTO> {

	@Autowired
	private HistoricoContrasenaService hcService;

	@Autowired
	private HistoricoContrasenaBuilder hcBuilder;

	@Override
	public ResponseDto add(HistoricoContrasenaDTO dto) {

		try {
			HistoricoContrasena hc = hcBuilder.dtoToModel(dto);
			HistoricoContrasena HistoricoContrasenaDTOGuardado = hcService.save(hc);
			HistoricoContrasenaDTO hcDTO = hcBuilder.modelToDto(HistoricoContrasenaDTOGuardado);
			return new ResponseOKDto<HistoricoContrasenaDTO>(EndPointPathConstant.HISTORICO_CONTRASENA,
					TipoMetodoConstant.POST, CodigoRespuestaConstant.OK, hcDTO);
		} catch (Exception e) {
			List<String> mensajesError = new ArrayList<String>();
			String messageException = e.getMessage();
			mensajesError.add(messageException);

			return new ResponseErrorDto(EndPointPathConstant.HISTORICO_CONTRASENA, TipoMetodoConstant.POST,
					CodigoRespuestaConstant.ERROR, mensajesError);
		}
	}

	@Override
	public ResponseDto modify(Long id, HistoricoContrasenaDTO dto) {
		new NotImplementedException();
		return null;
	}

	@Override
	public ResponseDto deleteById(Long id) {
		new NotImplementedException();
		return null;
	}

	@Override
	public ResponseDto findOne(Long id) {
		new NotImplementedException();
		return null;
	}

	@Override
	public ResponseDto findAny(Map<String, String> params) {
		new NotImplementedException();
		return null;
	}

	@Override
	public ResponseDto findAll() {
		try {
			// List
			List<HistoricoContrasena> hc = (ArrayList<HistoricoContrasena>) hcService.findAll();

			// Build Model List to Dto List
			List<HistoricoContrasenaDTO> hcDTO = hcBuilder.modelListToDto(hc);

			// return
			return new ResponseOKListDto<HistoricoContrasenaDTO>(EndPointConstant.FIND_ALL, TipoMetodoConstant.GET,
					CodigoRespuestaConstant.OK, hcDTO);

		} catch (Exception e) {
			String messageException = e.getMessage();
			List<String> mensajes = new ArrayList<>();
			mensajes.add(messageException);
			return new ResponseErrorDto(EndPointConstant.FIND_ALL, TipoMetodoConstant.GET,
					CodigoRespuestaConstant.ERROR, mensajes);
		}
	}

}
