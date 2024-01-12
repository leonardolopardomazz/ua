package ar.com.ua.wrapper.report;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.ua.dto.report.LicenciasResponseDTO;
import ar.com.ua.repository.report.ParametrosRepository;

@Component
public class LicenciasWrapper {

	@Autowired
	private ParametrosRepository repository;

	public LicenciasResponseDTO result(List<String> data) {
		LicenciasResponseDTO dto = new LicenciasResponseDTO();
		dto.setNumeroLegajo(data.get(0));
		dto.setApellido(data.get(1));
		dto.setNombre(data.get(2));
		dto.setDescripcionLicencia(repository.descripcion(data.get(3)));
		dto.setFechaFin(data.get(4));
		dto.setFechaFin(data.get(5));
		dto.setEstado(data.get(6));
		dto.setPais(repository.descripcion(data.get(7)));
		dto.setDireccion(repository.descripcion(data.get(8)));
		dto.setGerencia(repository.descripcion(data.get(9)));
		dto.setJefatura(repository.descripcion(data.get(10)));
		dto.setDescripcionLicencia(data.get(11));
		return dto;
	}

}
