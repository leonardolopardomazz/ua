package ar.com.ua.builder.report;

import java.util.ArrayList;
import java.util.List;

public class CommonsBuilder {

	public static List<String> arrayToList(String[] queryResult) {
		List<String> parserResult = new ArrayList<>();
		for (String result : queryResult) {
			parserResult.add(result);
		}
		return parserResult;
	}

}
