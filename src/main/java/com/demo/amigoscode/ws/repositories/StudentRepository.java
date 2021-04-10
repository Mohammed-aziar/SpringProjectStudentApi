package com.demo.amigoscode.ws.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.amigoscode.ws.student.Student;

@Repository
public interface StudentRepository  extends JpaRepository<Student, Long>{
	
	//@Query ("select s from Student s where email= ?1")
Optional<Student> findStudentByEmail(String email);

}
