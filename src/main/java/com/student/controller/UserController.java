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
import com.student.entities.User;
import com.student.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateUser(@RequestBody User user,@PathVariable Integer id) {
		return userService.updateUser(user,id);
	}
	
	@GetMapping(value= "/{id}")
	public ResponseEntity<?> getUser(@PathVariable Integer id){
		return userService.getUserById(id);
	}
	
	@GetMapping (value = "/page")
	public ResponseEntity <Map<String, Object>> getAllUsers(
			@RequestParam(name = "pageNo",defaultValue = "0") int pageNo,
			@RequestParam(name = "pageSize",defaultValue = "5") int pageSize){
		return userService.getAllUsers(pageNo,pageSize);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Integer id){
		return userService.deleteUser(id);
	}
}
