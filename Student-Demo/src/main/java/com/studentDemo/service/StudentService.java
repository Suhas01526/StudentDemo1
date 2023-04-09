package com.studentDemo.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentDemo.entity.Student;
import com.studentDemo.payload.StudentDto;
import com.studentDemo.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	public StudentDto insertStudent(StudentDto studentDto) {
		Student student=mapToEntity(studentDto);
		Student student1 = studentRepo.save(student);
		StudentDto studentResponse=mapToDto(student1);
		
		return studentResponse;
		
	}
	
	public List<Student> getAllStudent(){
		List<Student> student2=studentRepo.findAll();
		return student2;
	}
	
	public Optional<Student> getStudent(long id){
		Optional<Student> student3=studentRepo.findById(id);
		return student3;
		
	}
	
	public Optional<Student> updateStudent(Student student, long id){
		Optional<Student> updatedStudent=studentRepo.findById(id);
		if(updatedStudent.isPresent()) {
			Student existingStudent = updatedStudent.get();
			existingStudent.setName(student.getName());
			existingStudent.setDob(student.getDob());
			existingStudent.setAddress(student.getAddress());
			 studentRepo.save(existingStudent);
						
		}
		return updatedStudent;
	}
	
	public void deleteStudent(long id) {
		studentRepo.deleteById(id);
	}
	
	public StudentDto mapToDto(Student student) {
		StudentDto studentDto= modelMapper.map(student, StudentDto.class);
		return studentDto;
	}
	
	public Student mapToEntity(StudentDto studentDto) {
		Student student=modelMapper.map(studentDto, Student.class);
		return student;
		
	}
}
