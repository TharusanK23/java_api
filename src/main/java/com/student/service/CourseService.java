package com.student.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.student.entities.Course;
import com.student.repo.CourseRepo;

@Service
public class CourseService {
	
	@Autowired
	CourseRepo courseRepo;

	public ResponseEntity<?> addCourse(@Valid Course course) {
		Course savedCourse = new Course(
								course.getName(),
								course.getFees(),
								course.getDuration()
							);
		courseRepo.save(savedCourse);
		return new ResponseEntity(savedCourse,HttpStatus.CREATED);
	}

	public ResponseEntity<?> updateCourse(Course course, Integer id) {
		Optional<Course> obj = courseRepo.findById(id);
		
		if(obj.isPresent()) {
			Course oldCourse = obj.get();
			oldCourse.setDuration(course.getDuration());
			oldCourse.setFees(course.getFees());
			oldCourse.setName(course.getName());
			courseRepo.save(oldCourse);
			return new ResponseEntity(oldCourse,HttpStatus.OK);
		}
		return new ResponseEntity(null,HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<?> getCourseById(Integer id) {
		Optional<Course> obj = courseRepo.findById(id);
		if(obj.isPresent()) {
			return new ResponseEntity(obj.get(),HttpStatus.OK);
		}
		return new ResponseEntity(null,HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<Map<String, Object>> getAllCourse(int pageNo, int pageSize) {
		try {
            Map<String, Object> response = new HashMap();
            Sort sort = Sort.by(Sort.Direction.DESC,"id");
            Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
            Page<Course> page = courseRepo.findAll(pageable);
            response.put("data", page.getContent());
            response.put("Total_No_Of_Pages", page.getTotalPages());
            response.put("Total_No_Of_Elements", page.getTotalElements());
            response.put("Current page no", page.getNumber());
            
            return new ResponseEntity(response, HttpStatus.OK);
        }catch(Exception e) {
        	return new ResponseEntity(null,HttpStatus.SERVICE_UNAVAILABLE);
        }
	}

	public ResponseEntity<Course> deleteCourse(Integer id) {
		Optional<Course> obj = courseRepo.findById(id);
		if(obj.isPresent()) {
			courseRepo.deleteById(id);
			return new ResponseEntity(null,HttpStatus.OK);
		}
		return new ResponseEntity(null,HttpStatus.NOT_FOUND);
	}
	
}
