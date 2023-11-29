package com.example.employeeservice.serviceimpl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.employeeservice.dto.APIResponseDto;
import com.example.employeeservice.dto.DepartmentDto;
import com.example.employeeservice.dto.EmployeeDto;
import com.example.employeeservice.dto.OrganizationDto;
import com.example.employeeservice.entity.Employee;
import com.example.employeeservice.mapper.EmployeeMapper;
import com.example.employeeservice.repository.EmployeeRepository;
import com.example.employeeservice.service.APIClient;
import com.example.employeeservice.service.EmployeeService;


import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
//	private RestTemplate restTemplate;
	
	private WebClient webClient;
	
// private APIClient apiClient;
	
	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
		
		Employee savedEmployee= employeeRepository.save(employee);
		 
		EmployeeDto savedEmployeeDto = EmployeeMapper.mapToEmployeeDto(savedEmployee);
		return savedEmployeeDto;
	}

	
//	@CircuitBreaker(name="${spring.application.name}",fallbackMethod = "getDefaultDepartment")
	@Override
	public APIResponseDto getEmployeeById(Long employeeId) {
		
		Employee employee = employeeRepository.findById(employeeId).get();
		
//	ResponseEntity<DepartmentDto> responseEntity =	restTemplate.getForEntity("http://localhost:8080/api/departments/" + employee.getDepartmentCode(), 
//				DepartmentDto.class);
//		
//	DepartmentDto departmentDto = responseEntity.getBody();
		
		DepartmentDto departmentDto = webClient.get()
		.uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
		.retrieve()
		.bodyToMono(DepartmentDto.class)
		.block();
		
	    OrganizationDto organizationDto = webClient.get()
                .uri("http://localhost:8083/api/organizations/" + employee.getOrganizationCode())
                .retrieve()
                .bodyToMono(OrganizationDto.class)
                .block();

	
//		  DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());
		
		EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);
		
		APIResponseDto apiResponseDto = new APIResponseDto();
		apiResponseDto.setEmployee(employeeDto);
		apiResponseDto.setDepartment(departmentDto);
		apiResponseDto.setOrganization(organizationDto);
		
		return apiResponseDto;
	}
//	public APIResponseDto getDefaultDepartment(long employeeId, Exception exception) {
//        Employee employee = employeeRepository.findById(employeeId).get();
//		
//		DepartmentDto departmentDto = new DepartmentDto();
//		departmentDto.setDepartmentName("R&D");
//		departmentDto.setDepartmentDescription("Reasearch and Development");
//		departmentDto.setDepartmentCode("RD001");
//		
//		 OrganizationDto organizationDto = new OrganizationDto();
//		 organizationDto.setOrganizationName("R&D");
//		 organizationDto.setOrganizationDescription("Reasearh");
//		 organizationDto.setOrganizationCode("RO001)");
//				
// 
//				
//				EmployeeDto employeeDto = new EmployeeDto(
//						employee.getId(),
//						employee.getFirstName(),
//						employee.getLastName(),
//						employee.getEmail(),
//						employee.getDepartmentCode(),
//						employee.getOrganizationCode()
//						);
//				
//				APIResponseDto apiResponseDto = new APIResponseDto();
//				apiResponseDto.setEmployee(employeeDto);
//				apiResponseDto.setDepartment(departmentDto);
//				apiResponseDto.setOrganization(organizationDto);
//				
//				return apiResponseDto;
//		
//	}
}
