package com.example.purchase.domain;

public final class Title {
	private final String value;

	private Title(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static Title of(String value) {
		if (!isValid(value)) {
			throw new IllegalArgumentException("This is not a valid title");
		}
		return new Title(value);
	}

	private static boolean isValid(String value2) {

		return true;
	}

	@Override
	public String toString() {
		return "Title [value=" + value + "]";
	}

}
