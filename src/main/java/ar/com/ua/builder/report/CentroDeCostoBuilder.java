package ar.com.ua.builder.report;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.ua.dto.report.CentroDeCostoResponseDTO;
import ar.com.ua.projection.report.CentroDeCostoProjection;
import ar.com.ua.repository.report.CommonsRepository;

@Component
public class CentroDeCostoBuilder
		implements IBuilderResponse<List<CentroDeCostoProjection>, List<CentroDeCostoResponseDTO>> {

	@Autowired
	private CommonsRepository commonsRepository;

	@Override
	public List<CentroDeCostoResponseDTO> listToDto(List<CentroDeCostoProjection> listProjection) {

		List<CentroDeCostoResponseDTO> listDto = new ArrayList<>();

		try {

			for (CentroDeCostoProjection projection : listProjection) {
				CentroDeCostoResponseDTO dto = new CentroDeCostoResponseDTO();
				dto.setNumeroLegajo(projection.getNumeroLegajo());
				dto.setApellido(projection.getApellido());
				dto.setNombre(projection.getNombre());
				dto.setIdDireccion(projection.getCodigoDireccion());
				dto.setDireccion(commonsRepository.descripcion(projection.getCodigoDireccion()));
				dto.setIdGerencia(projection.getCodigoGerencia());
				dto.setGerencia(commonsRepository.descripcion(projection.getCodigoGerencia()));
				dto.setCodigoCentroDeCosto(commonsRepository.codigo(projection.getCodigoCentroDeCosto()));
				dto.setDescripcionCentroDeCosto(commonsRepository.descripcion(projection.getCodigoCentroDeCosto()));
				dto.setFte(commonsRepository.texto2(projection.getFte()));

				listDto.add(dto);
			}
		} catch (Exception e) {
			throw e;
		}

		return listDto;
	}

}