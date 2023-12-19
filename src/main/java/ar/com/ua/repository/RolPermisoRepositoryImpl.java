package ar.com.ua.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.com.ua.model.RolPermiso;
import ar.com.ua.service.PermisoService;
import ar.com.ua.service.RolService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
@Transactional(readOnly = false)
public class RolPermisoRepositoryImpl implements RolPermisoRepository<RolPermiso> {

	@Autowired
	private PermisoService permisoService;

	@Autowired
	private RolService rolService;

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void customSave(RolPermiso rolPermiso) {
		
		Long codigoRol = rolPermiso.getCodigoRol();
		Long codigoPermiso = rolPermiso.getCodigoPermiso();

		final String QUERY = "INSERT INTO roles_permisos (cod_rol, id_permiso) VALUES (? ,?)";

		if (rolService.existsById(codigoRol) && permisoService.existsById(codigoPermiso)) {
			entityManager.createNativeQuery(QUERY)
				.setParameter(1, codigoRol)
				.setParameter(2, codigoPermiso)
				.executeUpdate();
		}
	}

	@Override
	public void customDelete(RolPermiso rolPermiso) {
		Long codigoRol = rolPermiso.getCodigoRol();
		Long codigoPermiso = rolPermiso.getCodigoPermiso();

		final String QUERY = "DELETE FROM roles_permisos WHERE cod_rol = ? AND id_permiso = ?";
		
		if (rolService.existsById(codigoRol) && permisoService.existsById(codigoPermiso)) {
			entityManager.createNativeQuery(QUERY)
				.setParameter(1, codigoRol)
				.setParameter(2, codigoPermiso)
				.executeUpdate();
		}
		
	}

}
