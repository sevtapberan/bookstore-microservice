package com.example.rg.dto.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.example.validation.TcKimlikNo;

public class CreateCustomerRequest {
	
	@TcKimlikNo
	private String tcKimlikNo;
	@NotBlank
	private String fullName;
	@NotBlank
	private String userName;
	@NotBlank
	private String password;
	@NotBlank
	private String email;
	
	@Min(4250)
	private double salary;
	@Max(2004)
	private int birthYear;
	private String photo;
	
	
	public CreateCustomerRequest() {
		
	}


	public String getTcKimlikNo() {
		return tcKimlikNo;
	}


	public void setTcKimlikNo(String tcKimlikNo) {
		this.tcKimlikNo = tcKimlikNo;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
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


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	@Override
	public String toString() {
		return "CreateCustomerRequest [tcKimlikNo=" + tcKimlikNo + ", fullName=" + fullName + ", userName=" + userName
				+ ", password=" + password + ", email=" + email + ", salary=" + salary + ", birthYear=" + birthYear
				+ ", photo=" + photo + "]";
	}


	
	
	
	
	
	
	
	
	
	
	
	
	

}
