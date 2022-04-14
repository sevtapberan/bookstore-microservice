package com.example.registration.domain;

import java.util.List;
import java.util.Objects;

import javax.tools.DocumentationTool.Location;








public class Customer {
	
	private TcKimlikNo tcKimlikNo;
	private FullName fullName;
	private Epurse salary;
	private BirthYear birthYear;
	private UserName  userName;
	private Password  password;
	private IsAdmin isAdmin;
	private Email   email;
	private Location location;
	
	
	
	public static class Builder{
		
		private TcKimlikNo tcKimlikNo;
		private FullName fullName;
		private Epurse salary;
		private BirthYear birthYear;
		private UserName  userName;
		private Password  password;
		private IsAdmin  isAdmin;
		private Email   email;     //
		private Location location; //
		

		
		
		public Builder tcKimlikNo(String value) {
			this.tcKimlikNo = TcKimlikNo.valueOf(value);
			return this;
		}
		
		public Builder fullName(String first, String last) {
			this.fullName = FullName.of(first, last);
			return this;
		}
		
		public Builder salary(String id,double value) {
			this.salary = Epurse.of(id, value);
			return this;
		}
		
		public Builder birthYear(int value) {
			this.birthYear = BirthYear.of(value);
			return this;
		}
		
		public Builder username(String value) {
			this.userName = UserName.of(value);
			return this;
		}
		
		public Builder password(String value) {
			this.password = Password.of(value);
			return this;
		}
		
		public Builder isAdmin(Boolean value) {
			this.isAdmin = IsAdmin.of(value);
			return this;
			
		}
		
		public Builder email(String value) {
			this.email = Email.of(value);
			return this;
		}
		
		public Builder location(String value) {
			this.location = Location.valueOf(value);
			return this;
		}
		
		public Customer build() {
			
			var customer = new Customer(this.tcKimlikNo);
			customer.setFullName(fullName);
			customer.setSalary(salary);
			customer.setBirthYear(birthYear);
			customer.setUserName(userName);
			customer.setPassword(password);
			customer.setIsAdmin(isAdmin);
			customer.setEmail(email);
			customer.setLocation(location);
			
			return customer;
			
			}
		
		
		
		}


	public Customer(TcKimlikNo tcKimlikNo) {
		super();
		this.tcKimlikNo = tcKimlikNo;
	}


	public FullName getFullName() {
		return fullName;
	}


	public void setFullName(FullName fullName) {
		this.fullName = fullName;
	}


	public Epurse getSalary() {
		return salary;
	}


	public void setSalary(Epurse salary) {
		this.salary = salary;
	}
	
	


	public BirthYear getBirthYear() {
		return birthYear;
	}


	public void setBirthYear(BirthYear birthYear) {
		this.birthYear = birthYear;
	}


	public UserName getUserName() {
		return userName;
	}


	public void setUserName(UserName userName) {
		this.userName = userName;
	}


	public Password getPassword() {
		return password;
	}


	public void setPassword(Password password) {
		this.password = password;
	}


	public IsAdmin getIsAdmin() {
		return isAdmin;
	}
	
	


	public Email getEmail() {
		return email;
	}


	public void setEmail(Email email) {
		this.email = email;
	}


	public void setIsAdmin(IsAdmin isAdmin) {
		this.isAdmin = isAdmin;
	}


	public TcKimlikNo getTcKimlikNo() {
		return tcKimlikNo;
	}
	
	


	public Location getLocation() {
		return location;
	}


	public void setLocation(Location location) {
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
		Customer other = (Customer) obj;
		return Objects.equals(tcKimlikNo, other.tcKimlikNo);
	}


	@Override
	public String toString() {
		return "Customer [tcKimlikNo=" + tcKimlikNo + ", fullName=" + fullName + ", salary=" + salary + ", birthYear="
				+ birthYear + ", userName=" + userName + ", password=" + password + ", isAdmin=" + isAdmin + "]";
	}
	
	
	
	


	
	
	
	
	
}
