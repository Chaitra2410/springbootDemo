package com.example.employeeservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeeservice.dto.APIResponseDto;
import com.example.employeeservice.dto.EmployeeDto;
import com.example.employeeservice.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/employees")
@Tag(
		name ="Employee Service - EmployeeController",
		description="Employee Controller Exposes REST API's for Deparment-Service")
public class EmployeeController {

	private EmployeeService employeeService;
	
	@Operation(summary = "Save the Rest API", description = "Post description")
	@ApiResponse(responseCode = "201", description = "201 - Created")
	@PostMapping
	public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
		EmployeeDto savedEmployee= employeeService.saveEmployee(employeeDto);
		return new ResponseEntity<>(savedEmployee,HttpStatus.CREATED);
	}
	
	@Operation(summary = "Get the Rest API", description = "GET description")
	@ApiResponse(responseCode = "200", description = "200 - OK")
	@GetMapping("{id}")
	public ResponseEntity<APIResponseDto> getEmployee(@PathVariable("id") Long employeeId){
		APIResponseDto apiResponseDto = employeeService.getEmployeeById(employeeId);
		return new ResponseEntity<>(apiResponseDto,HttpStatus.OK);
	}
}
