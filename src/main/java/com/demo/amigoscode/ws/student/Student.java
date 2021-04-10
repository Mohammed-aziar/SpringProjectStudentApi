package com.demo.amigoscode.ws.student;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
@Entity
@Table
public class Student {
	
	@Id
	@SequenceGenerator(
			name = "student_Sequence",
			sequenceName = "student_Sequence",
			allocationSize = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "student_Sequence"
	) 
	private Long Id;
	@Column(nullable = false,length = 50)
	private String name;
	@Column(nullable = false,length = 120)
	private String email;
	private LocalDate dob;
	@Transient
	private Integer age;

	/**
	 * 
	 */
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param name
	 * @param email
	 * @param dob
	 * @param age
	 */
	public Student(Long id, String name, String email, LocalDate dob, Integer age) {
		super();
		Id = id;
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.age = age;
	}

	/**
	 * @param name
	 * @param email
	 * @param dob
	 * @param age
	 */
	public Student(String name, String email, LocalDate dob) {
		super();
		this.name = name;
		this.email = email;
		this.dob = dob;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Integer getAge() {
		return Period.between(this.dob,LocalDate.now()).getYears();
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [Id=" + Id + ", name=" + name + ", email=" + email + ", dob=" + dob + ", age=" + age + "]";
	}

}
