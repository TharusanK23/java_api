package com.student.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.entities.Course;
import com.student.entities.Student;
import com.student.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateStudent(@RequestBody Student student,@PathVariable Integer id) {
		return studentService.updateStudent(student,id);
	}
	
	@GetMapping(value= "/{id}")
	public ResponseEntity<?> getStudent(@PathVariable Integer id){
		return studentService.getStudentById(id);
	}
	
	@GetMapping (value = "/page")
	public ResponseEntity <Map<String, Object>> getAllStudents(
			@RequestParam(name = "pageNo",defaultValue = "0") int pageNo,
			@RequestParam(name = "pageSize",defaultValue = "5") int pageSize){
		return studentService.getAllStudents(pageNo,pageSize);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteCourse(@PathVariable Integer id){
		return studentService.deleteStudent(id);
	}
}
