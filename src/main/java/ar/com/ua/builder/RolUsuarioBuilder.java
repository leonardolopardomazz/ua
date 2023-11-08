package ar.com.ua.builder;

import java.util.List;

import org.springframework.stereotype.Component;

import ar.com.ua.dto.RolUsuarioDTO;
import ar.com.ua.model.RolUsuario;

@Component
public class RolUsuarioBuilder implements IBuilder<RolUsuario, RolUsuarioDTO> {

	@Override
	public RolUsuario dtoToModel(RolUsuarioDTO dto) {
		RolUsuario rolUsuario = new RolUsuario();
		rolUsuario.setId(dto.getId());
		rolUsuario.setCodigo(dto.getCodigo());
		
		return rolUsuario;
	}

	@Override
	public RolUsuarioDTO modelToDto(RolUsuario model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RolUsuarioDTO> modelListToDto(List<RolUsuario> list) {
		// TODO Auto-generated method stub
		return null;
	}


}
