package ar.com.ua.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
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
	@PostMapping(value = "/add")
	ResponseDto add(@RequestBody T dto);

	/**
	 * Modify <T>
	 * 
	 * @param dto * See path in Interface
	 * @return
	 */
	@PutMapping(value = "/modify")
	ResponseDto modify(@RequestBody T dto);

	/**
	 * Delete <T> See path in Interface
	 */
	@DeleteMapping(value = "/delete")
	ResponseDto deleteById(@RequestBody T dto);

}
