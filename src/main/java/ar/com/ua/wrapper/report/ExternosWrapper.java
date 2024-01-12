package ar.com.ua.wrapper.report;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.ua.dto.report.ExternosResponseDTO;
import ar.com.ua.repository.report.ParametrosRepository;

@Component
public class ExternosWrapper {

	@Autowired
	private ParametrosRepository repository;

	public ExternosResponseDTO result(List<String> data) {
		ExternosResponseDTO dto = new ExternosResponseDTO();
		dto.setNumeroLegajo(data.get(0));
		dto.setCodigoTipoDocumento(data.get(1));
		dto.setNumeroDocumento(data.get(2));
		dto.setCodigoPais(repository.descripcion(data.get(3)));
		dto.setCodigoProveedor(repository.descripcion(data.get(4)));
		dto.setCodigoPuesto(repository.descripcion(data.get(5)));
		dto.setCodigoJefatura(repository.descripcion(data.get(6)));
		dto.setCodigoDivision(repository.descripcion(data.get(7)));
		dto.setApellidoNombre(data.get(8));
		dto.setManager(repository.descripcion(data.get(9)) + ", " + repository.descripcion(data.get(10)) + ", "
				+ repository.descripcion(data.get(11)));
		dto.setActivo(data.get(12));
		dto.setFechaIngreso(data.get(13));
		dto.setCodigoGenero(repository.descripcion(data.get(14)));
		dto.setFechaEgreso(data.get(15));
		dto.setEmail(data.get(16));
		return dto;
	}
}
