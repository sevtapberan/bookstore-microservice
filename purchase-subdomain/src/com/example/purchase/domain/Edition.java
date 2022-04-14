package com.example.purchase.domain;

public final class Edition {
	private final int value;

	private Edition(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public static Edition of(int value) {
		if (!isValid(value)) {
			throw new IllegalArgumentException("This is not a valid edition");
		}
		return new Edition(value);
	}

	private static boolean isValid(int value) {
		if (value <= 0)
			return false;
		return false;
	}

	@Override
	public String toString() {
		return "Edition [value=" + value + "]";
	}

}
