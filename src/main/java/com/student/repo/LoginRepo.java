package com.student.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.entities.Login;

public interface LoginRepo extends JpaRepository<Login, Integer> {

	Optional<Login> findByUsername(String username);

	boolean existsByUsername(String username);

}
