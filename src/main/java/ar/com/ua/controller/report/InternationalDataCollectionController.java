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
import ar.com.ua.dto.report.InternationalDataCollectionDTO;
import ar.com.ua.dto.report.InternationalDataCollectionResponseDTO;
import ar.com.ua.dto.response.ResponseDto;
import ar.com.ua.dto.response.ResponseOKListDto;
import ar.com.ua.service.report.InternationalDataCollectionService;

@RequestMapping("/reporte/idc")
@RestController
public class InternationalDataCollectionController implements IReport<InternationalDataCollectionDTO> {

	@Autowired
	private InternationalDataCollectionService service;

	@Autowired
	private AccesoReporte accesoReporte;

	@Override
	public ResponseDto generar(InternationalDataCollectionDTO dto) {
		List<InternationalDataCollectionResponseDTO> idcDto = new ArrayList<>();

		try {
			// Chequeo de acceso al reporte
			boolean tieneAcceso = this.accesoReporte.deteminarAccesoAlRecurso(
					EndPointPathConstant.REPORTE_VUELTA_AL_COLEGIO, TipoMetodoConstant.POST, RolesConstant.ROL_REPORTES_RRHH);

			if (!tieneAcceso) {
				return ManejoErrores.errorGenerico(EndPointPathConstant.INTERNATIONAL_DATA_COLLECTION,
						TipoMetodoConstant.POST, MensajeError.ACCESS_DENIED);
			}

			idcDto = this.service.generar(dto);

		} catch (Exception e) {
			ManejoErrores.errorGenerico(EndPointPathConstant.INTERNATIONAL_DATA_COLLECTION, TipoMetodoConstant.POST, e.getMessage());
		}

		return new ResponseOKListDto<InternationalDataCollectionResponseDTO>(
				EndPointPathConstant.INTERNATIONAL_DATA_COLLECTION, TipoMetodoConstant.POST, CodigoRespuestaConstant.OK,
				idcDto);
	}
}
