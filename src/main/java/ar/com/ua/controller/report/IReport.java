package ar.com.ua.controller.report;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import ar.com.ua.dto.response.ResponseDto;

public interface IReport<T> {
	
	@PostMapping(value = "/generar")
	ResponseDto generar (@RequestBody T dto); 

}
