package com.example.departmentservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.departmentservice.dto.DepartmentDto;
import com.example.departmentservice.service.DepartmentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
@Tag(
		name ="Department Service - DepartmentController",
		description="Department Controller Exposes REST API's for Deparment-Service")
public class DepartmentController {
 
	private DepartmentService departmentService;
	
	@Operation(summary = "Save the Rest API", description = "Post description")
	@ApiResponse(responseCode = "201", description = "201 - Created")
	@PostMapping
	public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {
	DepartmentDto savedDepartment= departmentService.saveDepartment(departmentDto);
		return new ResponseEntity<>(savedDepartment,HttpStatus.CREATED);
	}
	

	@Operation(summary = "GET Department Rest API", description = "Get description")
	@ApiResponse(responseCode = "200", description = "200 - OK")
	@GetMapping("{department-code}")
	public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String departmentCode){
		DepartmentDto departmentDto = departmentService.getDepartmentByCode(departmentCode);
		return new ResponseEntity<>(departmentDto,HttpStatus.OK) ;
		
	}
}
