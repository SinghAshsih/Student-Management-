package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.student.dto.StudentDto;
import com.student.service.StudentService;

import jakarta.validation.Valid;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;


	
	@GetMapping("/students")
	public String listOfStudent(Model model) {
		List<StudentDto> students = studentService.getAllStudent();
		model.addAttribute("students", students);
		return "students";
	}

	@GetMapping("students/new")
	public String newStudent(Model model) {
		StudentDto studentDto = new StudentDto();
		model.addAttribute("student", studentDto);
		return "create_student";
	}

	@PostMapping("/students")
	public String saveStudent(@Valid @ModelAttribute("student") StudentDto student, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("student", student);
			return "create_student";
		}
		studentService.createStudent(student);
		return "redirect:/students";
	}

	@GetMapping("students/{studentId}/edit")
	public String editStudent(@PathVariable("studentId") Long studentId, Model model) {
		StudentDto studentDto = studentService.getStudentById(studentId);
		model.addAttribute("student", studentDto);
		return "edit_student";
	}

	@PostMapping("students/{studentId}")
	public String updateStudent(@PathVariable("studentId") Long studentId,
			@ModelAttribute("student") StudentDto studentDto, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("student", studentDto);
			return "edit_student";
		}
		studentDto.setId(studentId);
		studentService.updateStudent(studentDto);
		return "redirect:/students";

	}

	// handler method to handle delete student request
	@GetMapping("students/{studentId}/delete")
	public String deleteStudent(@PathVariable("studentId") Long studentId) {
		studentService.deleteStudent(studentId);
		return "redirect:/students";
	}

	// handler method to handle view student request
	@GetMapping("students/{studentId}/view")
	public String viewStudent(@PathVariable("studentId") Long studentId, Model model) {
		StudentDto studentDto = studentService.getStudentById(studentId);
		model.addAttribute("student", studentDto);
		return "view_student";
	}

}
