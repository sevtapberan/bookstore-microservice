package com.example.bookcatalog.domain;

public final class Review {
	private final String value;

	private Review(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static Review of(String value) {
		if (!isValid(value)) {
			throw new IllegalArgumentException("This is not a valid review..");
		}
		return new Review(value);
	}

	private static boolean isValid(String value) {

		return true;
	}

	@Override
	public String toString() {
		return "Review [value=" + value + "]";
	}

}
