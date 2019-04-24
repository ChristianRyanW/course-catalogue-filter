package com.webservice.home;

import java.security.SecureRandom;

public class TokenGenerator {
	public static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	public static final int SECURE_TOKEN_LENGTH = 192;

	private static final SecureRandom random = new SecureRandom();

	private static final char[] symbols = CHARACTERS.toCharArray();

	private static final char[] buf = new char[SECURE_TOKEN_LENGTH];

	public static String nextToken() {
	    for (int idx = 0; idx < buf.length; ++idx)
	        buf[idx] = symbols[random.nextInt(symbols.length)];
	    return new String(buf);
	}
}
