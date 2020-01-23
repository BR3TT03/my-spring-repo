package com.famas.demo.Utility;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtility {
	private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	public static String  encryptPassword(String rawPassword) {
			return encoder.encode(rawPassword);
	}
}
