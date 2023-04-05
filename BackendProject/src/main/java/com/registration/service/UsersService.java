package com.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

import com.registration.model.Users;
import com.registration.repository.UsersRepository;

@Service

public class UsersService {

	

	@Autowired
	private UsersRepository  usersRepository; 

	// Retrieve All  Users

	public Iterable<Users> findAllUser() {

		return usersRepository.findAll();
		
	}

	//Retrieving Single User
	public Users findUsers(Long userId) {

		return usersRepository.findById(userId).orElse(new Users());

	}

	//Inserting the Data
	public Users createUsers(Users usersObj) {
		return usersRepository.save(usersObj);
		
	}

	//Updating the Data
	public Users updateUser(Long userId,String newUserName,String newUserMail,String newUserPhoneNo) {
		Users dbUserObj=findUsers(userId);
		dbUserObj.setUserName(newUserName);
		dbUserObj.setUserMail(newUserMail);
		dbUserObj.setUserPhoneNo(newUserPhoneNo);
		return usersRepository.save(dbUserObj);
		

	}


	//Delete the SingleRecord
	public void deleteUsers(Long userId) {
		usersRepository.deleteById(userId);
		//deleteById ==> delete tbl_course where course_id=courseId

	}

}
