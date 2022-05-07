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
@Table(name = "students")
public class Student {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String personalDetail;
	
	@Column(nullable = false)
	private String educationDetail;
	
	@Column(nullable = false)
	private String feesDetail;
	
	@OneToOne()
	@JoinColumn(name = "login_id", referencedColumnName = "id")
	private Login loginId;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String name, String personalDetail, String educationDetail, String feesDetail, Login loginId) {
		super();
		this.name = name;
		this.personalDetail = personalDetail;
		this.educationDetail = educationDetail;
		this.feesDetail = feesDetail;
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

	public String getPersonalDetail() {
		return personalDetail;
	}

	public void setPersonalDetail(String personalDetail) {
		this.personalDetail = personalDetail;
	}

	public String getEducationDetail() {
		return educationDetail;
	}

	public void setEducationDetail(String educationDetail) {
		this.educationDetail = educationDetail;
	}

	public String getFeesDetail() {
		return feesDetail;
	}

	public void setFeesDetail(String feesDetail) {
		this.feesDetail = feesDetail;
	}

	public Login getLoginId() {
		return loginId;
	}

	public void setLoginId(Login loginId) {
		this.loginId = loginId;
	}
	
}
