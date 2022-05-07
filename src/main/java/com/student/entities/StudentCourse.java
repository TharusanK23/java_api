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
@Table(name = "student_course")
public class StudentCourse {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	
	@OneToOne()
	@JoinColumn(name = "course_id", referencedColumnName = "id")
	private Course course;
	
	@OneToOne()
	@JoinColumn(name = "student_id", referencedColumnName = "id")
	private Student student;

	public StudentCourse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentCourse(com.student.entities.Course course, Student student) {
		super();
		this.course = course;
		this.student = student;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}
