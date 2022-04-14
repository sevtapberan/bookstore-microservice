package com.example.stock.domain;

public final class Basket {
	
	private final int value;

	public Basket(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "Basket [value=" + value + "]";
	}
	
	public static Basket of(int value) {
		return Basket.of(value);
		
	}
	
	
	
	

}
