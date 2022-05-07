package com.student.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.RequestBody.LoginRequest;
import com.student.RequestBody.SignupRequest;
import com.student.ResponseBody.MessageResponse;
import com.student.repo.LoginRepo;
import com.student.service.LoginService;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@Autowired
	LoginRepo loginRepo;
	
	
	@PostMapping("/signup/user")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		
		if (loginRepo.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		
		return loginService.registerUser(signUpRequest);
	}
	
	@PostMapping("/signup/lecturer")
	public ResponseEntity<?> registerLecturer(@RequestBody SignupRequest signUpRequest) {
		
		if (loginRepo.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		
		return loginService.registerLecturer(signUpRequest);
	}
	
	@PostMapping("/signup/student")
	public ResponseEntity<?> registerStudent( @RequestBody SignupRequest signUpRequest) {
		
		if (loginRepo.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		
		return loginService.registerStudent(signUpRequest);
	}
	
	@PostMapping("/signup/admin")
	public ResponseEntity<?> registerAdmin( @RequestBody SignupRequest signUpRequest) {
		
		if (loginRepo.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		
		return loginService.registerAdmin(signUpRequest);
	}
	
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		return loginService.signin(loginRequest);
	}
	
}
