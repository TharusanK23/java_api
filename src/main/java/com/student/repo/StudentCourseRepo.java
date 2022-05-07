package com.student.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.entities.StudentCourse;

public interface StudentCourseRepo extends JpaRepository<StudentCourse, Integer>{

}
