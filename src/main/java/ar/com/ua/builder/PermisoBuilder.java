package ar.com.ua.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.com.ua.dto.PermisoDTO;
import ar.com.ua.model.Permiso;

@Component
public class PermisoBuilder implements IBuilder<Permiso, PermisoDTO> {

	@Override
	public Permiso dtoToModel(PermisoDTO dto) {
		Permiso permiso = new Permiso();
		permiso.setId(dto.getId());
		permiso.setDescripcion(dto.getDescripcion());
		permiso.setCodigo(dto.getCodigo());
		permiso.setActivo(dto.isActivo());
		
		return permiso;
	}

	@Override
	public PermisoDTO modelToDto(Permiso model) {
		PermisoDTO dto = new PermisoDTO();
		dto.setActivo(model.isActivo());
		dto.setId(model.getId());
		dto.setDescripcion(model.getDescripcion());
		dto.setCodigo(model.getCodigo());
		dto.setRoles(model.getRoles());

		return dto;
	}

	@Override
	public List<PermisoDTO> modelListToDto(List<Permiso> list) {
		List<PermisoDTO> dtoList = new ArrayList<>();

		for (Permiso permiso : list) {
			PermisoDTO dto = new PermisoDTO();
			dto.setActivo(permiso.isActivo());
			dto.setId(permiso.getId());
			dto.setDescripcion(permiso.getDescripcion());
			dto.setCodigo(permiso.getCodigo());
			dto.setRoles(permiso.getRoles());
			dtoList.add(dto);
		}

		return dtoList;
	}

}
