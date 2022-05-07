package com.student.ResponseBody;

import java.util.List;

import com.student.entities.Lecturer;
import com.student.entities.Login;
import com.student.entities.Student;
import com.student.entities.User;

public class BasicAuthResponse {

	private String token;
	private String type = "Basic";
	
	private User user;
	
	private Student student;
	
	private Lecturer lecturer;
	
	private Login login;

	public BasicAuthResponse() {
		super();
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Lecturer getLecturer() {
		return lecturer;
	}

	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	
}
