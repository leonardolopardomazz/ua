package ar.com.ua.builder;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.com.ua.dto.UsuarioDTO;
import ar.com.ua.model.Usuario;

@Component
public class UsuarioBuilder implements IBuilder<Usuario, UsuarioDTO> {

	@Override
	public Usuario dtoToModel(UsuarioDTO dto) {
		Usuario usuario = new Usuario();
		usuario.setId(dto.getId());
		usuario.setNombreUsuario(dto.getNombreUsuario());
		usuario.setFechaAlta(new Date());
		usuario.setFechaBaja(dto.getFechaBaja());
		usuario.setActivo(dto.isActivo());
		
		return usuario;
	}

	@Override
	public UsuarioDTO modelToDto(Usuario model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UsuarioDTO> modelListToDto(List<Usuario> list) {
		// TODO Auto-generated method stub
		return null;
	}

}
