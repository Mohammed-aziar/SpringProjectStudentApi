package com.demo.amigoscode.ws;



import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.demo.amigoscode.ws.repositories.StudentRepository;
import com.demo.amigoscode.ws.student.Student;


@SpringBootApplication
public class Application  implements CommandLineRunner{

	
		private final StudentRepository studentRepository;
		
		
	
	/**
		 * @param studentRepository
		 */
		@Autowired
		public Application(StudentRepository studentRepository) {
			super();
			this.studentRepository = studentRepository;
		}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Student Mohammed = new Student("Mohammed", "Mohammed.Aziar@gmail.com", LocalDate.of(1999, Month.JANUARY, 9));
		Student Asmae = new Student("asmae", "Asmae.Aziar@gmail.com", LocalDate.of(1995, Month.OCTOBER, 22));
		Student Hamza = new Student("Hamza", "Hamza@gmail.com", LocalDate.of(1997, Month.JANUARY, 9));
		studentRepository.saveAll(List.of(Mohammed,Asmae,Hamza));
		
	}

	

}
