package ar.com.ua.builder.report;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.ua.dto.report.DirectoresDTO;
import ar.com.ua.dto.report.DirectoresResponseDTO;
import ar.com.ua.wrapper.report.DirectoresWrapper;

public class DirectoresBuilder
		implements IBuilder<Map<String, String>, DirectoresDTO>, IBuilderResponse<List<?>, DirectoresResponseDTO> {

	@Autowired
	private DirectoresWrapper wrapper;

	@Override
	public List<DirectoresResponseDTO> listToDto(List<?> list) {
		List<DirectoresResponseDTO> listDto = new ArrayList<>();

		try {
			for (Object object : list) {
				List<String> parseResult = CommonsBuilder.arrayToList(object.toString().split(","));

				listDto.add(wrapper.result(parseResult));
			}
		} catch (Exception e) {
			throw e;
		}

		return listDto;
	}

	@Override
	public DirectoresDTO mapToDto(Map<String, String> map) {
		DirectoresDTO dto = new DirectoresDTO();

		String idPais = map.get("idPais");
		if (CommonsValidator.isNotNull(idPais)) {
			dto.setIdPais(idPais);
		}

		String idLugarTrabajo = map.get("idLugarTrabajo");
		if (CommonsValidator.isNotNull(idLugarTrabajo)) {
			dto.setIdLugarTrabajo(idLugarTrabajo);
		}

		String idCategoria = map.get("idCategoria");
		if (CommonsValidator.isNotNull(idCategoria)) {
			dto.setIdCategoria(idCategoria);
		}

		String idManager = map.get("idManager");
		if (CommonsValidator.isNotNull(idManager)) {
			dto.setIdManager(idManager);
		}

		String idCargoManager = map.get("idCargoManager");
		if (CommonsValidator.isNotNull(idCargoManager)) {
			dto.setIdCargoManager(idCargoManager);
		}

		String idDireccion = map.get("idDireccion");
		if (CommonsValidator.isNotNull(idDireccion)) {
			dto.setIdDireccion(idDireccion);
		}

		String idGerencia = map.get("idGerencia");
		if (CommonsValidator.isNotNull(idGerencia)) {
			dto.setIdGerencia(idGerencia);
		}

		String idJefatura = map.get("idJefatura");
		if (CommonsValidator.isNotNull(idJefatura)) {
			dto.setIdJefatura(idJefatura);
		}

		String idDivision = map.get("idDivision");
		if (CommonsValidator.isNotNull(idDivision)) {
			dto.setIdDivision(idDivision);
		}

		String idCentroDeCostos = map.get("idCentroDeCostos");
		if (CommonsValidator.isNotNull(idCentroDeCostos)) {
			dto.setIdCentroDeCostos(idCentroDeCostos);
		}

		String idConvenio = map.get("idConvenio");
		if (CommonsValidator.isNotNull(idConvenio)) {
			dto.setIdConvenio(idConvenio);
		}

		return dto;
	}

}
