package ar.com.ua.builder;

import java.util.ArrayList;
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
		usuario.setNumeroLegajo(dto.getNumeroLegajo());
		usuario.setNombreUsuario(dto.getNombreUsuario());
		usuario.setFechaAlta(new Date());
		usuario.setFechaBaja(dto.getFechaBaja());
		usuario.setActivo(dto.isActivo());
		usuario.setBloqueado(dto.isBloqueado());
		usuario.setContrasena(dto.getContrasena());
		
		return usuario;
	}

	@Override
	public UsuarioDTO modelToDto(Usuario model) {
		UsuarioDTO dto = new UsuarioDTO();
		dto.setActivo(model.isActivo());
		dto.setBloqueado(model.isBloqueado());
		dto.setFechaAlta(model.getFechaAlta());
		dto.setFechaBaja(model.getFechaBaja());
		dto.setId(model.getId());
		dto.setNombreUsuario(model.getNombreUsuario());
		dto.setContrasena(model.getContrasena());
		dto.setNumeroLegajo(model.getNumeroLegajo());
		dto.setRoles(model.getRoles());
		
		return dto;
	}

	@Override
	public List<UsuarioDTO> modelListToDto(List<Usuario> list) {
		List<UsuarioDTO> dtoList = new ArrayList<>();

		for (Usuario usuario : list) {
			UsuarioDTO dto = new UsuarioDTO();
			dto.setActivo(usuario.isActivo());
			dto.setBloqueado(dto.isBloqueado());
			dto.setFechaAlta(usuario.getFechaAlta());
			dto.setFechaBaja(usuario.getFechaBaja());
			dto.setId(usuario.getId());
			dto.setNombreUsuario(usuario.getNombreUsuario());
			dto.setNumeroLegajo(usuario.getNumeroLegajo());
			dto.setRoles(usuario.getRoles());
			dtoList.add(dto);
		}

		return dtoList;
	}

}
