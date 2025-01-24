package com.UserRegisterationAndValidationSystem.app;
import java.io.Serializable;
public class User implements Serializable{
	private String name;
	private String email;
	private String password;
	private String phoneNumber;
	private String address;
	private String dob;
	private String gender;
	// Constructor
	public User(String name,String email,String password, String phoneNumber, String address,String dob, String gender){
		this.name=name;
		this.email=email;
		this.password=password;
		this.address=address;
		this.dob=dob;
		this.gender=gender;
	}
	//getter for login
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String toString() {
		return "Name: " +name+", Email: "+email+
				", Phone: "+phoneNumber+", Address: "+address+
				", DOB: "+dob+", Gender: "+gender;
	}
}
