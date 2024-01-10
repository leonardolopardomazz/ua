package ar.com.ua.wrapper.report;

import java.util.List;

import org.springframework.stereotype.Component;

import ar.com.ua.dto.report.ExternosResponseDTO;

@Component
public class ExternosWrapper {

	public ExternosResponseDTO result(List<String> data) {
		ExternosResponseDTO dto = new ExternosResponseDTO();
		dto.setNumeroLegajo(data.get(0));
		dto.setCodigoTipoDocumento(data.get(1));
		dto.setNumeroDocumento(data.get(2));
		dto.setCodigoPais(data.get(3));
		dto.setCodigoProveedor(data.get(4));
		dto.setCodigoPuesto(data.get(5));
		dto.setCodigoJefatura(data.get(6));
		dto.setCodigoDivision(data.get(7));
		dto.setApellidoNombre(data.get(8));
		dto.setManager(data.get(9));
		dto.setFechaEgreso(data.get(10));
		dto.setCodigoGenero(data.get(11));
		dto.setActivo(data.get(12));
		dto.setFechaEgreso(data.get(13));
		dto.setEmail(data.get(14));
		return dto;
	}
}
