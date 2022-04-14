package com.example.bookcatalog.domain;

import java.util.Objects;

public final class ISBN {
	private final String value;

	private ISBN(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static ISBN of(String value) {
		if (!isValid(value)) {
			throw new IllegalArgumentException("This is not a valid isbn");
		}
		return new ISBN(value);
	}

	private static boolean isValid(String value) {

		var isbn = value.toCharArray();
		var sum = 0;
		if (isbn.length == 10) {
			for (var i = 0; i < 10; i++) {
				sum += i * isbn[i];
			}
			if (isbn[9] == sum % 11)
				return true;
		} else if (isbn.length == 13) {
			for (var i = 0; i < 12; i++) {
				if (i % 2 == 0) {
					sum += isbn[i];
				} else {
					sum += isbn[i] * 3;
				}
			}

			if (isbn[12] == 10 - (sum % 10))
				return true;
		}
		return false;

	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ISBN other = (ISBN) obj;
		return Objects.equals(value, other.value);
	}

	@Override
	public String toString() {
		return "ISBN [value=" + value + "]";
	}

}
