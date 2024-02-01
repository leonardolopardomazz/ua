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
import ar.com.ua.dto.report.LicenciasDTO;
import ar.com.ua.dto.report.LicenciasResponseDTO;
import ar.com.ua.dto.response.ResponseDto;
import ar.com.ua.dto.response.ResponseOKListDto;
import ar.com.ua.service.report.LicenciasService;

@RequestMapping("/reporte/licencias")
@RestController
public class LicenciasController implements IReport<LicenciasDTO> {

	@Autowired
	private LicenciasService service;

	@Autowired
	private AccesoReporte accesoReporte;

	@Override
	public ResponseDto generar(LicenciasDTO dto) {
		List<LicenciasResponseDTO> licenciasDto = new ArrayList<>();

		try {
			// Chequeo de acceso al reporte
			boolean tieneAcceso = this.accesoReporte.deteminarAccesoAlRecurso(RolesConstant.ROL_REPORTES_RRHH);

			if (!tieneAcceso) {
				return ManejoErrores.errorGenerico(EndPointPathConstant.LICENCIAS, TipoMetodoConstant.POST,
						MensajeError.ACCESS_DENIED);
			}

			licenciasDto = this.service.generar(dto);

		} catch (Exception e) {
			ManejoErrores.errorGenerico(EndPointPathConstant.LICENCIAS, TipoMetodoConstant.POST, e.getMessage());
		}

		return new ResponseOKListDto<LicenciasResponseDTO>(EndPointPathConstant.LICENCIAS, TipoMetodoConstant.POST,
				CodigoRespuestaConstant.OK, licenciasDto);
	}
}
