package com.example.departmentservice.serviceimpl;

import org.springframework.stereotype.Service;

import com.example.departmentservice.dto.DepartmentDto;
import com.example.departmentservice.entity.Department;
import com.example.departmentservice.mapper.DepartmentMapper;
import com.example.departmentservice.repository.DepartmentRepository;
import com.example.departmentservice.service.DepartmentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{
	
	private DepartmentRepository departmentRepository;
	
	@Override
	public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
		
		// convert department dto to department jpa entity
		Department department = DepartmentMapper.mapToDepartment(departmentDto); 
		
		Department savedDepartment = departmentRepository.save(department);
		
		DepartmentDto savedDepartmentDto = DepartmentMapper.mapToDepartmentDto(savedDepartment);
		
		return savedDepartmentDto;
	}

	@Override
	public DepartmentDto getDepartmentByCode(String departmentcode) {
		
		Department department = departmentRepository.findByDepartmentCode(departmentcode);
		
		DepartmentDto departmentDto = DepartmentMapper.mapToDepartmentDto(department);
		return departmentDto;
	}

}
