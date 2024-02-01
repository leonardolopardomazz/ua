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
import ar.com.ua.dto.report.CentroDeCostoDTO;
import ar.com.ua.dto.report.CentroDeCostoResponseDTO;
import ar.com.ua.dto.response.ResponseDto;
import ar.com.ua.dto.response.ResponseOKListDto;
import ar.com.ua.service.report.CentroDeCostoService;

@RequestMapping("/reporte/centrodecosto")
@RestController
public class CentroDeCostoController implements IReport<CentroDeCostoDTO> {

	@Autowired
	private CentroDeCostoService cdcService;

	@Autowired
	private AccesoReporte accesoReporte;

	@Override
	public ResponseDto generar(CentroDeCostoDTO dto) {
		List<CentroDeCostoResponseDTO> cdcDto = new ArrayList<>();
		try {
			// Chequeo de acceso al reporte
			boolean tieneAcceso = this.accesoReporte.deteminarAccesoAlRecurso(RolesConstant.ROL_REPORTES_RRHH);

			if (!tieneAcceso) {
				return ManejoErrores.errorGenerico(EndPointPathConstant.CENTRO_DE_COSTOS, TipoMetodoConstant.POST,
						MensajeError.ACCESS_DENIED);
			}

			cdcDto = this.cdcService.generar(dto);

		} catch (Exception e) {
			ManejoErrores.errorGenerico(EndPointPathConstant.CENTRO_DE_COSTOS, TipoMetodoConstant.POST, e.getMessage());
		}

		return new ResponseOKListDto<CentroDeCostoResponseDTO>(EndPointPathConstant.REPORTE_CENTRO_DE_COSTO,
				TipoMetodoConstant.POST, CodigoRespuestaConstant.OK, cdcDto);
	}
}
