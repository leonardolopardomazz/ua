package ar.com.ua.wrapper.report;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.ua.dto.report.DirectoresResponseDTO;
import ar.com.ua.repository.report.ParametrosRepository;

@Component
public class DirectoresWrapper {
	
	@Autowired
	private ParametrosRepository repository;

	public DirectoresResponseDTO result(List<String> data) {
		DirectoresResponseDTO dto = new DirectoresResponseDTO();
		dto.setNumeroLegajo(data.get(0));
		dto.setApellidoNombre(data.get(1));
		dto.setFechaIngreso(data.get(2));
		dto.setFechaIngresoReconocida(data.get(3));
		dto.setDescripcionPais(repository.descripcion(data.get(4)));
		dto.setEmailLaboral(data.get(5));
		dto.setDescripcionPuesto(repository.descripcion(data.get(6)));
		dto.setDescripcionCategoria(repository.descripcion(data.get(7)));
		dto.setDescripcionManagerJefe(repository.descripcion(data.get(8)));
		dto.setDescripcionDireccion(repository.descripcion(data.get(9)));
		dto.setDescripcionDireccion(repository.descripcion(data.get(10)));
		dto.setDescripcionJefatura(repository.descripcion(data.get(11)));
		dto.setDescripcionDivision(data.get(12));
		dto.setDescripcionCentroDeCostos(repository.descripcion(data.get(13)));
		dto.setDescripcionConvenio(repository.descripcion(data.get(14)));
		return dto;
	}
}
