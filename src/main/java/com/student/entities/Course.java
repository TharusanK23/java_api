package com.student.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table(name = "courses")
public class Course {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "name", unique = false, nullable = false, length = 100)
	@NotNull
	@NotEmpty(message = "Name cannot be empty")
	@Size(min = 2, message = "Name should have atleast 2 characters")
	private String name;
	
	@Column(name = "fees", unique = false, nullable = true)
	private double fees;
	
	@Column(name = "duration", unique = false, nullable = true)
	private int duration;

	public Course() {
		super();
	}

	public Course(
			@NotEmpty(message = "Name cannot be empty") @Size(min = 2, message = "Name should have atleast 2 characters") String name,
			double fees, int duration) {
		super();
		this.name = name;
		this.fees = fees;
		this.duration = duration;
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

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
}
