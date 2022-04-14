package com.example.bookcatalog.domain;

import java.util.Calendar;

public final class PublicationYear {
	private final int value;

	private PublicationYear(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public static PublicationYear of(int value) {
		if (!isValid(value)) {
			throw new IllegalArgumentException("This is not a valid publication year");
		}
		return new PublicationYear(value);
	}

	
	private static boolean isValid(int value) {
		if(value < 1800 && value > Calendar.getInstance().get(Calendar.YEAR)) return false;
		return true;
	}
}
