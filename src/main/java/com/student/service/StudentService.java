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
import com.student.entities.Student;
import com.student.repo.StudentRepo;

@Service
public class StudentService {
	
	
	@Autowired
	StudentRepo studentRepo;

	public ResponseEntity<?> updateStudent(Student student, Integer id) {
		Optional<Student> obj = studentRepo.findById(id);
		
		if(obj.isPresent()) {
			Student oldStudent = obj.get();
			oldStudent.setName(student.getName());
			oldStudent.setEducationDetail(student.getEducationDetail());
			oldStudent.setFeesDetail(student.getFeesDetail());
			oldStudent.setPersonalDetail(student.getPersonalDetail());
			studentRepo.save(oldStudent);
			return new ResponseEntity(oldStudent,HttpStatus.OK);
		}
		return new ResponseEntity(null,HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<?> getStudentById(Integer id) {
		Optional<Student> obj = studentRepo.findById(id);
		if(obj.isPresent()) {
			return new ResponseEntity(obj.get(),HttpStatus.OK);
		}
		return new ResponseEntity(null,HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<Map<String, Object>> getAllStudents(int pageNo, int pageSize) {
		try {
            Map<String, Object> response = new HashMap();
            Sort sort = Sort.by(Sort.Direction.DESC,"id");
            Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
            Page<Student> page = studentRepo.findAll(pageable);
            response.put("data", page.getContent());
            response.put("Total_No_Of_Pages", page.getTotalPages());
            response.put("Total_No_Of_Elements", page.getTotalElements());
            response.put("Current page no", page.getNumber());
            
            return new ResponseEntity(response, HttpStatus.OK);
        }catch(Exception e) {
        	return new ResponseEntity(null,HttpStatus.SERVICE_UNAVAILABLE);
        }
	}

	public ResponseEntity<?> deleteStudent(Integer id) {
		Optional<Student> obj = studentRepo.findById(id);
		if(obj.isPresent()) {
			studentRepo.deleteById(id);
			return new ResponseEntity(null,HttpStatus.OK);
		}
		return new ResponseEntity(null,HttpStatus.NOT_FOUND);
	}
}
