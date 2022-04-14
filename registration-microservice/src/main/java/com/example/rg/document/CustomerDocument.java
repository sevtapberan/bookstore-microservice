package com.example.rg.document;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "employees")
public class CustomerDocument {
	
	@Id
	private String tcKimlikNo;
	@Field("full_name")
	private String fullName;
	private double salary;
	private int birthYear;
	private String userName;
	private String password;
	private boolean isAdmin;
	private String email;
	private String location;
	
	
	public CustomerDocument() {
		
	}
	public String getTcKimkikNo() {
		return tcKimlikNo;
	}
	public void setTcKimlikNo(String tcKimkikNo) {
		this.tcKimlikNo = tcKimkikNo;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
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
		CustomerDocument other = (CustomerDocument) obj;
		return Objects.equals(tcKimlikNo, other.tcKimlikNo);
	}
	@Override
	public String toString() {
		return "CustomerDocument [tcKimkikNo=" + tcKimlikNo + ", fullName=" + fullName + ", salary=" + salary
				+ ", birthYear=" + birthYear + ", userName=" + userName + ", password=" + password + ", isAdmin="
				+ isAdmin + ", email=" + email + ", location=" + location + "]";
	}
	
	
	
	
	

}
