package ar.com.ua.service.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.ua.dto.report.VueltaAlColegioDTO;
import ar.com.ua.repository.report.ReportRepository;

@Component
public class ReporteService {
	
	@Autowired
	private ReportRepository repository;

	public String generateVueltaAlColegio(VueltaAlColegioDTO dto) {
		return this.repository.reportVueltaAlColegio(dto);
	}


}
