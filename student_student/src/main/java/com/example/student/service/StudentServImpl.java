package com.example.student.service;
 
import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.example.student.model.Student;
import com.example.student.repo.StudentRepo;
 
@Service
public class StudentServImpl implements StudentServ {
 
	@Autowired
	StudentRepo repo;
 
	@Override
	public Student getByName(String name) {
		return repo.findByName(name);
	}
 
	@Override
	public List<Student> getAllStudents() {
		List<Student> students = new ArrayList<Student>();
		repo.findAll().forEach(student1 -> students.add(student1));
		return students;
	}
 
	@Override
	public void update(Student student) {
		Student s = new Student();
		s.setName(student.getName());
		s.setAge(student.getAge());
		s.setSalary(student.getSalary());
		repo.save(student);
	}
 
	@Override
	public void delete(String name) {
		repo.deleteByName(name);
 
	}
 
	@Override
	public Student save(Student student) {
		return repo.save(student);
	}
 
}
 