package com.example.springbootrestapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.springbootrestapi.bean.Student;

@RestController
@RequestMapping("students")
public class StudentController {
  
	@GetMapping("student")
	public ResponseEntity<Student> getStudent() {
		Student student = new Student(
				1,
		          "Chaitra",
		          "R"
				);
//		return ResponseEntity.ok(student);
		return ResponseEntity.ok()
                .header("custom-header", "ramesh")
                .body(student);
	}
	
	@GetMapping
	public ResponseEntity<List<Student>> getStudents(){
	 List<Student> students = new ArrayList<>();
	 students.add(new Student(1,"Anu","Gupta"));
	 students.add(new Student(2,"Rakesh","Sharma"));
	 students.add(new Student(3,"Supriya","M"));
	return ResponseEntity.ok(students);
	
}
	 // Spring BOOT REST API with Path Variable
    // {id} - URI template variable
	@GetMapping("{id}/{first-name}/{last-name}")
	public Student studentPathVariablr(@PathVariable("id") int studentId,
			@PathVariable("first-name") String firstName, 
			@PathVariable("last-name") String lastName) {
		return new Student(studentId,firstName,lastName);
		
	}
	

    // Spring boot REST API with Request Param
    //  http://localhost:8080/students/query?id=1&firstName=Chaitra&lastName=R
	 
	@GetMapping("query")
	public ResponseEntity<Student> studentRequestParam(@RequestParam int id,
			@RequestParam String firstName,
			@RequestParam String lastName
			) {
		Student student = new Student(id,firstName,lastName);
		return ResponseEntity.ok(student);
	}
	
	// Spring boot REST API that handles HTTP POST Request - creating new resource
    // @PostMapping and @RequestBody
	@PostMapping("create")
//	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		System.out.println(student.getId());
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		return new ResponseEntity<>(student,HttpStatus.CREATED);
	}
	
	 // Spring boot REST API that handles HTTP PUT Request - updating existing resource
	@PutMapping("{id}/update")
	public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId) {
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		return student;
	}
	 
	 // Spring boot REST API that handles HTTP DELETE Request - deleting the existing resource
	@DeleteMapping("{id}/delete")
	public String deleteStudent(@PathVariable("id") int studentId) {
		System.out.println(studentId);
		return "Student deleted successfully!";
		
	}
}