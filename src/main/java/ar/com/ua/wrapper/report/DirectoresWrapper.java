package ar.com.ua.wrapper.report;

import java.util.List;

import org.springframework.stereotype.Component;

import ar.com.ua.dto.report.DirectoresResponseDTO;

@Component
public class DirectoresWrapper {

	public DirectoresResponseDTO result(List<String> data) {
		DirectoresResponseDTO dto = new DirectoresResponseDTO();
		dto.setNumeroLegajo(data.get(0));
		dto.setApellidoNombre(data.get(1));
		dto.setFechaIngreso(data.get(2));
		dto.setFechaIngresoReconocida(data.get(3));
		dto.setEmailLaboral(data.get(4));
		dto.setPuesto(data.get(5));
		dto.setCategoria(data.get(6));
		dto.setManagerJefe(data.get(7));
		dto.setCargoManagerJefe(data.get(8));
		dto.setDireccion(data.get(9));
		dto.setGerencia(data.get(10));
		dto.setJefatura(data.get(11));
		dto.setDivision(data.get(12));
		dto.setCentroDeCostos(data.get(13));
		dto.setConvenio(data.get(14));
		return dto;
	}
}
