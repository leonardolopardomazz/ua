package ar.com.ua.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ua.builder.UsuarioBuilder;
import ar.com.ua.constant.CodigoRespuestaConstant;
import ar.com.ua.constant.EndPointConstant;
import ar.com.ua.constant.EndPointPathConstant;
import ar.com.ua.constant.TipoMetodoConstant;
import ar.com.ua.dto.UsuarioDTO;
import ar.com.ua.dto.response.ResponseDto;
import ar.com.ua.dto.response.ResponseErrorDto;
import ar.com.ua.dto.response.ResponseOKDto;
import ar.com.ua.model.Usuario;
import ar.com.ua.service.UsuarioService;

@RequestMapping("/usuario")
@RestController
public class UsuarioController implements IABMController<UsuarioDTO> {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private UsuarioBuilder usuarioBuilder;

	static Logger logger = Logger.getLogger(UsuarioController.class.getName());

	private ResponseDto save(UsuarioDTO dto, String tipoMetodoConstant) {
		List<String> mensajesError = new ArrayList<String>();

		try {
			Usuario usuario = usuarioBuilder.dtoToModel(dto);
			Usuario usuarioGuardado = usuarioService.save(usuario);
			UsuarioDTO usuarioDto = usuarioBuilder.modelToDto(usuarioGuardado);
			return new ResponseOKDto<UsuarioDTO>(EndPointPathConstant.USUARIO, tipoMetodoConstant,
					CodigoRespuestaConstant.OK, usuarioDto);
		} catch (Exception e) {
			String messageException = e.getMessage();
			mensajesError.add(messageException);

			return new ResponseErrorDto(EndPointPathConstant.USUARIO, tipoMetodoConstant,
					CodigoRespuestaConstant.ERROR, mensajesError);
		}
	}

	/**
	 * Inserta una carga de familia a la tabla
	 * 
	 * @return ResponseDto
	 */
	@Override
	public ResponseDto add(UsuarioDTO dto) {
		return this.save(dto, TipoMetodoConstant.POST);
	}

	/**
	 * Actualiza una carga de familia en la tabla
	 */
	@Override
	public ResponseDto modify(UsuarioDTO dto) {
		return this.save(dto, TipoMetodoConstant.PUT);
	}

	/**
	 * Elimina una carga de familia de la tabla
	 */
	@Override
	public ResponseDto deleteById(UsuarioDTO dto) {
		List<String> mensajesError = new ArrayList<String>();

		try {
			Usuario usuario = usuarioBuilder.dtoToModel(dto);
			usuarioService.delete(usuario);

			return new ResponseOKDto<UsuarioDTO>(EndPointConstant.DELETE, TipoMetodoConstant.DELETE,
					CodigoRespuestaConstant.OK, dto);
		} catch (Exception e) {
			String messageException = e.getMessage();
			mensajesError.add(messageException);
			return new ResponseErrorDto(EndPointConstant.DELETE, TipoMetodoConstant.DELETE,
					CodigoRespuestaConstant.ERROR, mensajesError);
		}
	}

}
