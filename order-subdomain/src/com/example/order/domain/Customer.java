package com.example.order.domain;

import java.util.Objects;

public class Customer {

	private String tcKimlikNo;
	private String fullname;
	private int age;
	private String location;
	private String interests;
	private String email;
	private double epurse;
	private String username;
	private String password;
	private String isAdmin;

	public Customer() {

	}

	public String getTcKimlikNo() {
		return tcKimlikNo;
	}

	public void setTcKimlikNo(String tcKimlikNo) {
		this.tcKimlikNo = tcKimlikNo;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getInterests() {
		return interests;
	}

	public void setInterests(String interests) {
		this.interests = interests;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getEpurse() {
		return epurse;
	}

	public void setEpurse(double epurse) {
		this.epurse = epurse;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public int hashCode() {
		return Objects.hash(tcKimlikNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(tcKimlikNo, other.tcKimlikNo);
	}

	@Override
	public String toString() {
		return "Customer [tcKimlikNo=" + tcKimlikNo + ", fullname=" + fullname + ", age=" + age + ", location="
				+ location + ", interests=" + interests + ", email=" + email + ", epurse=" + epurse + ", username="
				+ username + ", password=" + password + ", isAdmin=" + isAdmin + "]";
	}

	public static Customer of(String value) {
		if (!isValid(value)) {
			throw new IllegalArgumentException("This is not a valid Customer...");
		}
		return null;
	}

	private static boolean isValid(String value) {

		return true;
	}

}
