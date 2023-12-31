package com.example.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description="Employee Model Info")
public class EmployeeDto {

	private Long id;
	@Schema(description="Employee First Name")
    private String firstName;
	@Schema(description="Employee Last Name")
    private String lastName;
	@Schema(description="Employee Email")
    private String email;
	@Schema(description="Employee Department Code")
    private String departmentCode;
	@Schema(description="Employee Organization Code")
    private String organizationCode;
}
