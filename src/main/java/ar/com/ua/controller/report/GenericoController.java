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
import ar.com.ua.constant.PermisosConstant;
import ar.com.ua.constant.TipoMetodoConstant;
import ar.com.ua.dto.report.GenericoDTO;
import ar.com.ua.dto.report.GenericoResponseDTO;
import ar.com.ua.dto.response.ResponseDto;
import ar.com.ua.dto.response.ResponseOKListDto;
import ar.com.ua.service.report.GenericoService;

@RequestMapping("/reporte/generico")
@RestController
public class GenericoController implements IReport<GenericoDTO> {

	@Autowired
	private GenericoService service;

	@Autowired
	private AccesoPermiso accesoPermiso;

	@Override
	public ResponseDto generar(GenericoDTO dto) {
		List<GenericoResponseDTO> extDto = new ArrayList<>();

		try {
			// Chequeo de acceso al reporte
			boolean tieneAcceso = this.accesoPermiso.deteminarAccesoAlRecurso(PermisosConstant.PERMISO_REPORTE_RRHH);

			if (!tieneAcceso) {
				return ManejoErrores.errorGenerico(EndPointPathConstant.GENERICO,
						TipoMetodoConstant.POST, MensajeError.ACCESS_DENIED);
			}

			extDto = this.service.generar(dto);

		} catch (Exception e) {
			return ManejoErrores.errorGenerico(EndPointPathConstant.GENERICO, TipoMetodoConstant.POST, e.getMessage());
		}

		return new ResponseOKListDto<GenericoResponseDTO>(EndPointPathConstant.GENERICO, TipoMetodoConstant.POST,
				CodigoRespuestaConstant.OK, extDto);
	}

}
