package ar.com.ua.builder.report;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.com.ua.dto.report.VueltaAlColegioResponseDTO;
import ar.com.ua.projection.report.VueltaAlColegioProjection;

@Component
public class VueltaAlColegioBuilder
		implements IBuilderResponse<List<VueltaAlColegioProjection>, List<VueltaAlColegioResponseDTO>> {

	private String devolverEdadesAcumuladas(List<Integer> edades) {
		String edadesAcumuladas = "";

		for (Integer edad : edades) {
			if (edad <= 20) {
				edadesAcumuladas = edadesAcumuladas + ", " + edad;
			}
		}
		String beutyResult = (edadesAcumuladas.replaceFirst(",", "")).trim();
		return beutyResult;
	}

	private int calcularCantidadHijos(List<Integer> edades) {
		int cantidadHijos = 0;

		for (Integer edad : edades) {
			if (edad <= 20) {
				cantidadHijos++;
			}
		}
		return cantidadHijos;
	}

	private int calcularEdad(String fecha) {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");

		LocalDate fechaNac = LocalDate.parse(fecha, fmt);
		LocalDate ahora = LocalDate.now();

		Period periodo = Period.between(fechaNac, ahora);

		return periodo.getYears();
	}

	private List<Integer> calcularEdades(String fechas) {
		List<Integer> edades = new ArrayList<>();
		List<String> parseResult = CommonsBuilder.arrayToList(fechas.split(","));

		for (String fecha : parseResult) {
			int edad = calcularEdad(fecha);
			edades.add(edad);
		}

		return edades;
	}

	@Override
	public List<VueltaAlColegioResponseDTO> listToDto(List<VueltaAlColegioProjection> listProjection) {

		List<VueltaAlColegioResponseDTO> listDto = new ArrayList<>();

		try {
			for (VueltaAlColegioProjection projection : listProjection) {
				VueltaAlColegioResponseDTO dto = new VueltaAlColegioResponseDTO();

				dto.setApellido(projection.getApellido());
				dto.setNombre(projection.getNombre());
				dto.setNumeroLegajo(projection.getNumeroLegajo());
				dto.setPais(projection.getPais());

				List<Integer> edades = this.calcularEdades(projection.getFechaNacimiento());
				dto.setCantidadHijos(calcularCantidadHijos(edades));
				dto.setEdades(devolverEdadesAcumuladas(edades));

				listDto.add(dto);
			}
			return listDto;
		} catch (Exception e) {
			throw e;
		}
	}

}
