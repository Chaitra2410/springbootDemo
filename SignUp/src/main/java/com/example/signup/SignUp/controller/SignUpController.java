package com.example.signup.SignUp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.signup.SignUp.model.SignUpModel;
import com.example.signup.SignUp.service.SignUpService;

@RestController
//@CrossOrigin("*")
//@CrossOrigin(origins = "*", allowedHeaders="*")
@RequestMapping("/SignUpcontroller")
public class SignUpController {
	
	@Autowired
	SignUpService service;
	
	@PostMapping("/save")
	private String saveUser(@RequestBody SignUpModel model)
	{
		service.savedata(model);
		return "saved";
	}
	
}
