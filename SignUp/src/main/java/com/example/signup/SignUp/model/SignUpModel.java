package com.example.signup.SignUp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="users")
public class SignUpModel {
	@Id
	private String _id;
	private String username;
	private String password;
	private String mobileNumber;
	private String gender;
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
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public SignUpModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SignUpModel(String username, String password, String mobileNumber, String gender) {
		super();
		this.username = username;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "SignUpModel [username=" + username + ", password=" + password + ", mobileNumber=" + mobileNumber
				+ ", gender=" + gender + "]";
	}
	
	
}
