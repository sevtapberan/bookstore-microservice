package com.example.bookcatalog.domain;

public final class Author {
	private final String value;

	private Author(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static Author of(String value) {
		if (isValid(value)) {
			throw new IllegalArgumentException("This is not a valid author");
		}
		return new Author(value);
	}

	private static boolean isValid(String value) {
		for (int i = 0; i < value.length(); i++) {
			if (Character.isDigit(value.charAt(i)))
				return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Author [value=" + value + "]";
	}

}
