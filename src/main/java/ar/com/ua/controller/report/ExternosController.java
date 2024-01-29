package ar.com.ua.controller.report;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ua.commons.ManejoErrores;
import ar.com.ua.constant.CodigoRespuestaConstant;
import ar.com.ua.constant.EndPointPathConstant;
import ar.com.ua.constant.MensajeError;
import ar.com.ua.constant.RolesConstant;
import ar.com.ua.constant.TipoMetodoConstant;
import ar.com.ua.dto.report.ExternosDTO;
import ar.com.ua.dto.report.ExternosResponseDTO;
import ar.com.ua.dto.response.ResponseDto;
import ar.com.ua.dto.response.ResponseOKListDto;
import ar.com.ua.service.report.ExternosService;

@RequestMapping("/reporte/externos")
@RestController
public class ExternosController implements IReport<ExternosDTO> {

	@Autowired
	private ExternosService extService;

	@Autowired
	private AccesoReporte accesoReporte;

	@Override
	public ResponseDto generar(ExternosDTO dto) {
		List<ExternosResponseDTO> extDto = new ArrayList<>();

		try {
			// Chequeo de acceso al reporte
			boolean tieneAcceso = this.accesoReporte.deteminarAccesoAlRecurso(
					EndPointPathConstant.REPORTE_VUELTA_AL_COLEGIO, TipoMetodoConstant.POST, RolesConstant.ROL_REPORTES_RRHH);

			if (!tieneAcceso) {
				return ManejoErrores.errorGenerico(EndPointPathConstant.EXTERNOS,
						TipoMetodoConstant.POST, MensajeError.ACCESS_DENIED);
			}

			extDto = this.extService.generar(dto);

		} catch (Exception e) {
			ManejoErrores.errorGenerico(EndPointPathConstant.EXTERNOS, TipoMetodoConstant.POST, e.getMessage());
		}

		return new ResponseOKListDto<ExternosResponseDTO>(EndPointPathConstant.EXTERNOS, TipoMetodoConstant.POST,
				CodigoRespuestaConstant.OK, extDto);
	}
}
