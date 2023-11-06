package ar.com.ua.builder;

import java.util.List;

import org.springframework.stereotype.Component;

import ar.com.ua.dto.RolPermisoDTO;
import ar.com.ua.model.RolPermiso;

@Component
public class RolPermisoBuilder implements IBuilder<RolPermiso, RolPermisoDTO> {

	@Override
	public RolPermiso dtoToModel(RolPermisoDTO dto) {
		RolPermiso rolPermiso = new RolPermiso();
		rolPermiso.setCodigoRol(dto.getCodigoRol());
		rolPermiso.setCodigoPermiso(dto.getCodigoPermiso());
		return rolPermiso;
	}

	@Override
	public RolPermisoDTO modelToDto(RolPermiso model) {
		return null;
	}

	@Override
	public List<RolPermisoDTO> modelListToDto(List<RolPermiso> list) {
		return null;
	}

}
