package com.student.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.entities.Lecturer;

public interface LecturerRepo extends JpaRepository<Lecturer, Integer>{

	Optional<Lecturer> findByLoginIdId(Integer id);

}
