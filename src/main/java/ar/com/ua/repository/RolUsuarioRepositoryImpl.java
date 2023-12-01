package ar.com.ua.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.com.ua.model.RolUsuario;
import ar.com.ua.service.RolService;
import ar.com.ua.service.UsuarioService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
@Transactional(readOnly = false)
public class RolUsuarioRepositoryImpl implements RolUsuarioRepository<RolUsuario> {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private RolService rolService;

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void customSave(RolUsuario rolUsuario) {
		
		Long codigoRol = rolUsuario.getCodigo();
		Long idUsuario = rolUsuario.getId();

		final String QUERY = "INSERT INTO ua.roles_usuarios (cod_rol, id_usuario) VALUES (? ,?)";

		if (rolService.existsById(codigoRol) && usuarioService.existsById(idUsuario)) {
			entityManager.createNativeQuery(QUERY)
				.setParameter(1, codigoRol)
				.setParameter(2, idUsuario)
				.executeUpdate();
		}
	}

	@Override
	public void customDelete(RolUsuario rolUsuario) {
		Long codigoRol = rolUsuario.getCodigo();
		Long idUsuario = rolUsuario.getId();

		final String QUERY = "DELETE FROM ua.roles_usuarios WHERE cod_rol = ? AND id_usuario = ?";

		if (rolService.existsById(codigoRol) && usuarioService.existsById(idUsuario)) {
			entityManager.createNativeQuery(QUERY)
				.setParameter(1, codigoRol)
				.setParameter(2, idUsuario)
				.executeUpdate();
		}
		
	}

}
