package com.demo.amigoscode.ws.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.amigoscode.ws.services.StudentsService;
import com.demo.amigoscode.ws.student.Student;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {
	private final StudentsService studentsService;
	

	@Autowired
	public StudentController(StudentsService studentsService) {
		super();
		this.studentsService = studentsService;
	}

	


	@GetMapping
	public List<Student> getStudents() {
//		
		return studentsService.getStudents();
	}
	
	@PostMapping
	public void rigesterNewStudent(@RequestBody Student student) {
		studentsService.addNewStudent(student);
	}
	
	@DeleteMapping(path = "{studentId}")
	public void deleteStudent(@PathVariable("studentId") Long id ) {
		studentsService.deleteStudent(id);
	}
	
	@PutMapping(path = "{studentId}")
	public void updateStudent(@PathVariable("studentId") Long id ,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String email
			) {
		
			studentsService.updateStudent(id,name,email);
		
		
	}
	
	
}
