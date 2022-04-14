package com.example.registration.domain;

import java.util.Objects;


public final  class Epurse {
	
	private final String id;
	private final double value;


	

	
	
	

	public Epurse(String id, double value) {
		super();
		this.id = id;
		this.value = value;
	}


	public static Epurse of(String id,double value) {
	
		if (value <= 0.0)
			throw new IllegalArgumentException("money value cannot be zero or negative");
		return new Epurse(id,value);
		
	}
	

	public double getValue() {
		return value;
	}
	
	

	

	public String getId() {
		return id;
	}


	@Override
	public String toString() {
		return "Money [value=" + value + ", ]";
	}
	

}
