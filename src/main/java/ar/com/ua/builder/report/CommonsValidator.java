package ar.com.ua.builder.report;

public class CommonsValidator {

	public static boolean isNotNull(String field) {
		if (field != null) {
			return true;
		}
		return false;
	}
	
	public static boolean isNotNull(Integer field) {
		if (field != null) {
			return true;
		}
		return false;
	}

}
