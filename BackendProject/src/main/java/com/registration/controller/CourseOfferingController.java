package com.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.registration.model.Course;
import com.registration.service.CourseService;

@RestController
@RequestMapping(value = "/course")
//http://localhost:8080/course ==>CourseController obj=ioc.getCourseController();
public class CourseOfferingController {

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

	// Retrieve All Tickets

	@Autowired
	private CourseService courseService;

	@GetMapping(value = "/all") //// http://localhost:8080/course/all
	//// http://localhost:8080/course/all ==> obj.getAllCourses();
	public Iterable<Course> getAllCourses() {

		return courseService.findAllCourseOffering();

	}

	// Create Ticket
	@PostMapping(value = "/create") // http://localhost:8080/course/create
	public Course createCourse(@RequestBody Course courseObj) {
		return courseService.createCourse(courseObj);
	}

	// Retrieve Single Course
	// http://localhost:8080/course/1 ==> 1stcourse
	// http://localhost:8080/course/2 ==> 2ndcourse
	// http://localhost:8080/course/3 ==> 3rdcourse
	@GetMapping(value = "/{courseId}")
	public Course getCourse(@PathVariable("courseId") Long courseId) {
		return courseService.findCourse(courseId);
	}

	// Update Course
	// http://localhost:8080/course/1/vijay@gmail.com ==> 1stcourse update with
	// vijay@gmail.com
	// http://localhost:8080/course/2/sandhya@gmail.com ==> 2nd course update with
	// sandhya@gmail.com
	@PutMapping(value = "/{courseId}/{newTitle}")

	public Course updateCourse(@PathVariable("courseId") Long courseId, @PathVariable("newTitle") String newTitle) {
		return courseService.updateCourse(courseId, newTitle);
	}

	// Delete course
	@DeleteMapping(value = "/{courseId}")
	// http://localhost:8080/course/1 ==> 1stCourse
	public void deleteCourse(@PathVariable("courseId") Long courseId) {
		courseService.deleteCourse(courseId);
	}

}
