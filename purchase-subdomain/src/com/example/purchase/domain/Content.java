package com.example.purchase.domain;

public final class Content {
	private final String value;

	private Content(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static Content of(String value) {
		if (!isValid(value)) {
			throw new IllegalArgumentException("This is not a valid content..");
		}
		return new Content(value);
	}

	private static boolean isValid(String value) {

		return true;
	}

	@Override
	public String toString() {
		return "Content [value=" + value + "]";
	}
}
