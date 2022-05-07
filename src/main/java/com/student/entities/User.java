package com.student.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;


@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	@Email
	private String email;
	
	@Column(nullable = false)
	private String mobile;
	
	@OneToOne()
	@JoinColumn(name = "login_id", referencedColumnName = "id")
	private Login loginId;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String name, @Email String email, String mobile, Login loginId) {
		super();
		this.name = name;
		this.email = email;
		this.mobile = mobile;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Login getLoginId() {
		return loginId;
	}

	public void setLoginId(Login loginId) {
		this.loginId = loginId;
	}
	
	
}
