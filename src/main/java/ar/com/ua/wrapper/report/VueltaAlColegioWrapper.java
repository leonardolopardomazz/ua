package ar.com.ua.wrapper.report;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.com.ua.dto.report.VueltaAlColegioResponseDTO;

@Component
public class VueltaAlColegioWrapper {

	private String devolverEdadesAcumuladas(List<Integer> edades) {
		String edadesAcumuladas = "";

		for (Integer edad : edades) {
			if (edad <= 20) {
				edadesAcumuladas = edadesAcumuladas + ", " + edad;
			}
		}
		return edadesAcumuladas;
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
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		LocalDate fechaNac = LocalDate.parse(fecha, fmt);
		LocalDate ahora = LocalDate.now();

		Period periodo = Period.between(fechaNac, ahora);

		return periodo.getYears();
	}

	private List<Integer> calcularEdades(List<String> fechas) {

		List<Integer> edades = new ArrayList<>();
		for (Iterator<String> iterator = fechas.iterator(); iterator.hasNext();) {
			String fecha = (String) iterator.next();

			int edad = calcularEdad(fecha);
			edades.add(edad);
		}

		return edades;
	}

	public VueltaAlColegioResponseDTO result(List<String> initialData, List<String> dates) {
		VueltaAlColegioResponseDTO dto = new VueltaAlColegioResponseDTO();
		dto.setNumeroLegajo(initialData.get(0));
		dto.setApellido(initialData.get(1));
		dto.setNombre(initialData.get(2));
		dto.setPais(initialData.get(3));
		List<Integer> edades = calcularEdades(dates);
		dto.setCantidadHijos(calcularCantidadHijos(edades));
		dto.setEdades(devolverEdadesAcumuladas(edades));

		return dto;
	}

}
