package com.demo.amigoscode.ws.services;



import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.amigoscode.ws.repositories.StudentRepository;
import com.demo.amigoscode.ws.student.Student;

@Service
public class StudentsService {

		private final StudentRepository studentRepository;
		
		
		
	/**
		 * @param studentRepository
		 */
		@Autowired
		public StudentsService(StudentRepository studentRepository) {
			super();
			this.studentRepository = studentRepository;
		}



	public List<Student> getStudents() {
//		List<String> list=new ArrayList<String>(){{
//            add("Hello");
//            add("world");
//            add("test");
//              }};
//		return List
//				.of(new Student(1L, "Mohammed", "Mohammed.Aziar@gmail.com", LocalDate.of(1999, Month.JANUARY, 9), 22));
		return studentRepository.findAll();
	}



	public void  addNewStudent(Student student) {
		System.out.println(student);
		Optional<Student> StudentOptional = studentRepository.findStudentByEmail(student.getEmail());
		if( StudentOptional.isPresent()) {
			throw new IllegalStateException("email taken");
		}
		studentRepository.save(student);
	}


	
	public void deleteStudent(long id) {
		boolean exist =	studentRepository.existsById(id);
			if(!exist) throw new IllegalStateException("Student with Id :"+id+" does not exists");
			
			studentRepository.deleteById(id);
			
	}


	@Transactional
	public void updateStudent(Long id, String name, String email) {
		
		Student student= studentRepository.findById(id).orElseThrow(()-> new IllegalStateException("Student with Id "+id+" does not exists"));
		
		if(name != null && name.length() > 0 && !Objects.equals(name, student.getName())) {
			student.setName(name);
		}
		
		if(email != null && email.length() > 0 && !Objects.equals(email, student.getEmail()) ) {
			student.setEmail(email);
		}
		
		studentRepository.save(student);
		
	}
}
