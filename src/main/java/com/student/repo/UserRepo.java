package com.student.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	Optional<User> findByLoginIdId(Integer id);

}
