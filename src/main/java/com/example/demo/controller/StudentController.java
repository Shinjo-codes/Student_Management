package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private  StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	//Handler method to handle student list and return mode and view
	
	@GetMapping("/student")
	public String listStudents(Model model) {
		model.addAttribute("student", studentService.getAllStudents());
		
		return "student";
		
	}
	
	@GetMapping("/student/new")
	public String createNewStudentForm(Model model) {
		
		//create an empty student object to hold new student info
		Student student = new Student();
		
		model.addAttribute("student", student);
		return "create_student";
		
	}
	
	@PostMapping("/student")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/student";
		
		
	}
	
	@GetMapping("/student/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "edit_student";
		
	}
	
	@PostMapping("/student/{id}")
	public String updateStudent(@PathVariable Long id,
			@ModelAttribute("student") Student student,
			Model model) {
		
		//get student from database
		
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		existingStudent.setId(id);
		
		//save updated student object
		studentService.updateStudent(existingStudent);
		return "redirect:/student";
		
		
	}
	
	//handler method to handle delete student request
	
	@GetMapping("/student/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/student";
		
	}

}
