package ar.com.ua.wrapper.report;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.ua.dto.report.CentroDeCostoResponseDTO;
import ar.com.ua.model.Parametro;
import ar.com.ua.service.ParametroService;

@Component
public class CentroDeCostosWrapper {

	@Autowired
	private ParametroService parametroService;

	private String descripcion(String id) {
		try {
			Parametro param = parametroService.findById(Long.valueOf(id)).get();
			return param.getDescripcion();
		} catch (NumberFormatException e) {
			return "";
		}
	}

	private String codigo(String id) {
		try {
			Parametro param = parametroService.findById(Long.valueOf(id)).get();
			return param.getTexto1();
		} catch (NumberFormatException e) {
			return "";
		}
	}

	private String texto2(String id) {
		try {
			Parametro param = parametroService.findById(Long.valueOf(id)).get();
			return param.getTexto2();
		} catch (NumberFormatException e) {
			return "";
		}
	}

	public CentroDeCostoResponseDTO result(List<String> data) {
		CentroDeCostoResponseDTO dto = new CentroDeCostoResponseDTO();
		dto.setNumeroLegajo(data.get(0));
		dto.setApellido(data.get(1));
		dto.setNombre(data.get(2));
		dto.setIdDireccion(data.get(3));
		dto.setDireccion(descripcion(data.get(3)));
		dto.setIdGerencia(data.get(4));
		dto.setGerencia(descripcion(data.get(4)));
		dto.setCodigoCentroDeCosto(codigo(data.get(5)));
		dto.setDescripcionCentroDeCosto(descripcion(data.get(5)));
		dto.setFte(texto2(data.get(6)));
		return dto;
	}

}
