package com.example.student.service;
 
import java.util.List;
 
import org.springframework.stereotype.Service;
 
import com.example.student.model.Student;
 
@Service
public interface StudentServ {
 
	Student getByName(String name);
 
	void update(Student student);
 
	List<Student> getAllStudents();
 
	void delete(String name);
 
	Student save(Student student);
 
}