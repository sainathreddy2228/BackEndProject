package com.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.registration.model.Users;
import com.registration.service.UsersService;

@RestController
@RequestMapping(value = "/users")
//http://localhost:8080/users ==>User obj=ioc.getUser();
public class UserController {

	/*
	 * REST SERVICES ==> ITS AN APPROACH FOR WEBSERVICES WEB SERVICE ==> EXCHANGE OF
	 * DATA BETWEEN TWO DIFFERENT FRAMEWORKS
	 *
	 *
	 * GET ==> HTTP GET CALL POST ==> HTTP POST CALL PUT ==> UPDATE DELETE ==>
	 * DELETE ==> all these verbs are created in Java using JAX -RS Rest Service
	 * Framework
	 *
	 * @Get + @RequestMapping ==> @GetMapping ==> Retieving the data
	 *
	 * @Post+ @RequestMapping ==> @PostMapping ==> Creating the data
	 *
	 * @Put + @RequestMapping ==> @PutMapping ==> Updating the data
	 *
	 * @Delete+ @RequestMapping ==> @DeleteMapping ==> Deleting the data
	 *
	 *
	 * Angular/React communicates with Spring Boot ==> It has JACKSON Libaray ==>
	 * JAVA TO JSON AND JSON TO JAVA
	 *
	 * REST SERVICES USES JSON ==> Javascript Object
	 *
	 * { key1: value1, key2: value2, .....
	 *
	 * }
	 *
	 * { orderid:101, payment:2000, product: "Mobile" rating:4 zipcode: 500037
	 *
	 * }
	 */

	// Retrieve All Users

	@Autowired
	private UsersService usersService;

	@GetMapping(value = "/all") //// http://localhost:8080/users/all

	public Iterable<Users> getAllUser() {

		return usersService.findAllUser();

	}

	// Create User
	@PostMapping(value = "/create") // http://localhost:8080/users/create
	public Users createUsers(@RequestBody Users usersObj) {
		return usersService.createUsers(usersObj);
	}

	// Retrieve Single User
	// http://localhost:8080/users/1 ==> 1stuser
	// http://localhost:8080/users/2 ==> 2nduser
	// http://localhost:8080/users/3 ==> 3rduser
	@GetMapping(value = "/{userId}")
	public Users getUsers(@PathVariable("userId") Long userId) {
		return usersService.findUsers(userId);
	}

	// Update users
	// http://localhost:8080/users/1/vijay/vijay@gmail.com/9888 ==> 1stcourse update with
	// vijay@gmail.com
	// http://localhost:8080/course/2/sandhya/sandhya@gmail.com/09887667 ==> 2nd course update with
	// sandhya@gmail.com
	@PutMapping(value = "/{courseId}/{newUserName}/{newUserMail}/{newUserPhoneNo}/")

	public Users updateUser(@PathVariable("userId") Long userId, @PathVariable("newUserName") String newUserName,
			@PathVariable("newUserMail") String newUserMail, @PathVariable("newUserPhoneNo") String newUserPhoneNo) {
		return usersService.updateUser(userId, newUserName,newUserMail,newUserPhoneNo
				);
	}

	// Delete course
	@DeleteMapping(value = "/{userId}")
	// http://localhost:8080/users/1 ==> 1stUser
	public void deleteUsers(@PathVariable("userId") Long userId) {
		usersService.deleteUsers(userId);
	}

}
