package ar.com.ua.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import ar.com.ua.dto.response.ResponseDto;

/**
 * Interfase para listados
 * @author Leo
 *
 * @param <T>
 */
public interface IListController<T> {
	/**
	 * FindOne <T>
	 * @param dto
	 * @return
	 */
	@PostMapping(value = "/findOne")
	ResponseDto findOne (@RequestBody T dto);
	
	/**
	 * FindAny  <T>
	 * @param dto
	 * @return
	 */
	@PostMapping(value = "/findAny")
	ResponseDto findAny (@RequestBody T dto);

	/**
	 * FindAll <T>
	 * @return
	 */
	@PostMapping(value = "/findAll")
	ResponseDto findAll ();
}
