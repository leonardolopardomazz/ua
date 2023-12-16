package ar.com.ua.controller.report;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ua.dto.response.ResponseDto;
import ar.com.ua.service.report.VueltaAlColegioService;

@RequestMapping("/reporte/vueltaalcolegio")
@RestController
public class VueltaAlColegioController implements IReport {
	
	@Autowired
	private VueltaAlColegioService reporteService;

	@Override
	public ResponseDto generateReport(Map<String, String> params) {
		
		 this.reporteService.generateVueltaAlColegio(params);
		 return null;
	}
	
	

}
