package com.example.springboot;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Spring Boot Rest API Documentation",
description = "Spring Boot Rest API Documentation description",
version = "v1.0",
contact = @Contact(
		name = "Chaitra",
		email = "",
		url = "https://www.w3schools.com"
	), license = @License(
			name = "Apache 2.0",
			url = ""
			)),
externalDocs = @ExternalDocumentation(
				description = "External Doc",
				url = ""
				))
public class SpringbootRestfulWebservicesApplication {
	

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestfulWebservicesApplication.class, args);
	}

}
