package ar.com.ua.wrapper.report;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.ua.dto.report.LicenciasResponseDTO;
import ar.com.ua.model.Parametro;
import ar.com.ua.repository.report.ParametrosRepository;
import ar.com.ua.service.ParametroService;

@Component
public class LicenciasWrapper {

	@Autowired
	private ParametroService parametroService;

	private String descripcion(String id) {
		if (id != null) {
			Parametro param = parametroService.findById(Long.valueOf(id)).get();
			return param.getDescripcion();
		}
		return "";
	}

	public LicenciasResponseDTO result(List<String> data) {
		LicenciasResponseDTO dto = new LicenciasResponseDTO();
		dto.setNumeroLegajo(data.get(0));
		dto.setApellido(data.get(1));
		dto.setNombre(data.get(2));
		dto.setDescripcionLicencia(descripcion(data.get(3)));
		dto.setFechaInicio(data.get(4));
		dto.setFechaFin(data.get(5));
		dto.setEstado(data.get(6));
		dto.setPais(data.get(7));
		dto.setDireccion(descripcion(data.get(8)));
		dto.setGerencia(descripcion(data.get(9)));
		dto.setJefatura(descripcion(data.get(10)));
		dto.setPuesto(data.get(11));
		return dto;
	}

}
