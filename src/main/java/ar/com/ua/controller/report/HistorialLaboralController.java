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
import ar.com.ua.dto.report.HistorialLaboralDTO;
import ar.com.ua.dto.report.HistorialLaboralResponseDTO;
import ar.com.ua.dto.response.ResponseDto;
import ar.com.ua.dto.response.ResponseOKListDto;
import ar.com.ua.service.report.HistorialLaboralService;

@RequestMapping("/reporte/historiallaboral")
@RestController
public class HistorialLaboralController implements IReport<HistorialLaboralDTO> {

	@Autowired
	private HistorialLaboralService hlService;

	@Autowired
	private AccesoReporte accesoReporte;

	@Override
	public ResponseDto generar(HistorialLaboralDTO dto) {

		List<HistorialLaboralResponseDTO> hlDto = new ArrayList<>();

		try {
			// Chequeo de acceso al reporte
			boolean tieneAcceso = this.accesoReporte.deteminarAccesoAlRecurso(
					RolesConstant.ROL_REPORTES_RRHH);

			if (!tieneAcceso) {
				return ManejoErrores.errorGenerico(EndPointPathConstant.HISTORIAL_LABORAL,
						TipoMetodoConstant.POST, MensajeError.ACCESS_DENIED);
			}

			hlDto = this.hlService.generar(dto);

		} catch (Exception e) {
			ManejoErrores.errorGenerico(EndPointPathConstant.HISTORIAL_LABORAL, TipoMetodoConstant.POST, e.getMessage());
		}
		return new ResponseOKListDto<HistorialLaboralResponseDTO>(EndPointPathConstant.HISTORIAL_LABORAL,
				TipoMetodoConstant.GET, CodigoRespuestaConstant.OK, hlDto);
	}
}
