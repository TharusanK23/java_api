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

import com.student.entities.Admin;
import com.student.entities.Course;
import com.student.service.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

	
	@Autowired
	private AdminService adminService;
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateAdmin(@RequestBody Admin admin,@PathVariable Integer id) {
		return adminService.updateAdmin(admin,id);
	}
	
	@GetMapping(value= "/{id}")
	public ResponseEntity<?> getAdmin(@PathVariable Integer id){
		return adminService.getAdminById(id);
	}
	
	@GetMapping (value = "/page")
	public ResponseEntity <Map<String, Object>> getAllAdmin(
			@RequestParam(name = "pageNo",defaultValue = "0") int pageNo,
			@RequestParam(name = "pageSize",defaultValue = "5") int pageSize){
		return adminService.getAllAdmin(pageNo,pageSize);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteAdmin(@PathVariable Integer id){
		return adminService.deleteAdmin(id);
	}
}
