package com.example.purchase.domain;

public final class Photo {
	private final String value;

	private Photo(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static Photo of(String value) {
		if (!isValid(value)) {
			throw new IllegalArgumentException("This is not a valid photo..");
		}
		return new Photo(value);
	}

	private static boolean isValid(String value) {

		return true;
	}

	@Override
	public String toString() {
		return "Photo [value=" + value + "]";
	}
}
