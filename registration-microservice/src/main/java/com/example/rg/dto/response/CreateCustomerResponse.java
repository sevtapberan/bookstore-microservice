package com.example.rg.dto.response;


public class CreateCustomerResponse {
	
	private String tcKimlikNo;
	private String fullname;
	
	
	public CreateCustomerResponse() {
		
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


	@Override
	public String toString() {
		return "CreateCustomerResponse [tcKimlikNo=" + tcKimlikNo + ", fullname=" + fullname + "]";
	}
	
	
	
	
	

}
