package ar.com.ua.wrapper.report;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.ua.dto.report.InternationalDataCollectionResponseDTO;
import ar.com.ua.model.Parametro;
import ar.com.ua.repository.report.ParametrosRepository;
import ar.com.ua.service.ParametroService;

@Component
public class InternationalDataCollectionWrapper {

	@Autowired
	private ParametroService parametroService;

	private int calcularEdad(String fecha) {
		if (fecha == null)
			return 0;
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");

		LocalDate fechaNac = LocalDate.parse(fecha, fmt);
		LocalDate ahora = LocalDate.now();

		Period periodo = Period.between(fechaNac, ahora);

		return periodo.getYears();
	}

	private String descripcion(String id) {
		if (id != null) {
			Parametro param = parametroService.findById(Long.valueOf(id)).get();
			return param.getDescripcion();
		}
		return "";
	}

	private String texto1(String id) {
		if (id != null) {
			Parametro param = parametroService.findById(Long.valueOf(id)).get();
			return param.getTexto1();
		}
		return "";
	}

	private String texto2(String id) {
		if (id != null) {
			Parametro param = parametroService.findById(Long.valueOf(id)).get();
			return param.getTexto2();
		}
		return "";
	}

	public InternationalDataCollectionResponseDTO result(List<String> data) {
		InternationalDataCollectionResponseDTO dto = new InternationalDataCollectionResponseDTO();
		dto.setGlobalId(data.get(0));
		dto.setPositionTitle(data.get(1));
		dto.setCargoManagerToReport(data.get(2));
		dto.setManagerToReport(data.get(3));
		// dto.setTitle(data.get(4));
		dto.setSurname(data.get(4));
		dto.setFirstName(data.get(5));
		dto.setMiddleName(data.get(6));
		// dto.setOtherName(data.get(8));
		dto.setPreferedName(data.get(7));
		dto.setDateOfBirth(data.get(8));
		dto.setGender(descripcion(data.get(9)));
		dto.setTitle(texto1(data.get(9)));
		dto.setCountry(data.get(10));
		dto.setMailLaboral(data.get(11));
		dto.setStartDate(data.get(12));
		dto.setHorasDeTrabajo(data.get(13));
		dto.setFte(texto2(data.get(14)));
		dto.setRateFrecuency(texto1(data.get(15)));
		dto.setSalaryBasePayRate(null);
		dto.setReasonForSalaryChange(null);
		dto.setEmploymentType(texto1(data.get(16)));
		dto.setPersonnelType(descripcion(data.get(17)));
		dto.setJefatura(descripcion(data.get(18)));
		dto.setTermDate(data.get(19)); // feche egreso
		dto.setTermReason(descripcion(data.get(20)));
		dto.setAntiguedad(String.valueOf(calcularEdad(data.get(12))));
		dto.setAge(String.valueOf(calcularEdad(data.get(8))));
		dto.setGeneration(descripcion(data.get(21)));
		dto.setDivission(texto1(data.get(22)));
		dto.setDireccion(descripcion(data.get(23)));
		dto.setGerencia(descripcion(data.get(24)));
		dto.setSubgerencia(null);
		dto.setDepartment(descripcion(data.get(23)));
		dto.setOficina(descripcion(data.get(25)));
		dto.setActive(String.valueOf("null".equals(data.get(26))));
		dto.setCategory(descripcion(data.get(27)));
		return dto;
	}

}
