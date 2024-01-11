package ar.com.ua.service.report;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.ua.builder.report.ExternosBuilder;
import ar.com.ua.dto.report.ExternosDTO;
import ar.com.ua.dto.report.ExternosResponseDTO;
import ar.com.ua.repository.report.ExternosRepository;

@Component
public class ExternosService {

	@Autowired
	private ExternosBuilder extBuilder;

	@Autowired
	private ExternosRepository extRepository;

	public List<ExternosResponseDTO> generarReporte(ExternosDTO extDto) {

		List<String> resultado = this.extRepository.reporte(extDto.getCodigoTipoDocumento(), extDto.getCodigoPais(),
				extDto.getCodigoProveedor(), extDto.getCodigoPuesto(), extDto.getCodigoJefatura(),
				extDto.getCodigoDivision(), extDto.getCodigoDireccion(), extDto.getCodigoGerencia(),
				extDto.getCodigoGenero(), extDto.getActivo());

		return this.extBuilder.listToDto(resultado);
	}

}
