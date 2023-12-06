package ar.com.ua.repository.report;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.com.ua.dto.report.VueltaAlColegioDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
@Transactional(readOnly = false)
public class ReportRepositoryImpl implements ReportRepository {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public String reportVueltaAlColegio(VueltaAlColegioDTO dto) {
		final String QUERY = "SELECT INSERT INTO ua.roles_permisos (cod_rol, id_permiso) VALUES (? ,?)";
		
		// TODO Auto-generated method stub
		return null;
	}


}
