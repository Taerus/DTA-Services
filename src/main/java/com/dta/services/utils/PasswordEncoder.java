package com.dta.services.utils;

import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoder extends MessageDigestPasswordEncoder {

	public PasswordEncoder() {
		super("md5");		
	}

}
