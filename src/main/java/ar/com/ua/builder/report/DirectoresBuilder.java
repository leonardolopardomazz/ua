package ar.com.ua.builder.report;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.ua.dto.report.DirectoresResponseDTO;
import ar.com.ua.projection.report.DirectoresProjection;
import ar.com.ua.repository.report.CommonsRepository;

@Component
public class DirectoresBuilder implements IBuilderResponse<List<DirectoresProjection>, List<DirectoresResponseDTO>> {

	@Autowired
	private CommonsRepository commonsRepository;

	@Override
	public List<DirectoresResponseDTO> listToDto(List<DirectoresProjection> listProjection) {
		List<DirectoresResponseDTO> listDto = new ArrayList<>();

		try {
			for (DirectoresProjection projection : listProjection) {
				DirectoresResponseDTO dto = new DirectoresResponseDTO();
				dto.setNumeroLegajo(projection.getNumeroLegajo());
				dto.setApellidoNombre(projection.getApellidoNombre());
				dto.setFechaIngreso(projection.getFechaIngreso());
				dto.setFechaIngresoReconocida(projection.getFechaIngresoReconocida());
				dto.setDescripcionPais(projection.getCodigoPais());
				dto.setEmailLaboral(projection.getEmailLaboral());
				dto.setDescripcionOficina(commonsRepository.descripcion(projection.getCodigoOficina()));
				dto.setDescripcionPuesto(projection.getCodigoPuesto());
				dto.setDescripcionCategoria(commonsRepository.descripcion(projection.getCodigoCategoria()));
				dto.setDescripcionDireccion(commonsRepository.descripcion(projection.getCodigoDireccion()));
				dto.setDescripcionGerencia(commonsRepository.descripcion(projection.getCodigoGerencia()));
				dto.setDescripcionJefatura(commonsRepository.descripcion(projection.getCodigoJefatura()));
				dto.setDescripcionCargoManagerJefe(projection.getPuestoManager());
				dto.setDescripcionDivision(commonsRepository.descripcion(projection.getCodigoDivision()));
				dto.setDescripcionCentroDeCostos(commonsRepository.descripcion(projection.getCodigoCentroDeCosto()));
				dto.setDescripcionConvenio(commonsRepository.descripcion(projection.getCodigoConvenio()));
				dto.setDescripcionManagerJefe(projection.getApellidoNombreManager());

				listDto.add(dto);
			}
		} catch (Exception e) {
			throw e;
		}

		return listDto;
	}

}
