package com.student.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.student.entities.Course;
import com.student.entities.User;
import com.student.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	UserRepo userRepo;

	public ResponseEntity<?> updateUser(User user, Integer id) {
		Optional<User> obj = userRepo.findById(id);
		
		if(obj.isPresent()) {
			User oldUser = obj.get();
			oldUser.setName(user.getName());
			oldUser.setEmail(user.getEmail());
			oldUser.setMobile(user.getMobile());
			userRepo.save(oldUser);
			return new ResponseEntity(oldUser,HttpStatus.OK);
		}
		return new ResponseEntity(null,HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<?> getUserById(Integer id) {
		Optional<User> obj = userRepo.findById(id);
		if(obj.isPresent()) {
			return new ResponseEntity(obj.get(),HttpStatus.OK);
		}
		return new ResponseEntity(null,HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<Map<String, Object>> getAllUsers(int pageNo, int pageSize) {
		try {
            Map<String, Object> response = new HashMap();
            Sort sort = Sort.by(Sort.Direction.DESC,"id");
            Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
            Page<User> page = userRepo.findAll(pageable);
            response.put("data", page.getContent());
            response.put("Total_No_Of_Pages", page.getTotalPages());
            response.put("Total_No_Of_Elements", page.getTotalElements());
            response.put("Current page no", page.getNumber());
            
            return new ResponseEntity(response, HttpStatus.OK);
        }catch(Exception e) {
        	return new ResponseEntity(null,HttpStatus.SERVICE_UNAVAILABLE);
        }
	}

	public ResponseEntity<?> deleteUser(Integer id) {
		Optional<User> obj = userRepo.findById(id);
		if(obj.isPresent()) {
			userRepo.deleteById(id);
			return new ResponseEntity(null,HttpStatus.OK);
		}
		return new ResponseEntity(null,HttpStatus.NOT_FOUND);
	}
}
