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

import com.student.entities.Lecturer;
import com.student.repo.LecturerRepo;

@Service
public class LecturerService {
	
	@Autowired
	LecturerRepo lecturerRepo;

	public ResponseEntity<?> updateLecturer(Lecturer lecturer, Integer id) {
		Optional<Lecturer> obj = lecturerRepo.findById(id);
		
		if(obj.isPresent()) {
			Lecturer oldlecturer = obj.get();
			oldlecturer.setName(lecturer.getName());
			oldlecturer.setEducationDetail(lecturer.getEducationDetail());
			lecturerRepo.save(oldlecturer);
			return new ResponseEntity(oldlecturer,HttpStatus.OK);
		}
		return new ResponseEntity(null,HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<?> getLecturerById(Integer id) {
		Optional<Lecturer> obj = lecturerRepo.findById(id);
		if(obj.isPresent()) {
			return new ResponseEntity(obj.get(),HttpStatus.OK);
		}
		return new ResponseEntity(null,HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<Map<String, Object>> getAllLecturer(int pageNo, int pageSize) {
		try {
            Map<String, Object> response = new HashMap();
            Sort sort = Sort.by(Sort.Direction.DESC,"id");
            Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
            Page<Lecturer> page = lecturerRepo.findAll(pageable);
            response.put("data", page.getContent());
            response.put("Total_No_Of_Pages", page.getTotalPages());
            response.put("Total_No_Of_Elements", page.getTotalElements());
            response.put("Current page no", page.getNumber());
            
            return new ResponseEntity(response, HttpStatus.OK);
        }catch(Exception e) {
        	return new ResponseEntity(null,HttpStatus.SERVICE_UNAVAILABLE);
        }
	}

	public ResponseEntity<Lecturer> deleteLecturer(Integer id) {
		Optional<Lecturer> obj = lecturerRepo.findById(id);
		if(obj.isPresent()) {
			lecturerRepo.deleteById(id);
			return new ResponseEntity(null,HttpStatus.OK);
		}
		return new ResponseEntity(null,HttpStatus.NOT_FOUND);
	}

}
