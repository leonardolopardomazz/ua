package ar.com.ua.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import ar.com.ua.dto.response.ResponseDto;

/**
 * Interfase ABM Controller
 * 
 * @author Leonardo Lopardo
 *
 * @param <T>
 */
public interface IABMController<T> {
	/**
	 * Add <T>
	 * 
	 * @param dto
	 * @return See path in Interface
	 */
	@PostMapping(value = "")
	ResponseDto add(@RequestBody T dto);

	/**
	 * Modify <T>
	 * 
	 * @param dto * See path in Interface
	 * @return
	 */
	@PutMapping(value = "/{id}")
	ResponseDto modify(@PathVariable Long id, @RequestBody T dto);

	/**
	 * Delete <T> See path in Interface
	 */
	@DeleteMapping(value = "/{id}")
	ResponseDto deleteById(@PathVariable Long id);

}
