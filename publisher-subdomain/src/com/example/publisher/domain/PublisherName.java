package com.example.publisher.domain;

import java.util.Objects;

public final class PublisherName {
	
	private final String name;

	public PublisherName(String name) {
		this.name = name;
	}

	public static PublisherName of(String name) {
		Objects.requireNonNull(name);
		if (name.length() < 2) 
			throw new IllegalArgumentException("Publisher name should have at least two characters ");
		return new PublisherName(name);
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "PublisherName [name=" + name + "]";
	}
	
	
}
