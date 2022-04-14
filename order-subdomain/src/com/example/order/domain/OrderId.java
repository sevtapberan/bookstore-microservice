package com.example.order.domain;

import java.util.Objects;

public class OrderId {
	private final String value;

	public OrderId(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static OrderId of(String value) {
		return new OrderId(value);
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
		OrderId other = (OrderId) obj;
		return Objects.equals(value, other.value);
	}

	@Override
	public String toString() {
		return "OrderId [value=" + value + "]";
	}
}
