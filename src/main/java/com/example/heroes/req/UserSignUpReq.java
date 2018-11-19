/**
 * 
 */
/**
 * @author An An Nguyen
 *
 */
package com.example.heroes.req;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserSignUpReq {
	// region -- Fields --
	
	@JsonProperty(value = "userName")
	private String userName;

	@JsonProperty(value = "email")
	private String email;

	@JsonProperty(value = "password")
	private String password;	

	@JsonProperty(value = "firstName")
	private String firstName;

	@JsonProperty(value = "lastName")
	private String lastName;

	// end
	
	// region -- Get set --

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	// end
	
	// region -- Methods --
	
	public UserSignUpReq() {
		
	}

	// end
}
