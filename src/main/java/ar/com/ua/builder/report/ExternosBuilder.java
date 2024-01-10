package ar.com.ua.builder.report;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.ua.dto.report.ExternosDTO;
import ar.com.ua.dto.report.ExternosResponseDTO;
import ar.com.ua.wrapper.report.ExternosWrapper;

@Component
public class ExternosBuilder
		implements IBuilder<Map<String, String>, ExternosDTO>, IBuilderResponse<List<?>, ExternosResponseDTO> {

	@Autowired
	private ExternosWrapper wrapper;

	@Override
	public List<ExternosResponseDTO> listToDto(List<?> list) {
		List<ExternosResponseDTO> listDto = new ArrayList<>();

		try {
			for (Object object : list) {
				List<String> parseResult = CommonsBuilder.arrayToList(object.toString().split(","));

				listDto.add(wrapper.result(parseResult));
			}
		} catch (Exception e) {
			throw e;
		}

		return listDto;
	}

	@Override
	public ExternosDTO mapToDto(Map<String, String> map) {
		ExternosDTO dto = new ExternosDTO();

		String codigoTipoDocumento = map.get("codigoTipoDocumento");
		if (CommonsValidator.isNotNull(codigoTipoDocumento)) {
			dto.setCodigoTipoDocumento(codigoTipoDocumento);
		}

		String codigoPais = map.get("codigoPais");
		if (CommonsValidator.isNotNull(codigoPais)) {
			dto.setCodigoPais(codigoPais);
		}

		String codigoProveedor = map.get("codigoProveedor");
		if (CommonsValidator.isNotNull(codigoProveedor)) {
			dto.setCodigoProveedor(codigoProveedor);
		}

		String codigoPuesto = map.get("codigoPuesto");
		if (CommonsValidator.isNotNull(codigoPuesto)) {
			dto.setCodigoPuesto(codigoPuesto);
		}

		String codigoJefatura = map.get("codigoJefatura");
		if (CommonsValidator.isNotNull(codigoJefatura)) {
			dto.setCodigoJefatura(codigoJefatura);
		}

		String codigoDivision = map.get("codigoDivision");
		if (CommonsValidator.isNotNull(codigoDivision)) {
			dto.setCodigoDivision(codigoDivision);
		}

		String codigoDireccion = map.get("codigoDireccion");
		if (CommonsValidator.isNotNull(codigoDireccion)) {
			dto.setCodigoDireccion(codigoDireccion);
		}

		String codigoGerencia = map.get("codigoGerencia");
		if (CommonsValidator.isNotNull(codigoGerencia)) {
			dto.setCodigoGerencia(codigoGerencia);
		}

		String codigoGenero = map.get("codigoGenero");
		if (CommonsValidator.isNotNull(codigoGenero)) {
			dto.setCodigoGenero(codigoGenero);
		}

		return dto;
	}

}