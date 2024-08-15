package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@SpringBootApplication
public class StudentManagementApplication implements CommandLineRunner {
	

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public void run(String...args) throws Exception{
		
	Student student1 = new Student ("Shina", "Ojo", "shinjo@gmail.com");
	studentRepository.save(student1);
	
		Student student2 = new Student ("Michael", "Bode", "mibo@gmail.com");
		studentRepository.save(student2);
		
		Student student3 = new Student ("Bisi", "Afam", "bifam@hotmail.com");
		studentRepository.save(student3);
		
		Student student4 = new Student ("Kwame", "Surutu", "kwamsu@mobl.com");
		studentRepository.save(student4);
		
		Student student5 = new Student ("Ifeanyi", "Kelechi", "ifek@gmail.com");
		studentRepository.save(student5);
		
		Student student6 = new Student ("Jumoke", "Ademola", "jumie@gmail.com");
     	studentRepository.save(student6);
		
	}
}
	

