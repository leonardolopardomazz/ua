package ar.com.ua.controller;

import org.springframework.web.bind.annotation.PostMapping;
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
	@PostMapping(value = "/findOne")
	ResponseDto findOne (@RequestBody Dto dto);
	
	/**
	 * FindAny  <Dto>
	 * @param dto
	 * @return
	 */
	@PostMapping(value = "/findAny")
	ResponseDto findAny (@RequestBody Dto dto);

	/**
	 * FindAll <Dto>
	 * @return
	 */
	@PostMapping(value = "/findAll")
	ResponseDto findAll ();
}
