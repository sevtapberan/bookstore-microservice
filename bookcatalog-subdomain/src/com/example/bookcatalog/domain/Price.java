package com.example.bookcatalog.domain;

public final class Price {
	private final double value;

	private Price(double value) {
		this.value = value;
	}

	public double getValue() {
		return value;
	}

	public static Price of(double value) {
		if (!isValid(value)) {
			throw new IllegalArgumentException("This is not a valid price");
		}
		return new Price(value);
	}

	private static boolean isValid(double value) {
		if(value < 1) return false;
		return true;
	}

	@Override
	public String toString() {
		return "Price [value=" + value + "]";
	}

}
