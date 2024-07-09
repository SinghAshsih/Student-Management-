package com.student.mapper;

import com.student.dto.StudentDto;
import com.student.entity.Student;

public class StudentMapper {

	// Converting Student object to StudentDto
	public static StudentDto mapToStudentDto(Student student) {
		StudentDto studentDto = new StudentDto(student.getId(), student.getFirstName(), student.getLastName(),
				student.getEmail());
		return studentDto;
	}

	// Converting StudentDto to Student
	public static Student mapToStudent(StudentDto studentDto) {
		Student student = new Student(studentDto.getId(), studentDto.getFirstName(), studentDto.getLastName(),
				studentDto.getEmail());
		return student;
	}

}
