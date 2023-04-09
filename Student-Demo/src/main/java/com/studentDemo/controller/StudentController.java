package com.studentDemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.studentDemo.entity.Student;
import com.studentDemo.payload.StudentDto;
import com.studentDemo.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	@PostMapping("/insertStudent")
	public ResponseEntity<StudentDto> insertStudent(@RequestBody StudentDto studentDto){
		
		StudentDto student1=studentService.insertStudent(studentDto);
		return new ResponseEntity<StudentDto>(student1,HttpStatus.CREATED);
	}
	@GetMapping("/getAllStudent")
	public List<Student> getAllStudent(){
		return studentService.getAllStudent();
	}
	@GetMapping("/getStudent/{id}")
	public Optional<Student> getStudent(@PathVariable(value="id") long id) {
		Optional<Student> student2= studentService.getStudent(id);
		return student2;
	}
	@PutMapping("/updateStudent/{id}")
	public Optional<Student> updateStudent(@RequestBody Student student, @PathVariable(value="id") long id){
		Optional<Student> student3=studentService.updateStudent(student, id);
		return student3;
	}
	@DeleteMapping("/deleteStudent/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable(value="id") long id ){
		studentService.deleteStudent(id);
        return new ResponseEntity<String>("Student Deleted Successfully", HttpStatus.ACCEPTED);
	}
	
	
	

}
