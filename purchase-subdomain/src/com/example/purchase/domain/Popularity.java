package com.example.purchase.domain;

public final class Popularity {
	private final int value;

	private Popularity(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public static Popularity of(int value) {
		if (!isValid(value)) {
			throw new IllegalArgumentException("This is not a valid popularity");
		}
		return new Popularity(value);
	}

	private static boolean isValid(int value) {
		if (value < 0)
			return false;
		return true;
	}
}
