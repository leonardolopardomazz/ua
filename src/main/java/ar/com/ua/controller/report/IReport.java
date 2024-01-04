package ar.com.ua.controller.report;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.com.ua.dto.response.ResponseDto;

public interface IReport {
	
	@GetMapping(value = "/generar")
	ResponseDto generarReporte (@RequestParam Map<String,String> params); 

}
