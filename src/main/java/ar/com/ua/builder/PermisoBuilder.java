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
		permiso.setActivo(dto.isActivo());
		permiso.setCodigo(dto.getCodigo());
		permiso.setDescripcion(dto.getDescripcion());
		
		if(!dto.getRoles().isEmpty()) {
			permiso.setRoles(dto.getRoles());
		}

		return permiso;
	}

	@Override
	public PermisoDTO modelToDto(Permiso model) {
		PermisoDTO dto = new PermisoDTO();
		dto.setActivo(model.isActivo());
		dto.setCodigo(model.getCodigo());
		dto.setDescripcion(model.getDescripcion());
		dto.setRoles(model.getRoles());

		return dto;
	}

	@Override
	public List<PermisoDTO> modelListToDto(List<Permiso> list) {
		List<PermisoDTO> dtoList = new ArrayList<>();

		for (Permiso permiso : list) {
			PermisoDTO dto = new PermisoDTO();
			dto.setActivo(permiso.isActivo());
			dto.setCodigo(permiso.getCodigo());
			dto.setDescripcion(permiso.getDescripcion());
			dto.setRoles(permiso.getRoles());
			dtoList.add(dto);
		}

		return dtoList;
	}

}
