package com.student.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lecturers")
public class Lecturer {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String educationDetail;
	
	@OneToOne()
	@JoinColumn(name = "course_id", referencedColumnName = "id")
	private Course course;
	
	@OneToOne()
	@JoinColumn(name = "login_id", referencedColumnName = "id")
	private Login loginId;

	public Lecturer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Lecturer(String name, String educationDetail, Course course, Login loginId) {
		super();
		this.name = name;
		this.educationDetail = educationDetail;
		this.course = course;
		this.loginId = loginId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Login getLoginId() {
		return loginId;
	}

	public void setLoginId(Login loginId) {
		this.loginId = loginId;
	}
}
