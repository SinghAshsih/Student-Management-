package com.student.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dto.StudentDto;
import com.student.entity.Student;
import com.student.mapper.StudentMapper;
import com.student.repository.StudentRepository;
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<StudentDto> getAllStudent() {
		// TODO Auto-generated method stub
		List<Student> students = studentRepository.findAll();
		List<StudentDto> studentDto = students.stream().map((student) -> StudentMapper.mapToStudentDto(student))
				.collect(Collectors.toList());
		return studentDto;
	}

	@Override
	public void createStudent(StudentDto studentDto) {
		// TODO Auto-generated method stub
		studentRepository.save(StudentMapper.mapToStudent(studentDto));
	}

	@Override
	public void updateStudent(StudentDto studentDto) {
		// TODO Auto-generated method stub
		studentRepository.save(StudentMapper.mapToStudent(studentDto));
	}

	@Override
	public void deleteStudent(Long id) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(id);
	}

	@Override
	public StudentDto getStudentById(Long id) {
		// TODO Auto-generated method stub
		Student student = studentRepository.findById(id).get();
		StudentDto StudentDto = StudentMapper.mapToStudentDto(student);
		return StudentDto;
	}

}
