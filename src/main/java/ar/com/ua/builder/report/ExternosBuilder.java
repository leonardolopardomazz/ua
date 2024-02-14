package ar.com.ua.builder.report;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.ua.dto.report.ExternosResponseDTO;
import ar.com.ua.projection.report.ExternosProjection;
import ar.com.ua.repository.report.CommonsRepository;

@Component
public class ExternosBuilder implements IBuilderResponse<List<ExternosProjection>, List<ExternosResponseDTO>> {

	@Autowired
	CommonsRepository commonsRepository;

	private String defaultString(String s, String def) {
		if (s != null)
			return s;
		return def;
	}

	@Override
	public List<ExternosResponseDTO> listToDto(List<ExternosProjection> listProjection) {
		List<ExternosResponseDTO> listDto = new ArrayList<>();

		try {
			for (ExternosProjection projection : listProjection) {
				ExternosResponseDTO dto = new ExternosResponseDTO();
				dto.setNumeroLegajo(projection.getNumeroLegajo());
				dto.setCodigoTipoDocumento(commonsRepository.descripcion(projection.getCodigoTipoDocumento()));
				dto.setNumeroDocumento(projection.getNumeroDocumento());
				dto.setCodigoPais(projection.getCodigoPais());
				dto.setCodigoProveedor(commonsRepository.descripcion(projection.getCodigoProveedor()));
				dto.setCodigoPuesto(projection.getCodigoPuesto());
				dto.setDepartamento(commonsRepository.descripcion(projection.getDepartamento()));
				dto.setCodigoDivision(commonsRepository.descripcion(projection.getCodigoDivision()));
				dto.setApellidoNombre(projection.getApellidoNombre());
				dto.setManager(defaultString(commonsRepository.descripcion(projection.getCodigoDireccion()), "") + ", "
						+ defaultString(commonsRepository.descripcion(projection.getCodigoGerencia()), "") + ", "
						+ defaultString(commonsRepository.descripcion(projection.getCodigoJefatura()), ""));
				dto.setActivo(projection.getActivo());
				dto.setFechaIngreso(projection.getFechaIngreso());
				dto.setCodigoGenero(commonsRepository.descripcion(projection.getCodigoGenero()));
				dto.setFechaEgreso(projection.getFechaEgreso());
				dto.setEmail(projection.getEmail());

				listDto.add(dto);
			}
		} catch (Exception e) {
			throw e;
		}

		return listDto;
	}

}