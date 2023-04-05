package com.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.registration.model.Registration;
import com.registration.model.Users;
import com.registration.service.RegistrationService;

@RestController
@RequestMapping(value = "/register")
public class RegistrationController {
	@Autowired
	private RegistrationService registrationService;

	@GetMapping(value = "/all") //// http://localhost:8080/register/all

	public Iterable<Registration> getAllRegistration() {

		return registrationService.findAllRegistrations();

	}

	// Create User
	@PostMapping(value = "/create") // http://localhost:8080/register/create
	public Registration createRegistration(@RequestBody Registration registrationObj) {
		return registrationService.createRegistration(registrationObj);
	}

	@GetMapping(value = "/{registrationId}")
	public Registration getRegistration(@PathVariable("registrationId") Long registrationId) {
		return registrationService.findByRegistration(registrationId);
	}
	
	// Delete course
		@DeleteMapping(value = "/{registrationId}")
		// http://localhost:8080/users/1 ==> 1stUser
		public void deleteRegistration(@PathVariable("registrationId") Long registrationId) {
			registrationService.deleteRegistration(registrationId);
		}
}
