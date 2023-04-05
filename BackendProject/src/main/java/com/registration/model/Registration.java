package com.registration.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Tbl_Registration")
public class Registration {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long registrationId;

	
	private long registrationFee;


	public Registration(long registrationFee) {
		super();
		this.registrationFee = registrationFee;
	}
	
	public Registration() {
		
	}

	public long getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(long registrationId) {
		this.registrationId = registrationId;
	}
	
	
	
	
}
