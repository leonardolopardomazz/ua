package ar.com.ua.commons;

import java.util.ArrayList;
import java.util.List;

import ar.com.ua.constant.CodigoRespuestaConstant;
import ar.com.ua.dto.response.ResponseErrorDto;

public class ManejoErrores {
	
	/**
	 * Devuelve un error generico
	 * @param endPoint
	 * @param tipoMetodo
	 * @param mensaje
	 * @return ResponseErrorDto
	 */
	public static ResponseErrorDto errorGenerico(String endPoint, String tipoMetodo, String mensaje) {
		List<String> mensajesError = new ArrayList<String>();
		String messageException = mensaje;
		mensajesError.add(messageException);
		return new ResponseErrorDto(endPoint, tipoMetodo, CodigoRespuestaConstant.ERROR,
				mensajesError);
	}

}
