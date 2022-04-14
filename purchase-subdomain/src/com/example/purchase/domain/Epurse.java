package com.example.purchase.domain;

public class Epurse {
	private final double value;
	

	public Epurse(double value) {
		this.value = value;
	}
	
	public static Epurse of(double value) {
		if (value <= 0.0)
			throw new IllegalArgumentException("money value cannot be zero or negative");
		return new Epurse(value);
	}

	public double getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "Epurse [value=" + value + "]";
	}
	
	

}
