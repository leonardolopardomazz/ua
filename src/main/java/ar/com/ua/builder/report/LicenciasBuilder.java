package ar.com.ua.builder.report;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.ua.dto.report.LicenciasResponseDTO;
import ar.com.ua.projection.report.LicenciasProjection;
import ar.com.ua.repository.report.CommonsRepository;

@Component
public class LicenciasBuilder implements IBuilderResponse<List<LicenciasProjection>, List<LicenciasResponseDTO>> {

	@Autowired
	private CommonsRepository commonsRepository;

	@Override
	public List<LicenciasResponseDTO> listToDto(List<LicenciasProjection> listProjection) {

		List<LicenciasResponseDTO> listDto = new ArrayList<>();

		try {
			for (LicenciasProjection licenciasProjection : listProjection) {
				LicenciasResponseDTO dto = new LicenciasResponseDTO();
				dto.setNumeroLegajo(licenciasProjection.getNumeroLegajo());
				dto.setApellido(licenciasProjection.getApellido());
				dto.setNombre(licenciasProjection.getNombre());
				dto.setDescripcionLicencia(commonsRepository.descripcion(licenciasProjection.getCodigoLicencia()));
				dto.setFechaInicio(licenciasProjection.getFechaInicio());
				dto.setFechaFin(licenciasProjection.getFechaFin());
				dto.setEstado(licenciasProjection.getActivo());
				dto.setPais(licenciasProjection.getPaisDescripcion());
				dto.setDireccion(commonsRepository.descripcion(licenciasProjection.getCodigoDireccion()));
				dto.setGerencia(commonsRepository.descripcion(licenciasProjection.getCodigoGerencia()));
				dto.setJefatura(commonsRepository.descripcion(licenciasProjection.getCodigoJefatura()));
				dto.setPuesto(licenciasProjection.getDescripcion());

				listDto.add(dto);
			}
		} catch (Exception e) {
			throw e;
		}

		return listDto;
	}

}
