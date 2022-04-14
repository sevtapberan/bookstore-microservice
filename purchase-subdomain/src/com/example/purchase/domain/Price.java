package com.example.purchase.domain;

public final class Price {
	private final double value;

	private Price(double value) {
		this.value = value;
	}

	public double getValue() {
		return value;
	}

	public static Price of(double value) {
		if (!isValid()) {
			throw new IllegalArgumentException("This is not a valid price");
		}
		return new Price(value);
	}

	private static boolean isValid() {

		return true;
	}

	@Override
	public String toString() {
		return "Price [value=" + value + "]";
	}

}
