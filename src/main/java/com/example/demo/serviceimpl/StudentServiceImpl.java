package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	private StudentRepository studentRepository;
	
	
	
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}



	@Override
	public List<Student> getAllStudents() {
				return studentRepository.findAll(); //returns a list of students
				
	}



	@Override
	public Student saveStudent(Student student) {
		
		return studentRepository.save(student);
		
	}



	@Override
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
				
		
	}



	@Override
	public Student getStudentById(Long id) {
		return studentRepository.findById(id).get();
		
	}



	@Override
	public void deleteStudentById(Long id) {
		studentRepository.deleteById(id);
		
	}
	
	
	

}
;