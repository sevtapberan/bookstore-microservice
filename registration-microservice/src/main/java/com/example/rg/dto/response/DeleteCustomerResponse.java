package com.example.rg.dto.response;

public class DeleteCustomerResponse {
	
	
	private String tcKimlikNo;
	private String fullname;
	private double salary;
	private int birthYear;
	
	
	public DeleteCustomerResponse() {
		
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


	@Override
	public String toString() {
		return "DeleteCustomerResponse [tcKimlikNo=" + tcKimlikNo + ", fullname=" + fullname + ", salary=" + salary
				+ ", birthYear=" + birthYear + "]";
	}
	
	
	

}
