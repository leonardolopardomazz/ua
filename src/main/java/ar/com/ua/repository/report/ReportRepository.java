package ar.com.ua.repository.report;

import ar.com.ua.dto.report.CentroDeCostoDTO;
import ar.com.ua.dto.report.DirectoresDTO;
import ar.com.ua.dto.report.ExternosDTO;
import ar.com.ua.dto.report.GenericoDTO;
import ar.com.ua.dto.report.HistorialLaboralDTO;
import ar.com.ua.dto.report.InternationalDataCollectionDTO;
import ar.com.ua.dto.report.LicenciaDTO;
import ar.com.ua.dto.report.VueltaAlColegioDTO;

public interface ReportRepository {
	
	String reportVueltaAlColegio(VueltaAlColegioDTO dto);

	String reportCentroDeCosto(CentroDeCostoDTO dto);

	String reportHistorialLaboral(HistorialLaboralDTO dto);

	String reportInternationalDataCollection(InternationalDataCollectionDTO dto);

	String reportExternos(ExternosDTO dto);

	String reportDirectores(DirectoresDTO dto);

	String reportGenerico(GenericoDTO dto);

	String reportLicencia(LicenciaDTO dto);
}
