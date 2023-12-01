package ar.com.ua.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.com.ua.dto.HistorialPuestosDTO;
import ar.com.ua.model.HistorialPuestos;

@Component
public class HistorialPuestosBuilder implements IBuilder<HistorialPuestos, HistorialPuestosDTO> {

	@Override
	public HistorialPuestos dtoToModel(HistorialPuestosDTO dto) {
		HistorialPuestos hp = new HistorialPuestos();
		hp.setId(dto.getId());
		hp.setCodigoDireccion(dto.getCodigoDireccion());
		hp.setCodigoGerencia(dto.getCodigoGerencia());
		hp.setCodigoJefatura(dto.getCodigoJefatura());
		hp.setCodigoOficina(dto.getCodigoOficina());
		hp.setCodigoPais(dto.getCodigoPais());
		hp.setCodigoPuesto(dto.getCodigoPuesto());
		hp.setFechaEgreso(dto.getFechaEgreso());
		hp.setFechaIngresoReconocida(dto.getFechaIngresoReconocida());
		hp.setNumeroLegajo(dto.getNumeroLegajo());
		hp.setActivo(dto.isActivo());

		return hp;
	}

	@Override
	public HistorialPuestosDTO modelToDto(HistorialPuestos model) {
		HistorialPuestosDTO hpDto = new HistorialPuestosDTO();
		hpDto.setId(model.getId());
		hpDto.setCodigoDireccion(model.getCodigoDireccion());
		hpDto.setCodigoGerencia(model.getCodigoGerencia());
		hpDto.setCodigoJefatura(model.getCodigoJefatura());
		hpDto.setCodigoOficina(model.getCodigoOficina());
		hpDto.setCodigoPais(model.getCodigoPais());
		hpDto.setCodigoPuesto(model.getCodigoPuesto());
		hpDto.setFechaEgreso(model.getFechaEgreso());
		hpDto.setFechaIngresoReconocida(model.getFechaIngresoReconocida());
		hpDto.setNumeroLegajo(model.getNumeroLegajo());
		hpDto.setActivo(model.isActivo());
		
		return hpDto;
	}

	@Override
	public List<HistorialPuestosDTO> modelListToDto(List<HistorialPuestos> list) {
		List<HistorialPuestosDTO> listDto = new ArrayList<>();
		
		for (HistorialPuestos hp : list) {
			HistorialPuestosDTO hpDto = new HistorialPuestosDTO();
			hpDto.setId(hp.getId());
			hpDto.setCodigoDireccion(hp.getCodigoDireccion());
			hpDto.setCodigoGerencia(hp.getCodigoGerencia());
			hpDto.setCodigoJefatura(hp.getCodigoJefatura());
			hpDto.setCodigoOficina(hp.getCodigoOficina());
			hpDto.setCodigoPais(hp.getCodigoPais());
			hpDto.setCodigoPuesto(hp.getCodigoPuesto());
			hpDto.setFechaEgreso(hp.getFechaEgreso());
			hpDto.setFechaIngresoReconocida(hp.getFechaIngresoReconocida());
			hpDto.setNumeroLegajo(hp.getNumeroLegajo());
			hpDto.setActivo(hp.isActivo());
			
			listDto.add(hpDto);
		}
		
		return listDto;
	}

}
