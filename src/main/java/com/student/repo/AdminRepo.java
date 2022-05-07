package com.student.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.entities.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer>{

}
