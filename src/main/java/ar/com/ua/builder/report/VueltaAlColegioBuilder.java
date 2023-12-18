package ar.com.ua.builder.report;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import ar.com.ua.dto.report.VueltaAlColegioDTO;
import ar.com.ua.dto.report.VueltaAlColegioResponseDTO;

@Component
public class VueltaAlColegioBuilder implements IBuilder<Map<String, String>, VueltaAlColegioDTO>,
		IBuilderResponse<List<?>, VueltaAlColegioResponseDTO> {

	@Override
	public VueltaAlColegioDTO mapToDto(Map<String, String> map) {
		VueltaAlColegioDTO dto = new VueltaAlColegioDTO();

		dto.setPais(map.get("pais"));
		dto.setNumeroLegajo(map.get("numeroLegajo"));
		dto.setApellido(map.get("apellido"));
		dto.setCodigoDireccion(Long.valueOf(map.get("codigoDireccion")));
		dto.setCodigoPuesto(Long.valueOf(map.get("codigoPuesto")));
		dto.setEstadoEmpleado(Boolean.getBoolean(map.get("estadoEmpleado")));

		return dto;
	}

	@Override
	public VueltaAlColegioResponseDTO listToDTo(List<?> list) {
		VueltaAlColegioResponseDTO dto = new VueltaAlColegioResponseDTO();

		String[] resultadoParseado = list.get(0).toString().split(",");

		dto.setNumeroLegajo(resultadoParseado[0]);
		dto.setApellido(resultadoParseado[1]);
		dto.setNombre(resultadoParseado[2]);
		// dto.setFechaNacimiento(resultadoParseado.get);

		String fechas = String.valueOf(list.get(2));
		// dto.set
		List<String> fechasACalcular = this.parsearFecha(fechas);

		this.calcularEdad(fechasACalcular);

		// TODO Auto-generated method stub
		return null;
	}

	// 2023-11-23 15:28:26,2023-11-20 15:28:26
	private List<String> parsearFecha(String fechas) {
		String[] arrayFecha = fechas.split(",");

		List<String> fechaParseada = new ArrayList<>();
		for (String fecha : arrayFecha) {
			String parse = fecha.substring(0, 9);
			fechaParseada.add(parse);
		}

		return fechaParseada;
	}

	private String calcularEdad(List<String> fechas) {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		for (String fecha : fechas) {

			LocalDate fechaNac = LocalDate.parse(fecha, fmt);
			LocalDate ahora = LocalDate.now();

			Period periodo = Period.between(fechaNac, ahora);
			System.out.printf("Tu edad es: %s años, %s meses y %s días", periodo.getYears(), periodo.getMonths(),
					periodo.getDays());

		}
		return null;
	}

}
