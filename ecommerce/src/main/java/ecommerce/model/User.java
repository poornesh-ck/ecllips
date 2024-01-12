package ecommerce.model;

import java.util.Date;

public class User {
	String username;
	Date dob;
	String number;
	String email;
	String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(String username, Date dob, String number, String email, String password) {
		super();
		this.username = username;
		this.dob = dob;
		this.number = number;
		this.email = email;
		this.password = password;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", dob=" + dob + ", number=" + number + ", email=" + email + ", password="
				+ password + "]";
	}
	

}
