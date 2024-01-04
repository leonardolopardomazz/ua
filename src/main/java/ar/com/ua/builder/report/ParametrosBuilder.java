package ar.com.ua.builder.report;

public class ParametrosBuilder {
	
	public Integer integerToString(String id) {

		if (CommonsValidator.isNotNull(id)) {
			return Integer.getInteger(id);
		}
		return null;
	}

}
