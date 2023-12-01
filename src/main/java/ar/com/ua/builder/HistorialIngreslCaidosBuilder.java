package ar.com.ua.builder;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Component;

import ar.com.ua.dto.HistorialIngresoCaidosDTO;
import ar.com.ua.model.HistorialIngresoCaidos;

@Component
public class HistorialIngreslCaidosBuilder implements IBuilder<HistorialIngresoCaidos, HistorialIngresoCaidosDTO> {

	@Override
	public HistorialIngresoCaidos dtoToModel(HistorialIngresoCaidosDTO dto) {
		HistorialIngresoCaidos hic = new HistorialIngresoCaidos();
		hic.setId(dto.getId());
		hic.setApellido(dto.getApellido());
		hic.setCodigoDireccion(dto.getCodigoDireccion());
		hic.setCodigoGerencia(dto.getCodigoGerencia());
		hic.setCodigoJefatura(dto.getCodigoJefatura());
		hic.setCodigoPuesto(dto.getCodigoPuesto());
		hic.setCodigoTipoDocumento(dto.getCodigoTipoDocumento());
		hic.setFechaEgreso(dto.getFechaEgreso());
		hic.setFechaNacimiento(dto.getFechaNacimiento());
		hic.setNombre(dto.getNombre());
		hic.setNumeroDocumentoPersonal(dto.getNumeroDocumentoPersonal());
		hic.setObservaciones(dto.getObservaciones());
		hic.setActivo(dto.isActivo());
		
		return hic;
	}

	@Override
	public HistorialIngresoCaidosDTO modelToDto(HistorialIngresoCaidos model) {
		HistorialIngresoCaidosDTO hicDto = new HistorialIngresoCaidosDTO();
		hicDto.setId(model.getId());
		hicDto.setApellido(model.getApellido());
		hicDto.setCodigoDireccion(model.getCodigoDireccion());
		hicDto.setCodigoGerencia(model.getCodigoGerencia());
		hicDto.setCodigoJefatura(model.getCodigoJefatura());
		hicDto.setCodigoPuesto(model.getCodigoPuesto());
		hicDto.setCodigoTipoDocumento(model.getCodigoTipoDocumento());
		hicDto.setFechaEgreso(model.getFechaEgreso());
		hicDto.setFechaNacimiento(model.getFechaNacimiento());
		hicDto.setNombre(model.getNombre());
		hicDto.setNumeroDocumentoPersonal(model.getNumeroDocumentoPersonal());
		hicDto.setObservaciones(model.getObservaciones());
		hicDto.setActivo(model.isActivo());
		
		return hicDto;
	}

	@Override
	public List<HistorialIngresoCaidosDTO> modelListToDto(List<HistorialIngresoCaidos> list) {
		List<HistorialIngresoCaidosDTO> listHicDto = new ArrayList<>();
		
		for (HistorialIngresoCaidos hic : list) {
			HistorialIngresoCaidosDTO hicDto = new HistorialIngresoCaidosDTO();
			hicDto.setId(hic.getId());
			hicDto.setApellido(hic.getApellido());
			hicDto.setCodigoDireccion(hic.getCodigoDireccion());
			hicDto.setCodigoGerencia(hic.getCodigoGerencia());
			hicDto.setCodigoJefatura(hic.getCodigoJefatura());
			hicDto.setCodigoPuesto(hic.getCodigoPuesto());
			hicDto.setCodigoTipoDocumento(hic.getCodigoTipoDocumento());
			hicDto.setFechaEgreso(hic.getFechaEgreso());
			hicDto.setFechaNacimiento(hic.getFechaNacimiento());
			hicDto.setNombre(hic.getNombre());
			hicDto.setNumeroDocumentoPersonal(hic.getNumeroDocumentoPersonal());
			hicDto.setObservaciones(hic.getObservaciones());
			hicDto.setActivo(hic.isActivo());
			
			listHicDto.add(hicDto);
		}
		
		return listHicDto;
	}

}
