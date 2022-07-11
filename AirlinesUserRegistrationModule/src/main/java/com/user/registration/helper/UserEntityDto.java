package com.user.registration.helper;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserEntityDto {
	private String firstName;
	private String lastName;
	private String address;
	private long contactNo;
	private String city;
	private String state;
	private String country;
	private String gender;
	private String emailId;
	private int customerId;
	private String password;
	
}
