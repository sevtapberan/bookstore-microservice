package com.example.publisher.domain;

import java.util.Objects;

public final class RequisitionId {
	private final String value;

	public RequisitionId(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
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
		RequisitionId other = (RequisitionId) obj;
		return Objects.equals(value, other.value);
	}

	@Override
	public String toString() {
		return "RequisitionId [value=" + value + "]";
	}
	
	

}
