package com.example.springboot.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.example.springboot.dto.UserDto;
import com.example.springboot.entity.User;
import com.example.springboot.exception.EmailAlreadyExistsException;
import com.example.springboot.exception.ErrorDetails;
import com.example.springboot.exception.ResourceNotFoundException;
import com.example.springboot.sevice.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Tag(
		name ="CRUD REST APTs for User Resource",
		description="CRUD REST APTs- Create,Update,GetAll,Get,Delete user")
@RestController
//@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Operation(summary = "POST API", description = "Post description")
	@ApiResponse(responseCode = "201", description = "201 - Created")
	 @PostMapping("/create")
	    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user){
	        UserDto savedUser = userService.createUser(user);
	        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	    }
	 
	@Operation(summary = "GET API", description = "GET description")
	@ApiResponse(responseCode = "200", description = "200 - Success")
	   @GetMapping("{id}")
	    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId){
	        UserDto user = userService.getUserById(userId);
	        return new ResponseEntity<>(user, HttpStatus.OK);
	    }
	   
	@Operation(summary = "GET API", description = "GET description")
	@ApiResponse(responseCode = "200", description = "200 - Success")
	   @GetMapping("")
	   public ResponseEntity<List<UserDto>> getAllUsers(){
		   List<UserDto> users = userService.getAllUsers();
		   return new ResponseEntity<>(users, HttpStatus.OK);
	   }
	
	@Operation(summary = "DELETE API", description = "DELETE description")
	@ApiResponse(responseCode = "200", description = "200 - Success")
	   @DeleteMapping("{id}")
	    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
	        userService.deleteUser(userId);
	        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
	    }
	   

	@Operation(summary = "PUT API", description = "UPDATE description")
	@ApiResponse(responseCode = "200", description = "200 - Success")
	   @PutMapping("{id}")
	   public ResponseEntity<UserDto> updateUser(@PathVariable("id")Long userId,
			   @Valid @RequestBody UserDto user){
	   user.setId(userId);
	   UserDto updateUser = userService.updateUser(user);
	   return new ResponseEntity<>(updateUser,HttpStatus.OK);
}
//	    @ExceptionHandler(ResourceNotFoundException.class)
//	    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,
//	                                                                        WebRequest webRequest){
//	
//	        ErrorDetails errorDetails = new ErrorDetails(
//	                LocalDateTime.now(),
//	                exception.getMessage(),
//	                webRequest.getDescription(false),
//	                "USER_NOT_FOUND"
//	        );
//	
//	        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
//	    } 
	    
}