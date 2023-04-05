package com.registration.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.registration.model.Course;

//We will use TicketDao for all database operations to tbl_ticket==> CRUD Operations on tbl_ticket
@Repository //This will take care of database connection
public interface CourseRepository extends CrudRepository<Course, Long>{

	//Spring Boot created internally CRUDRepository for achieving CRUD Operation
	/*
	 * CrudRepository ==>2 inputs parameters ==> 1) Model Class 2) Data type of Primary Key
	 *
	 * C ==> CREATE ==> INSERT STATEMENT ==> save
	 * R ==> READ   ==> SELECT STATEMENT ==> findAll,findById
	 * U ==> UPDATE ==> ALTER / UPDATE   ==> save
	 * D ==> DELETE ==> DELETE/DROP      ==> deleteById
	 *
	 *
	 */

}
