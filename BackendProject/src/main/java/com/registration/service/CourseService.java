package com.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.registration.model.Course;
import com.registration.repository.CourseRepository;

@Service
//This annotation will consider as service layer for achieving transaction mgmt and all other external frameworks
// like rabitmq,kafka,JMS etc...instantiation
public class CourseService {

	// Need to call CourseOfferingRepository
	// class which implements CourseOfferingRepository

	@Autowired
	private CourseRepository  courseRepository; // IOC ==> TicketDao ticketDao=ioc.getTicketDao();

	// Retrieve All Courses

	public Iterable<Course> findAllCourseOffering() {

		return courseRepository.findAll();
		//findAll ==> select * from tbl_course ==> Resultset ==> Iterable<CourseOffering>

	}

	//Retrieving Single Course
	public Course findCourse(Long courseId) {

		return courseRepository.findById(courseId).
											orElse(new Course());
		//findById ==> select * from tbl_course where course_id=courseId
		//Resulset can be converted CourseOffering.java
		//if courseId data is not there ==> orElse will be invoked

	}

	//Inserting the Data
	public Course createCourse(Course courseObj) {
		return courseRepository.save(courseObj);
		//save==> insert into tbl_course values(......);
		/*
		 * save is the common method for inserting the data or updating the data
		 *  insert ==> when courseOfferingRepository.courseId ==null
		 *  		==> when courseOfferingObj.courseId !=null this id not there in the database
		 *
		 *  update ==>  when courseOfferingObj.courseId !=null this id  there in the database
		 *
		 */
	}

	//Updating the Data
	public Course updateCourse(Long courseId,String newTitle) {
		Course dbCourseObj=findCourse(courseId);
		dbCourseObj.setTitle(newTitle);
		return courseRepository.save(dbCourseObj);
		// Here save Method will update
		// update tbl_ticket set ...... where ticket_id=ticketId


	}


	//Delete the SingleRecord
	public void deleteCourse(Long courseId) {
		courseRepository.deleteById(courseId);
		//deleteById ==> delete tbl_course where course_id=courseId

	}

}
