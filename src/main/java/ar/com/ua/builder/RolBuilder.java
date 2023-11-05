package ar.com.ua.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.com.ua.dto.RolDTO;
import ar.com.ua.model.Rol;

@Component
public class RolBuilder implements IBuilder<Rol, RolDTO> {

	@Override
	public Rol dtoToModel(RolDTO dto) {
		Rol rol = new Rol();
		rol.setActivo(dto.isActivo());
		rol.setCodigo(dto.getCodigo());
		rol.setDescripcion(dto.getDescripcion());
		rol.setPermisos(dto.getPermisos());
		rol.setUsuarios(dto.getUsuarios());

		return rol;
	}

	@Override
	public RolDTO modelToDto(Rol model) {
		RolDTO dto = new RolDTO();
		dto.setActivo(model.isActivo());
		dto.setCodigo(model.getCodigo());
		dto.setDescripcion(model.getDescripcion());
		dto.setPermisos(model.getPermisos());
		dto.setUsuarios(model.getUsuarios());
		
		return dto;
	}

	@Override
	public List<RolDTO> modelListToDto(List<Rol> list) {
		List<RolDTO> dtoList = new ArrayList<>();

		for (Rol rol : list) {
			RolDTO dto = new RolDTO();
			dto.setActivo(rol.isActivo());
			dto.setCodigo(rol.getCodigo());
			dto.setDescripcion(rol.getDescripcion());
			
			if(!rol.getPermisos().isEmpty()) {
				dto.setPermisos(rol.getPermisos());
			}
			
			if(!rol.getUsuarios().isEmpty()) {
				dto.setUsuarios(rol.getUsuarios());
			}
			
			dtoList.add(dto);
		}

		return dtoList;
	}

}
