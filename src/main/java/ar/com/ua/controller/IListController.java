package ar.com.ua.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import ar.com.ua.dto.response.ResponseDto;

/**
 * Interfase para listados
 * @author Leonardo Lopardo
 *
 * @param <Dto>
 */
public interface IListController<Dto> {
	/**
	 * FindOne <Dto>
	 * @param dto
	 * @return
	 */
	@GetMapping(value = "/{id}")
	ResponseDto findOne (@PathVariable Long id);
	
	/**
	 * FindAny  <Dto>
	 * @param dto
	 * @return
	 */
	@GetMapping(value = "/buscar")
	ResponseDto findAny (@RequestParam Map<String,String> params);
	
	/**
	 * FindAll <Dto>
	 * @return
	 */
	@GetMapping(value = "")
	ResponseDto findAll ();
}
