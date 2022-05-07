package com.student.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.entities.Course;
import com.student.service.CourseService;



@RestController
@RequestMapping("/api/course")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@PostMapping
	public ResponseEntity<?> addCourse(@Valid @RequestBody Course course) {
		return courseService.addCourse(course);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateCourse(@RequestBody Course course,@PathVariable Integer id) {
		return courseService.updateCourse(course,id);
	}
	
	@GetMapping(value= "/{id}")
	public ResponseEntity<?> getCourse(@PathVariable Integer id){
		return courseService.getCourseById(id);
	}
	
	@GetMapping (value = "/page")
	public ResponseEntity <Map<String, Object>> getAllCourse(
			@RequestParam(name = "pageNo",defaultValue = "0") int pageNo,
			@RequestParam(name = "pageSize",defaultValue = "5") int pageSize){
		return courseService.getAllCourse(pageNo,pageSize);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Course> deleteCourse(@PathVariable Integer id){
		return courseService.deleteCourse(id);
	}

}
