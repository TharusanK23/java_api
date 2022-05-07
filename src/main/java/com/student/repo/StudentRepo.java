package com.student.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.entities.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

	Optional<Student> findByLoginIdId(Integer id);
}
