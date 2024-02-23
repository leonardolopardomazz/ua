package ar.com.ua.utils;

import java.util.Base64;

public class PasswordEncrypt {

	public static String encrypt(String originalString) throws Exception {
		String encryptedString = "";

		try {
			encryptedString = Base64.getEncoder().encodeToString(originalString.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return encryptedString;
	}

}
