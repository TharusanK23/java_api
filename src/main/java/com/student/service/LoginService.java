package com.student.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.student.RequestBody.LoginRequest;
import com.student.RequestBody.SignupRequest;
import com.student.ResponseBody.BasicAuthResponse;
import com.student.ResponseBody.MessageResponse;
import com.student.config.BasicAuthUtils;
import com.student.entities.Admin;
import com.student.entities.Course;
import com.student.entities.Lecturer;
import com.student.entities.Login;
import com.student.entities.Student;
import com.student.entities.User;
import com.student.repo.AdminRepo;
import com.student.repo.CourseRepo;
import com.student.repo.LecturerRepo;
import com.student.repo.LoginRepo;
import com.student.repo.StudentRepo;
import com.student.repo.UserRepo;

@Service
public class LoginService {
	
	@Autowired
	LoginRepo loginRepo;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	LecturerRepo lectuererRepo;
	
	@Autowired
	StudentRepo studentRepo;
	
	@Autowired
	CourseRepo courseRepo;
	
	@Autowired
	AdminRepo adminRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private BasicAuthUtils basicUtils;

	public ResponseEntity<?> registerUser(SignupRequest signUpRequest) {
		
		Login login = new Login(signUpRequest.getUsername(),encoder.encode(signUpRequest.getPassword()),"USER");
		loginRepo.save(login);
		
		
		User user = new User(signUpRequest.getName(), 
				 signUpRequest.getEmail(),
				 signUpRequest.getPhoneNum(),
				 login);
		
		userRepo.save(user);
		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}

	public ResponseEntity<?> registerLecturer(SignupRequest signUpRequest) {
		Login login = new Login(signUpRequest.getUsername(),encoder.encode(signUpRequest.getPassword()),"LECTURER");
		loginRepo.save(login);
		
		Optional<Course> course = courseRepo.findById(signUpRequest.getCourseId());
		
		Lecturer lecturer = new Lecturer(signUpRequest.getName(), 
				 signUpRequest.getEducationDetail(),
				 course.get(),
				 login);
		
		lectuererRepo.save(lecturer);
		return ResponseEntity.ok(new MessageResponse("Lecturer registered successfully!"));
	}

	public ResponseEntity<?> registerStudent(SignupRequest signUpRequest) {
		Login login = new Login(signUpRequest.getUsername(),encoder.encode(signUpRequest.getPassword()),"STUDENT");
		loginRepo.save(login);
		
		Student student = new Student(signUpRequest.getName(), 
					signUpRequest.getPersonalDetail(),
					signUpRequest.getEducationDetail(),
					signUpRequest.getFeesDetail(),
					login);
		
		studentRepo.save(student);
		return ResponseEntity.ok(new MessageResponse("Student registered successfully!"));
	}
	
	public ResponseEntity<?> registerAdmin(SignupRequest signUpRequest) {
		Login login = new Login(signUpRequest.getUsername(),encoder.encode(signUpRequest.getPassword()),"ADMIN");
		loginRepo.save(login);
		
		Admin admin = new Admin(signUpRequest.getName(),login);
	
		adminRepo.save(admin);
		return ResponseEntity.ok(new MessageResponse("Admin registered successfully!"));
	}

	public ResponseEntity<?> signin(LoginRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String basicToken = basicUtils.generateBasicToken(loginRequest.getUsername(), loginRequest.getPassword());
		System.out.println(authentication.getName());
		Optional<Login> login = loginRepo.findByUsername(authentication.getName());
		if(login.isPresent()) {
			System.out.println(login.get().getId());
			System.out.println(login.get().getUserType());
			if(login.get().getUserType().equals("USER") ) {
				Optional<User> user = userRepo.findByLoginIdId(1);
				if(user.isPresent()) {
					System.out.println(login.get().getId());
					BasicAuthResponse resposne = new BasicAuthResponse();
					resposne.setToken(basicToken);
					resposne.setUser(user.get());
					return ResponseEntity.ok(resposne );
				}
			}else if(login.get().getUserType().equals("STUDENT")) {
				Optional<Student> stu = studentRepo.findByLoginIdId(login.get().getId());
				if(stu.isPresent()) {
					BasicAuthResponse resposne = new BasicAuthResponse();
					resposne.setToken(basicToken);
					resposne.setStudent(stu.get());
					return ResponseEntity.ok(resposne );
				}
				
			}else if(login.get().getUserType().equals("LECTURER")){
				Optional<Lecturer> lecturer = lectuererRepo.findByLoginIdId(login.get().getId());
				if(lecturer.isPresent()) {
					BasicAuthResponse resposne = new BasicAuthResponse();
					resposne.setToken(basicToken);
					resposne.setLecturer(lecturer.get());
					return ResponseEntity.ok(resposne );
				}
			}
		}
		return ResponseEntity.badRequest()
				.body(new MessageResponse("Error: Data not found!"));
	}

	

}
