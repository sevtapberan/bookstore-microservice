package com.example.registration.domain;



public final  class BirthYear {
	
	private final int value;

	private BirthYear(int value) {
		this.value = value;
	}

	public static BirthYear of(int value) {
		return new BirthYear(value);
	}

	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "BirthYear [value=" + value + "]";
	}

	

}
