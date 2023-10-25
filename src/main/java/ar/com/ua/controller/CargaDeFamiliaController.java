package ar.com.ua.controller;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.ua.dto.CargaDeFamiliaDTO;
import ar.com.ua.dto.response.ResponseDto;
import ar.com.ua.service.CargaDeFamiliaService;

public class CargaDeFamiliaController implements IABMController<CargaDeFamiliaDTO> {

	@Autowired
	private CargaDeFamiliaService cdfService;
	
	@Override
	public ResponseDto add(CargaDeFamiliaDTO dto) {
		cdfService.save(null);
		return null;
	}

	@Override
	public ResponseDto modify(CargaDeFamiliaDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseDto deleteById(CargaDeFamiliaDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
