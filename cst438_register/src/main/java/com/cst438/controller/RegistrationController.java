package com.cst438.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cst438.domain.Student;
import com.cst438.domain.StudentDTO;
import com.cst438.domain.StudentRepository;


@RestController
@CrossOrigin(origins = {"http://localhost:3000","http://localhost:3001"})
public class RegistrationController {
	
	@Autowired
	StudentRepository studentRepository;
	
	@PostMapping("/student/create")
	@Transactional
	public void createStudent (
		@RequestParam StudentDTO studentDTO
	) {
		Student existingStudent = studentRepository.findByEmail(studentDTO.getEmail());
		
		if(existingStudent == null) {
			studentRepository.save(
				new Student()
					.setEmail(studentDTO.getEmail())
					.setName(studentDTO.getStudentName())
			);
		}
	}
	
	@PatchMapping("/student/update")
	@Transactional
	public StudentDTO updateStudent (
		@RequestParam StudentDTO studentDTO
	) {
		Optional<Student> studentOptional = studentRepository.findById(studentDTO.getId());
		if(studentOptional.isPresent()) {
			Student student = studentOptional.get();
			student.setStatusCode(studentDTO.getStatus());
			studentRepository.save(student);
			return studentDTO;
		}
		throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Student not found");
	}
	
}
