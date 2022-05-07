package com.student.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.entities.Course;


public interface CourseRepo extends JpaRepository<Course, Integer> {
	
	

}
