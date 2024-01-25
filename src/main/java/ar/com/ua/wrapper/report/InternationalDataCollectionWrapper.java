package ar.com.ua.wrapper.report;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.ua.dto.report.InternationalDataCollectionResponseDTO;
import ar.com.ua.repository.report.ParametrosRepository;

@Component
public class InternationalDataCollectionWrapper {

	@Autowired
	private ParametrosRepository repository;

	private int calcularEdad(String fecha) {
		if (fecha == null)
			return 0;
		System.out.println("Fecha=" + fecha);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");

		LocalDate fechaNac = LocalDate.parse(fecha, fmt);
		LocalDate ahora = LocalDate.now();

		Period periodo = Period.between(fechaNac, ahora);

		return periodo.getYears();
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
		dto.setGender(repository.descripcion(data.get(9)));
		dto.setTitle(repository.texto1(data.get(9)));
		dto.setCountry(data.get(10));
		dto.setMailLaboral(data.get(11));
		dto.setStartDate(data.get(12));
		dto.setHorasDeTrabajo(data.get(13));
		dto.setFte(repository.texto2(data.get(14)));
		dto.setRateFrecuency(repository.descripcion(data.get(15)));
		dto.setSalaryBasePayRate(null);
		dto.setReasonForSalaryChange(null);
		dto.setEmploymentType(repository.descripcion(data.get(16)));
		dto.setPersonnelType(repository.descripcion(data.get(17)));
		dto.setJefatura(repository.descripcion(data.get(18)));
		dto.setTermDate(data.get(19)); // feche egreso
		dto.setTermReason(repository.descripcion(data.get(20)));
		dto.setAntiguedad(String.valueOf(calcularEdad(data.get(12))));
		dto.setAge(String.valueOf(calcularEdad(data.get(8))));
		dto.setGeneration(repository.descripcion(data.get(21)));
		dto.setDivision(repository.descripcion(data.get(22)));
		dto.setDireccion(repository.descripcion(data.get(23)));
		dto.setGerencia(repository.descripcion(data.get(24)));
		dto.setSubgerencia(null);
		dto.setDepartment(repository.descripcion(data.get(23)));
		dto.setOficina(repository.descripcion(data.get(25)));
		dto.setActivo(String.valueOf("null".equals(data.get(26))));
		return dto;
	}

}
