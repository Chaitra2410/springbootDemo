package com.example.springboot.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@Schema(description="UserDTO Model Information")
public class UserDto {
		
	 	private Long id;
	 	
	 	@Schema(description="User firstName")
	 	//first name should not be null
	 	@NotEmpty(message = "User firstName should not be null or empty")
	    private String firstName;
	 	
	 	@Schema(description="User lastName")
	 	@NotEmpty(message = "User lastName should not be null or empty")
	    private String lastName;
	 	
	 	@Schema(description="User Email")
	 	//Email should be valid
	 	@NotEmpty(message = "User email should not be null or empty")
	 	@Email(message = "Email Address should be valid")
	    private String email;
	    
	    
		public UserDto() {
			super();
			// TODO Auto-generated constructor stub
		}
		public UserDto(Long id, String firstName, String lastName, String email) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		@Override
		public String toString() {
			return "UserDto [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
					+ "]";
		}
	    
	    

}
