package ar.com.ua.controller.report;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ua.commons.ManejoErrores;
import ar.com.ua.constant.CodigoRespuestaConstant;
import ar.com.ua.constant.EndPointPathConstant;
import ar.com.ua.constant.MensajeError;
import ar.com.ua.constant.RolesConstant;
import ar.com.ua.constant.TipoMetodoConstant;
import ar.com.ua.dto.report.VueltaAlColegioDTO;
import ar.com.ua.dto.report.VueltaAlColegioResponseDTO;
import ar.com.ua.dto.response.ResponseDto;
import ar.com.ua.dto.response.ResponseOKListDto;
import ar.com.ua.service.report.VueltaAlColegioService;

@RequestMapping("/reporte/vueltaalcolegio")
@RestController
public class VueltaAlColegioController implements IReport<VueltaAlColegioDTO> {

	@Autowired
	private VueltaAlColegioService reporteService;

	@Autowired
	private AccesoReporte accesoReporte;

	@Override
	public ResponseDto generar(@RequestBody VueltaAlColegioDTO dto) {
		List<VueltaAlColegioResponseDTO> vacDto = new ArrayList<>();

		try {
			// Chequeo de acceso al reporte
			boolean tieneAcceso = this.accesoReporte.deteminarAccesoAlRecurso(RolesConstant.ROL_REPORTES_RRHH);

			if (!tieneAcceso) {
				return ManejoErrores.errorGenerico(EndPointPathConstant.REPORTE_VUELTA_AL_COLEGIO,
						TipoMetodoConstant.POST, MensajeError.ACCESS_DENIED);
			}

			vacDto = this.reporteService.generar(dto);

		} catch (Exception e) {
			return ManejoErrores.errorGenerico(EndPointPathConstant.REPORTE_VUELTA_AL_COLEGIO, TipoMetodoConstant.POST,
					e.getMessage());
		}

		return new ResponseOKListDto<VueltaAlColegioResponseDTO>(EndPointPathConstant.REPORTE_VUELTA_AL_COLEGIO,
				TipoMetodoConstant.POST, CodigoRespuestaConstant.OK, vacDto);
	}

}
