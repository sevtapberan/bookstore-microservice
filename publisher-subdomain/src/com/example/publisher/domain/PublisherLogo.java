package com.example.publisher.domain;

import java.util.Base64;
import java.util.Objects;

public final class PublisherLogo {
	private final byte[] values;

	public PublisherLogo(byte[] values) {
		this.values = values;
	}
	
	public static PublisherLogo valueOf(byte[] values) {
		Objects.requireNonNull(values);
		return new PublisherLogo(values);
	}
	
	public static PublisherLogo valueOf(String values) {
		Objects.requireNonNull(values);
		return new PublisherLogo(Base64.getDecoder().decode(values));
	}

	public byte[] getValues() {
		return values;
	}
	
	public String getBase64Values() {
		return String.valueOf(Base64.getEncoder().encode(values));
	}
	

}
