package com.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registration.model.Registration;
import com.registration.repository.RegistrationRepository;

@Service
public class RegistrationService {
	@Autowired
	public RegistrationRepository registrationRepository;

//Inserting the Data 

	public Iterable<Registration> findAllRegistrations() {
		return registrationRepository.findAll();
	}

//Getting The single Registration 
	public Registration findByRegistration(long registrationId) {
		return registrationRepository.findById(registrationId).orElse(new Registration());
	}
	//Inserting the Data
	public Registration createRegistration(Registration objRegistration) {
		return registrationRepository.save(objRegistration);
	}
	
	//Delete the SingleRecord
		public void deleteRegistration(Long registrationId) {
			registrationRepository.deleteById(registrationId);
		}
}
