package com.example.signup.SignUp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.signup.SignUp.model.SignUpModel;
import com.example.signup.SignUp.repo.SignUpRepository;

@Service
public class SignUpService {
	
	@Autowired
	SignUpRepository repo;

	public void savedata(SignUpModel model) {
		
		repo.save(model);
	}
	
	
	
}
