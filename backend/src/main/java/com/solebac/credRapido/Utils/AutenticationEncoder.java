package com.solebac.credRapido.Utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public final class AutenticationEncoder {
	private AutenticationEncoder() {
		throw new AssertionError();
	}
	public final static String passwordBCrypt(String arg0) {
		return new BCryptPasswordEncoder().encode(arg0);
	}
}
