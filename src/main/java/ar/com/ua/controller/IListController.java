package ar.com.ua.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
	@GetMapping(value = "/findOne")
	ResponseDto findOne (@RequestBody Dto dto);
	
	/**
	 * FindAny  <Dto>
	 * @param dto
	 * @return
	 */
	@GetMapping(value = "/findAny")
	ResponseDto findAny (@RequestBody Dto dto);

	/**
	 * FindAll <Dto>
	 * @return
	 */
	@GetMapping(value = "/findAll")
	ResponseDto findAll ();
}
