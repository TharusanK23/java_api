package com.student.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.entities.Course;
import com.student.entities.StudentCourse;
import com.student.service.CourseService;
import com.student.service.StudentCourseService;


@RestController
@RequestMapping("/api/student/course")
public class StudentCourseController {
	
	@Autowired
	StudentCourseService studentCourseService;
	
	@Autowired
	private CourseService courseService;
	
	@PostMapping
	public ResponseEntity<?> addStudentCourse(StudentCourse studentCourse) {
		return studentCourseService.addStudentCourse(studentCourse);
	}
	
	@GetMapping(value= "/{id}")
	public ResponseEntity<?> getStudentCourse(@PathVariable Integer id){
		return studentCourseService.getStudentCourseById(id);
	}
	
	@GetMapping
	public ResponseEntity<?> getAllStudentCourse(){
		return studentCourseService.getAllStudentCourse();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Course> deleteBook(@PathVariable Integer id){
		return courseService.deleteCourse(id);
	}

}
