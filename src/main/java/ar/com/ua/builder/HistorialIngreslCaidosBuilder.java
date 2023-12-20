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
		hic.setEmpleado(dto.getEmpleado());
		hic.setMotivo(dto.getMotivo());
		hic.setObservaciones(dto.getObservaciones());
		hic.setActivo(dto.isActivo());
		
		return hic;
	}

	@Override
	public HistorialIngresoCaidosDTO modelToDto(HistorialIngresoCaidos model) {
		HistorialIngresoCaidosDTO hicDto = new HistorialIngresoCaidosDTO();
		hicDto.setId(model.getId());
		hicDto.setEmpleado(model.getEmpleado());
		hicDto.setMotivo(model.getMotivo());
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
			hicDto.setEmpleado(hic.getEmpleado());
			hicDto.setMotivo(hic.getMotivo());
			hicDto.setObservaciones(hic.getObservaciones());
			hicDto.setActivo(hic.isActivo());
			
			listHicDto.add(hicDto);
		}
		
		return listHicDto;
	}

}
