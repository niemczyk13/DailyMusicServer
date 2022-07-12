package com.arkadiuszniemiec.dailymusic.web.util;

import com.arkadiuszniemiec.dailymusic.web.exception.MyResourceNotFoundException;

public final class RestPreconditions {
	
	private RestPreconditions() {
		throw new AssertionError();
	}
	
	public static <T> T checkFound(T resource) {
		if (resource == null) {
			System.out.println("JESTEM TU!");
			throw new MyResourceNotFoundException("NIE ZNALEZIONO DANEGO OBIEKTU!!!**************");
		}

		return resource;
	}
}
