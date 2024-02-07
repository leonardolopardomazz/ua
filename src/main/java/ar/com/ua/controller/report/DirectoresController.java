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
import ar.com.ua.dto.report.DirectoresDTO;
import ar.com.ua.dto.report.DirectoresResponseDTO;
import ar.com.ua.dto.response.ResponseDto;
import ar.com.ua.dto.response.ResponseOKListDto;
import ar.com.ua.service.report.DirectoresService;

@RequestMapping("/reporte/directores")
@RestController
public class DirectoresController implements IReport<DirectoresDTO> {

	@Autowired
	private DirectoresService directoresService;

	@Autowired
	private AccesoPermiso accesoPermiso;

	@Override
	public ResponseDto generar(DirectoresDTO dto) {
		List<DirectoresResponseDTO> directoresDto = new ArrayList<>();

		try {
			// Chequeo de acceso al reporte
			boolean tieneAcceso = this.accesoPermiso
					.deteminarAccesoAlRecurso(PermisosConstant.PERMISO_REPORTE_DIRECTORES);

			if (!tieneAcceso) {
				return ManejoErrores.errorGenerico(EndPointPathConstant.REPORTE_VUELTA_AL_COLEGIO,
						TipoMetodoConstant.POST, MensajeError.ACCESS_DENIED);
			}

			directoresDto = this.directoresService.generar(dto);

		} catch (Exception e) {
			return ManejoErrores.errorGenerico(EndPointPathConstant.DIRECTORES, TipoMetodoConstant.POST,
					e.getMessage());
		}

		return new ResponseOKListDto<DirectoresResponseDTO>(EndPointPathConstant.DIRECTORES, TipoMetodoConstant.POST,
				CodigoRespuestaConstant.OK, directoresDto);
	}
}
