package com.example.purchase.domain;

public final class Author {
	private final String value;

	private Author(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static Author of(String value) {
		if (!isValid(value)) {
			throw new IllegalArgumentException("This is not a valid author");
		}
		return new Author(value);
	}

	private static boolean isValid(String value2) {

		return true;
	}

	@Override
	public String toString() {
		return "Author [value=" + value + "]";
	}

}
