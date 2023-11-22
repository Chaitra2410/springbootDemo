package com.example.signup.SignUp.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.signup.SignUp.model.SignUpModel;

@Repository
public interface SignUpRepository extends MongoRepository<SignUpModel,String>{

}
