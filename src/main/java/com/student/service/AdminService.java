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

import com.student.entities.Admin;
import com.student.entities.Course;
import com.student.repo.AdminRepo;

@Service
public class AdminService {

	
	@Autowired
	AdminRepo adminRepo;

	public ResponseEntity<?> updateAdmin(Admin admin, Integer id) {
		Optional<Admin> obj = adminRepo.findById(id);
		
		if(obj.isPresent()) {
			Admin oldAdmin = obj.get();
			oldAdmin.setName(admin.getName());
			adminRepo.save(oldAdmin);
			return new ResponseEntity(oldAdmin,HttpStatus.OK);
		}
		return new ResponseEntity(null,HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<?> getAdminById(Integer id) {
		Optional<Admin> obj = adminRepo.findById(id);
		if(obj.isPresent()) {
			return new ResponseEntity(obj.get(),HttpStatus.OK);
		}
		return new ResponseEntity(null,HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<Map<String, Object>> getAllAdmin(int pageNo, int pageSize) {
		try {
            Map<String, Object> response = new HashMap();
            Sort sort = Sort.by(Sort.Direction.DESC,"id");
            Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
            Page<Admin> page = adminRepo.findAll(pageable);
            response.put("data", page.getContent());
            response.put("Total_No_Of_Pages", page.getTotalPages());
            response.put("Total_No_Of_Elements", page.getTotalElements());
            response.put("Current page no", page.getNumber());
            
            return new ResponseEntity(response, HttpStatus.OK);
        }catch(Exception e) {
        	return new ResponseEntity(null,HttpStatus.SERVICE_UNAVAILABLE);
        }
	}

	public ResponseEntity<?> deleteAdmin(Integer id) {
		Optional<Admin> obj = adminRepo.findById(id);
		if(obj.isPresent()) {
			adminRepo.deleteById(id);
			return new ResponseEntity(null,HttpStatus.OK);
		}
		return new ResponseEntity(null,HttpStatus.NOT_FOUND);
	}
}
