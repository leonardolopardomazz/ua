package ar.com.ua.service.report;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.ua.builder.report.LicenciasBuilder;
import ar.com.ua.dto.report.LicenciasDTO;
import ar.com.ua.dto.report.LicenciasResponseDTO;
import ar.com.ua.repository.report.LicenciasRepository;

@Component
public class LicenciasService {
	
	@Autowired
	private LicenciasBuilder builder;

	@Autowired
	private LicenciasRepository repository;
	
	public List<LicenciasResponseDTO>generar(LicenciasDTO dto) {
		
		try {
			List<String> resultado = this.repository.reporte(dto.getEstadoEmpleado(),dto.getPais(),dto.getDireccion(),dto.getEstadoLicencia());
			
			return this.builder.listToDto(resultado);
			
		} catch (Exception e) {
			throw e;
		}
	}

}
