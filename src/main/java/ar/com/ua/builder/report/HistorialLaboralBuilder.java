package ar.com.ua.builder.report;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.ua.dto.report.HistorialLaboralResponseDTO;
import ar.com.ua.projection.report.HistorialLaboralProjection;
import ar.com.ua.repository.report.CommonsRepository;

@Component
public class HistorialLaboralBuilder
		implements IBuilderResponse<List<HistorialLaboralProjection>, List<HistorialLaboralResponseDTO>> {

	@Autowired
	private CommonsRepository commonsRepository;

	@Override
	public List<HistorialLaboralResponseDTO> listToDto(List<HistorialLaboralProjection> listProjection) {

		List<HistorialLaboralResponseDTO> listDto = new ArrayList<>();

		try {
			for (HistorialLaboralProjection projection : listProjection) {
				HistorialLaboralResponseDTO dto = new HistorialLaboralResponseDTO();
				dto.setApellido(projection.getApellido());
				dto.setDireccion(commonsRepository.descripcion(projection.getCodigoDireccion()));
				dto.setNumeroLegajo(projection.getNumeroLegajo());
				dto.setNombre(projection.getNombre());
				dto.setPuesto(projection.getPuesto());
				dto.setFechaInicioPuesto(projection.getFechaInicioPuesto());
				dto.setFechaFinPuesto(projection.getFechaFinPuesto());

				listDto.add(dto);
			}
		} catch (Exception e) {
			throw e;
		}

		return listDto;
	}

}
