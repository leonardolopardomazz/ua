package ar.com.ua.wrapper.report;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.ua.dto.report.InternationalDataCollectionResponseDTO;
import ar.com.ua.repository.report.ParametrosRepository;

@Component
public class InternationalDataCollectionWrapper {
	
	@Autowired
	private ParametrosRepository repository;
	
	public InternationalDataCollectionResponseDTO result(List<String> data) {
		InternationalDataCollectionResponseDTO dto = new InternationalDataCollectionResponseDTO();
		dto.setGlobalId(data.get(0));
		dto.setPositionTitle(data.get(1));
		dto.setReportsToManagerNameEmail(data.get(2));
		dto.setReportsPositionTitle(data.get(3));
		dto.setTitle(data.get(4));
		dto.setSurname(data.get(5));
		dto.setFirstName(data.get(6));
		dto.setMiddleName(data.get(7));
		dto.setOtherName(data.get(8));
		dto.setPreferedName(data.get(9));
		dto.setDateOfBirth(data.get(10));
		dto.setGender(data.get(11));
		dto.setCountry(data.get(12));
		dto.setMailLaboral(data.get(13));
		dto.setStartDate(data.get(14));
		dto.setHorasDeTrabajo(data.get(15));
		dto.setFte(data.get(16));
		dto.setRateFrecuency(data.get(17));
		dto.setSalaryBasePayRate(null);
		dto.setReasonForSalaryChange(null);
		dto.setEmploymentType(data.get(18));
		dto.setPersonnelType(data.get(19));
		dto.setDepartment(data.get(20));
		dto.setTermDate(data.get(21)); // feche egreso
		dto.setTermReason(data.get(22));
		dto.setAntiguedad(data.get(23));
		dto.setAge(data.get(0)); //calcular
		dto.setGender(data.get(24));
		dto.setDivision(data.get(25));
		return dto;
	}
	
	

}
