package ar.com.ua.wrapper.report;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.ua.dto.report.DirectoresResponseDTO;
import ar.com.ua.model.Parametro;
import ar.com.ua.service.ParametroService;

@Component
public class DirectoresWrapper {

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

	public DirectoresResponseDTO result(List<String> data) {
		DirectoresResponseDTO dto = new DirectoresResponseDTO();
		dto.setNumeroLegajo(data.get(0));
		dto.setApellidoNombre(data.get(1));
		dto.setFechaIngreso(data.get(2));
		dto.setFechaIngresoReconocida(data.get(3));
		dto.setDescripcionPais(data.get(4));
		dto.setEmailLaboral(data.get(5));
		dto.setDescripcionOficina(descripcion(data.get(6)));
		dto.setDescripcionPuesto(data.get(7));
		dto.setDescripcionCategoria(descripcion(data.get(8)));
		dto.setDescripcionDireccion(descripcion(data.get(9)));
		dto.setDescripcionGerencia(descripcion(data.get(10)));
		dto.setDescripcionJefatura(descripcion(data.get(11)));
		dto.setDescripcionCargoManagerJefe(data.get(12));
		dto.setDescripcionDivision(descripcion(data.get(13)));
		dto.setDescripcionCentroDeCostos(descripcion(data.get(14)));
		dto.setDescripcionConvenio(descripcion(data.get(15)));
		dto.setDescripcionManagerJefe(data.get(16));

		return dto;
	}
}
