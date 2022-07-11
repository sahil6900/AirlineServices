package com.user.registration.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserEntity {
	
	@Column(length = 12)
	private String firstName;
	
	@Column(length = 12)
	private String lastName;
	
	@Column(length = 50)
	private String address;
	
	@Column(length = 12)
	private long contactNo;
	
	@Column(length = 12)
	private String city;
	
	@Column(length = 12)
	private String state;
	
	@Column(length = 12)
	private String country;
	
	@Column(length = 2)
	private String gender;
	
	@Column(length = 25)
	private String emailId;
	
	@Column(length = 8)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	
	@Column(length = 8)
	private String password;

	
}
