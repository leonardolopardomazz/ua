package ar.com.ua.builder.report;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.ua.dto.report.InternationalDataCollectionResponseDTO;
import ar.com.ua.projection.report.InternationalDataCollectionProjection;
import ar.com.ua.repository.report.CommonsRepository;

@Component
public class InternationalDataCollectionBuilder implements
		IBuilderResponse<List<InternationalDataCollectionProjection>, List<InternationalDataCollectionResponseDTO>> {

	@Autowired
	private CommonsRepository commonsRepository;

	@Override
	public List<InternationalDataCollectionResponseDTO> listToDto(
			List<InternationalDataCollectionProjection> listProjection) {

		List<InternationalDataCollectionResponseDTO> listDto = new ArrayList<>();
		try {
			for (InternationalDataCollectionProjection projection : listProjection) {
				InternationalDataCollectionResponseDTO dto = new InternationalDataCollectionResponseDTO();

				dto.setGlobalId(projection.getGlobalId());
				dto.setPositionTitle(projection.getPositionTitle());
				dto.setCargoManagerToReport(projection.getCargoManagerToReport());
				dto.setManagerToReport(projection.getManagerToReport());
				dto.setSurname(projection.getSurname());
				dto.setFirstName(projection.getFirstName());
				dto.setMiddleName(projection.getMiddleName());
				dto.setPreferedName(projection.getPreferedName());
				dto.setDateOfBirth(projection.getDateOfBirth());
				dto.setGender(commonsRepository.descripcion(projection.getGender()));
				dto.setTitle(commonsRepository.texto1(projection.getTitle()));
				dto.setCountry(projection.getCountry());
				dto.setMailLaboral(projection.getMailLaboral());
				dto.setStartDate(projection.getStartDate());
				dto.setHorasDeTrabajo(commonsRepository.descripcion(projection.getHorasDeTrabajo()));
				dto.setFte(commonsRepository.texto2(projection.getFte()));
				dto.setRateFrecuency(commonsRepository.texto1(projection.getRateFrecuency()));
				dto.setSalaryBasePayRate(null);
				dto.setReasonForSalaryChange(null);
				dto.setEmploymentType(commonsRepository.texto1(projection.getEmploymentType()));
				dto.setPersonnelType(commonsRepository.descripcion(projection.getPersonnelType()));
				dto.setJefatura(commonsRepository.descripcion(projection.getJefatura()));
				dto.setTermDate(projection.getTermDate()); // feche egreso
				dto.setTermReason(commonsRepository.descripcion(projection.getTermReason()));
				dto.setAntiguedad(String.valueOf(commonsRepository.calcularEdad(projection.getAntiguedad())));
				dto.setAge(String.valueOf(commonsRepository.calcularEdad(projection.getAge())));
				dto.setGeneration(commonsRepository.descripcion(projection.getGeneration()));
				dto.setDivission(commonsRepository.texto1(projection.getDivission()));
				dto.setDireccion(commonsRepository.descripcion(projection.getDireccion()));
				dto.setGerencia(commonsRepository.descripcion(projection.getGeneration()));
				dto.setSubgerencia(null);
				dto.setDepartment(commonsRepository.descripcion(projection.getDepartment()));
				dto.setOficina(commonsRepository.descripcion(projection.getOficina()));
				dto.setActive(String.valueOf("null".equals(projection.getActive())));
				dto.setCategory(commonsRepository.descripcion(projection.getCategory()));

				listDto.add(dto);
			}
		} catch (Exception e) {
			throw e;
		}

		return listDto;
	}

}
