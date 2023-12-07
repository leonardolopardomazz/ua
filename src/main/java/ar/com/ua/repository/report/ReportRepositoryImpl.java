package ar.com.ua.repository.report;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.com.ua.dto.report.CentroDeCostoDTO;
import ar.com.ua.dto.report.DirectoresDTO;
import ar.com.ua.dto.report.ExternosDTO;
import ar.com.ua.dto.report.GenericoDTO;
import ar.com.ua.dto.report.HistorialLaboralDTO;
import ar.com.ua.dto.report.InternationalDataCollectionDTO;
import ar.com.ua.dto.report.LicenciaDTO;
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
		final String QUERY = "SELECT FROM ua.cargas_de_familia WHERE (cod_rol, id_permiso) VALUES (? ,?)";
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String reportCentroDeCosto(CentroDeCostoDTO dto) {
		// TODO Auto-generated method stub
		return null;
		
		
	}

	@Override
	public String reportHistorialLaboral(HistorialLaboralDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String reportInternationalDataCollection(InternationalDataCollectionDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String reportExternos(ExternosDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String reportDirectores(DirectoresDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String reportGenerico(GenericoDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String reportLicencia(LicenciaDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}


}
