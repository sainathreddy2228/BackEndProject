package com.registration.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // This class become model class and it will create table with class Name ,i.e.
		// course
@Table(name = "tbl_course") // This is optional and it will create a table with tbl_ticket name
public class Course {

	@Id /// Primary Key
	@GeneratedValue(strategy = GenerationType.AUTO)
	// This will create a sequence on the database and this sequence will
	// incremented when ever you insert row
	@Column(name = "course_id")
	private Long courseId;

	private String title;
	private String instructor;

	private LocalDate date;

	private int minEmployees;

	private int maxEmployees;

	public Course(String title, String instructor, LocalDate date, int minEmployees, int maxEmployees) {
		super();
		this.title = title;
		this.instructor = instructor;
		this.date = date;
		this.minEmployees = minEmployees;
		this.maxEmployees = maxEmployees;
	}
	
	
	public Course() {
		
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getInstructor() {
		return instructor;
	}


	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public int getMinEmployees() {
		return minEmployees;
	}


	public void setMinEmployees(int minEmployees) {
		this.minEmployees = minEmployees;
	}


	public int getMaxEmployees() {
		return maxEmployees;
	}


	public void setMaxEmployees(int maxEmployees) {
		this.maxEmployees = maxEmployees;
	}


	@Override
	public String toString() {
		return "CourseOffering [courseId=" + courseId + ", title=" + title + ", instructor=" + instructor + ", date="
				+ date + ", minEmployees=" + minEmployees + ", maxEmployees=" + maxEmployees + "]";
	}
	

}
