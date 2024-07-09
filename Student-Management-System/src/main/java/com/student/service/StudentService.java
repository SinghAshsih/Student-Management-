package com.student.service;

import java.util.List;

import com.student.dto.StudentDto;

public interface StudentService {
	List<StudentDto> getAllStudent();

	public void createStudent(StudentDto studentDto);

	public void updateStudent(StudentDto studentDto);

	public void deleteStudent(Long id);
	
	StudentDto getStudentById(Long id);
}
