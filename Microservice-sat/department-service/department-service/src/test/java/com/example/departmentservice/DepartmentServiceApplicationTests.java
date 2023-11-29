package com.example.departmentservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.departmentservice.dto.DepartmentDto;
import com.example.departmentservice.entity.Department;
import com.example.departmentservice.repository.DepartmentRepository;
import com.example.departmentservice.service.DepartmentService;
import com.example.departmentservice.serviceimpl.DepartmentServiceImpl;

@SpringBootTest
class DepartmentServiceApplicationTests {

		@Autowired
		private DepartmentService departmentService;
	 
		@Test
		void contextLoads() {
			
			
			DepartmentDto inputDto = new DepartmentDto();
			inputDto.setDepartmentName("IT");
			inputDto.setDepartmentDescription("IT INFO");
			inputDto.setDepartmentCode("IT001");
			
		DepartmentDto saveDto = departmentService.saveDepartment(inputDto);
//			
//			assertNotNull(saveDto.getId());
			assertEquals(inputDto.getDepartmentName(), saveDto.getDepartmentName());
			assertEquals(inputDto.getDepartmentDescription(), saveDto.getDepartmentDescription());
			assertEquals(inputDto.getDepartmentCode(), saveDto.getDepartmentCode());
		}

		@Test
		public void testeGetDepartmentByCode() {
			
			Department mockDepartment = new Department();
			mockDepartment.setId(1L);
			mockDepartment.setDepartmentName("R&D");
			mockDepartment.setDepartmentDescription("Research and Development");
			mockDepartment.setDepartmentCode("RD001");
			
			DepartmentRepository mockRepository = mock(DepartmentRepository.class);
			when(mockRepository.findByDepartmentCode("RD001")).thenReturn(mockDepartment);
			
			DepartmentService departmentService = new DepartmentServiceImpl(mockRepository);
			
			DepartmentDto departmentDto = departmentService.getDepartmentByCode("RD001");
			
			assertNotNull(departmentDto);
			assertEquals(1L, departmentDto.getId());
			assertEquals("R&D", departmentDto.getDepartmentName());
			assertEquals("Research and Development", departmentDto.getDepartmentDescription());
			assertEquals("RD001", departmentDto.getDepartmentCode());
				
			
		}
}
