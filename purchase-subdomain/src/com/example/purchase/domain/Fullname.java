package com.example.purchase.domain;

import java.util.Objects;

public final class Fullname {
	private final String first;
	private final String last;

	private Fullname(String first, String last) {
		this.first = first;
		this.last = last;
	}

	public static Fullname of(String first, String last) {
		Objects.requireNonNull(first);
		Objects.requireNonNull(last);
		if (first.length() < 2 || last.length() < 2)
			throw new IllegalArgumentException("Fullname should have at least two characters");
		return new Fullname(first, last);
	}

	public String getFirst() {
		return first;
	}

	public String getLast() {
		return last;
	}

	@Override
	public String toString() {
		return "Fullname [first=" + first + ", last=" + last + "]";
	}
}
