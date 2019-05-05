package com.webservice.home;

import java.time.ZonedDateTime;
import java.util.Date;

import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.NewCookie;

public class CookieGenerator {
	public static NewCookie createDomainCookie(String name, String value, int maxAgeInMinutes) {
	    ZonedDateTime time = ZonedDateTime.now().plusMinutes(maxAgeInMinutes);
	    Date expiry = Date.from(time.toInstant());
	    NewCookie newCookie = new NewCookie(name, value, "/", null, Cookie.DEFAULT_VERSION,null, maxAgeInMinutes, expiry, false, false);
	    return newCookie;
	}
}