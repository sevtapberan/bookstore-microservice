package com.example.purchase.domain;

import java.util.Objects;

public class Customer {

	private TcKimlikNo tcKimlikNo;
	private Fullname fullname;
	private Age age;
	private Location location;
	private Interests interests;
	private Email email;
	private Epurse epurse;
	private Username username;
	private Password password;
	private isAdmin isAdmin;
	
	public static class Builder{
		private TcKimlikNo tcKimlikNo;
		private Fullname fullname;
		private Age age;
		private Location location;
		private Interests interests;
		private Email email;
		private Epurse epurse;
		private Username username;
		private Password password;
		private isAdmin isAdmin;
		
		public Builder tcKimlikNo(String value) {
			this.tcKimlikNo = TcKimlikNo.valueOf(value);
			return this;
		}
		
		public Builder fullname(String first, String last) {
			this.fullname = Fullname.of(first, last);
			return this;
		}
		public Builder age(int value) {
			this.age = Age.valueOf(value);
			return this;
		}
		public Builder location(String value) {
			this.location = Location.valueOf(value);
			return this;
		}
		public Builder interests(String value) {
			this.interests = Interests.valueOf(value);
			return this;
		}
		public Builder email(String value) {
			this.email = Email.valueOf(value);
			return this;
		}
		public Builder epurse(double value) {
			this.epurse = Epurse.of(value);
			return this;
		}
		public Builder username(String value) {
			this.username = Username.valueOf(value);
			return this;
		}
		public Builder password(String value) {
			this.password = Password.valueOf(value);
			return this;
		}
		@SuppressWarnings("static-access")
		public Builder isAdmin(String value) {
			this.isAdmin = isAdmin.valueOf(value);
			return this;
		}
		
		public Customer build() {
			// Validation
			var customer = new Customer(this.tcKimlikNo);
			customer.setFullname(fullname);
			customer.setAge(age);
			customer.setEmail(email);
			customer.setInterests(interests);
			customer.setEpurse(epurse);
			customer.setLocation(location);
			customer.setUsername(username);
			customer.setPassword(password);
			customer.setIsAdmin(isAdmin);
			return customer;
		}
	
	}

	public Customer(TcKimlikNo tcKimlikNo) {
		this.tcKimlikNo = tcKimlikNo;
	}

	public TcKimlikNo getTcKimlikNo() {
		return tcKimlikNo;
	}

	public void setTcKimlikNo(TcKimlikNo tcKimlikNo) {
		this.tcKimlikNo = tcKimlikNo;
	}

	public Fullname getFullname() {
		return fullname;
	}

	public void setFullname(Fullname fullname) {
		this.fullname = fullname;
	}

	public Age getAge() {
		return age;
	}

	public void setAge(Age age) {
		this.age = age;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Interests getInterests() {
		return interests;
	}

	public void setInterests(Interests interests) {
		this.interests = interests;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public Epurse getEpurse() {
		return epurse;
	}

	public void setEpurse(Epurse epurse) {
		this.epurse = epurse;
	}

	public Username getUsername() {
		return username;
	}

	public void setUsername(Username username) {
		this.username = username;
	}

	public Password getPassword() {
		return password;
	}

	public void setPassword(Password password) {
		this.password = password;
	}

	public isAdmin getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(isAdmin isAdmin) {
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
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	


}
