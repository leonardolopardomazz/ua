package ar.com.ua.builder;

import java.util.List;

/**
 * M Model
 * D Dto
 * @author Leo
 *
 * @param <Model>
 * @param <Dto>
 */
public interface IBuilder <Model, Dto> {
	
	/**
	 * Dto to model
	 * @param dto
	 * @return
	 */
	public Model dtoToModel (Dto dto);
	
	/**
	 * Model to Dto
	 * @param model
	 * @return
	 */
	public Dto modelToDto (Model model);
	
	
	/**
	 * List<Model> to List <Dto>
	 * @param list
	 * @return
	 */
	public List<Dto> modelListToDto (List<Model> list);
	
}
