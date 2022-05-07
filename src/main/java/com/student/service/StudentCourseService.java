package com.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.student.entities.Course;
import com.student.entities.Student;
import com.student.entities.StudentCourse;
import com.student.repo.CourseRepo;
import com.student.repo.StudentCourseRepo;
import com.student.repo.StudentRepo;

@Service
public class StudentCourseService {
	
	
	@Autowired
	StudentCourseRepo studentCourseRepo;
	
	@Autowired
	CourseRepo courseRepo;
	
	@Autowired
	StudentRepo studentRepo;

	public ResponseEntity<?> addStudentCourse(StudentCourse studentCourse) {
		Optional<Course> course = courseRepo.findById(studentCourse.getCourse().getId());
		if(course.isPresent()) {
			Optional<Student> student = studentRepo.findById(studentCourse.getStudent().getId());
			if(student.isPresent()) {
				StudentCourse stuCourse = new StudentCourse(
						course.get(),
						student.get()
					);
				studentCourseRepo.save(stuCourse);
				return new ResponseEntity(stuCourse,HttpStatus.CREATED);
			}
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<?> getStudentCourseById(Integer id) {
		Optional<StudentCourse> obj = studentCourseRepo.findById(id);
		if(obj.isPresent()) {
			return new ResponseEntity(obj.get(),HttpStatus.OK);
		}
		return new ResponseEntity(null,HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<?> getAllStudentCourse() {
		List<StudentCourse>  studentCourses= studentCourseRepo.findAll();
		return new ResponseEntity(studentCourses,HttpStatus.OK);
	}
	
	
}
