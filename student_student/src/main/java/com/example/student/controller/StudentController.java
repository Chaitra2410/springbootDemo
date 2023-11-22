package com.example.student.controller;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.example.student.model.Student;
import com.example.student.service.StudentServImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
@RestController
public class StudentController {
 
	@Autowired
	private StudentServImpl serv;
	private static final Logger log = LoggerFactory.getLogger(StudentController.class);
	 
 
	@GetMapping("/allStudents")
	private List<Student> getAllStudents() {
		log.info("Get All Student data");
		return serv.getAllStudents();
	}
 
	@GetMapping("/student/{name}")
	private Student getStudent(@PathVariable("name") String name) {
		log.info("Get data of particular student");
		return serv.getByName(name);
	}
 
	@PutMapping("/students/{name}")
	private Student update(@RequestBody Student student) {
		log.info("Update Data");
		serv.update(student);
		return student;
	}
 
	@DeleteMapping("/delete/{name}")
	private void delete(@PathVariable("name") String name) {
		log.info("Deleted data");
		serv.delete(name);
	}
 
	@PostMapping("/addStudent")
	private Student add(@RequestBody Student student) {
		log.info("Add student data successfully");
		return serv.save(student);
	}
 
}
 