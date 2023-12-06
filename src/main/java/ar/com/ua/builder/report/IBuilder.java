package ar.com.ua.builder.report;

/**
 * 
 * @author Leonardo Lopardo
 *
 * @param <Map>
 * @param <Dto>
 */
public interface IBuilder<Map, Dto> {
	/**
	 * 
	 * @param map
	 * @return
	 */
	public Dto mapToDto(Map map);

}
