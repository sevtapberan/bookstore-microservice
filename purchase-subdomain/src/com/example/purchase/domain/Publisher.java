package com.example.purchase.domain;

public final class Publisher {
	private final String value;

	private Publisher(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static Publisher of(String value) {
		if (!isValid(value)) {
			throw new IllegalArgumentException("This is not a valid publisher");
		}
		return new Publisher(value);
	}

	private static boolean isValid(String value2) {
		return true;
	}

	@Override
	public String toString() {
		return "Publisher [value=" + value + "]";
	}

}
