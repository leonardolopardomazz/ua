package ar.com.ua.repository.report;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.ua.model.Parametro;

@Component
public class CommonsRepository {

	@Autowired
	public ParametrosRepository parametroRepository;

	public String descripcion(String id) {
		Parametro param = parametroRepository.getParametro(id);
		if (param != null) {
			return param.getDescripcion();
		} else {
			return "";
		}
	}

	public String texto1(String id) {
		Parametro param = parametroRepository.getParametro(id);
		if (param != null) {
			return param.getTexto1();
		} else {
			return "";
		}
	}

	public String texto2(String id) {
		Parametro param = parametroRepository.getParametro(id);
		if (param != null) {
			return param.getTexto2();
		} else {
			return "";
		}
	}

	public int calcularEdad(String fecha) {
		if (fecha == null)
			return 0;
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");

		LocalDate fechaNac = LocalDate.parse(fecha, fmt);
		LocalDate ahora = LocalDate.now();

		Period periodo = Period.between(fechaNac, ahora);

		return periodo.getYears();
	}

	public String codigo(String id) {
		Parametro param = parametroRepository.getParametro(id);
		if (param != null) {
			return param.getCodigo();
		} else {
			return "";
		}
	}

}
