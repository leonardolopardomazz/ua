package ar.com.ua.wrapper.report;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.ua.dto.report.CentroDeCostoResponseDTO;
import ar.com.ua.model.Parametro;
import ar.com.ua.repository.report.ParametrosRepository;

@Component
public class CentroDeCostosWrapper {

	@Autowired
	private ParametrosRepository parametroRepository;

	private String descripcion(String id) {
		Parametro param = parametroRepository.getParametro(id);
		if (param != null) {
			return param.getDescripcion();
		} else {
			return "";
		}
	}

	private String codigo(String id) {
		Parametro param = parametroRepository.getParametro(id);
		if (param != null) {
			return param.getCodigo();
		} else {
			return "";
		}
	}

	private String texto2(String id) {
		Parametro param = parametroRepository.getParametro(id);
		if (param != null) {
			return param.getTexto2();
		} else {
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
