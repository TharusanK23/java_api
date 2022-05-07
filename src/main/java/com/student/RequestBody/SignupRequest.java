package com.student.RequestBody;

import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SignupRequest {
	@NotBlank
	@Size(min = 3, max = 20)
    private String username;
 
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    
    private String phoneNum;
    
	private String name;
	
	private String educationDetail;
	
	private String personalDetail;
	
	private String feesDetail;
	
	private Integer courseId;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEducationDetail() {
		return educationDetail;
	}

	public void setEducationDetail(String educationDetail) {
		this.educationDetail = educationDetail;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getPersonalDetail() {
		return personalDetail;
	}

	public void setPersonalDetail(String personalDetail) {
		this.personalDetail = personalDetail;
	}

	public String getFeesDetail() {
		return feesDetail;
	}

	public void setFeesDetail(String feesDetail) {
		this.feesDetail = feesDetail;
	}
}
