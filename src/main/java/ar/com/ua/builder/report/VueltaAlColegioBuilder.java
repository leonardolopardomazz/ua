package ar.com.ua.builder.report;

import java.util.Map;

import org.springframework.stereotype.Component;

import ar.com.ua.dto.report.VueltaAlColegioDTO;

@Component
public class VueltaAlColegioBuilder implements IBuilder<Map <String, String>, VueltaAlColegioDTO>  {

	@Override
	public VueltaAlColegioDTO mapToDto(Map<String, String> map) {
		VueltaAlColegioDTO dto = new VueltaAlColegioDTO();
		
		/*
		 * 	private List<String> pais;
	private String numeroLegajo;
	private String apellido;
	private Long codigoPais;
	private Long codigoDireccion;
	private Long codigoPuesto;
		 */
		
	 dto.setNumeroLegajo(map.get("numeroLegajo"));
	 dto.setApellido(map.get("apellido"));
	 dto.setCodigoPais(Long.getLong(map.get("codigoPais")));
	 dto.setCodigoDireccion(Long.getLong(map.get("codigoDireccion")));
	 dto.setCodigoPuesto(Long.getLong(map.get("codigoPuesto")));
	 
		return null;
	}


}
