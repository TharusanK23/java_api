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

import com.student.entities.Lecturer;
import com.student.service.LecturerService;

@RestController
@RequestMapping("/api/lecturer")
public class LecturerController {
	
	@Autowired
	LecturerService lecturerService;
	
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateLecturer(@RequestBody Lecturer lecturer,@PathVariable Integer id) {
		return lecturerService.updateLecturer(lecturer,id);
	}
	
	@GetMapping(value= "/{id}")
	public ResponseEntity<?> getLecturer(@PathVariable Integer id){
		return lecturerService.getLecturerById(id);
	}
	
	@GetMapping (value = "/page")
	public ResponseEntity <Map<String, Object>> getAllLecturer(
			@RequestParam(name = "pageNo",defaultValue = "0") int pageNo,
			@RequestParam(name = "pageSize",defaultValue = "5") int pageSize){
		return lecturerService.getAllLecturer(pageNo,pageSize);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteLecturer(@PathVariable Integer id){
		return lecturerService.deleteLecturer(id);
	}
}
