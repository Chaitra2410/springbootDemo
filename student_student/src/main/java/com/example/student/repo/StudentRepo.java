package com.example.student.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.student.model.Student;

@Repository
public interface StudentRepo extends MongoRepository<Student, String> {

	Student findByName(String name);
	 
	Student deleteByName(String name);
}
