package ar.com.ua.commons;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class ManejoFechas {

	private static Period calculatePeriod(String fecha) {
		if (fecha == null) {
			new Exception();
		}

		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
		LocalDate fechaNac = LocalDate.parse(fecha, fmt);
		LocalDate ahora = LocalDate.now();
		Period periodo = Period.between(fechaNac, ahora);
		return periodo;
	}

	/**
	 * Dada una fecha calcula los anios de diferencia a la fecha
	 * 
	 * @param fecha
	 * @return
	 */
	public int calcularDiferenciaEnAniosHastaHoy(String fecha) {
		Period periodo = calculatePeriod(fecha);
		return periodo.getYears();
	}

	public static int calcularDiferenciaEnDiasHastaHoy(String fecha) {
		Period periodo = calculatePeriod(fecha);
		return periodo.getDays();
	}

}
