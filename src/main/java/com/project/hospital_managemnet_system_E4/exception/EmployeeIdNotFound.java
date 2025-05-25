package com.project.hospital_managemnet_system_E4.exception;

public class EmployeeIdNotFound  extends RuntimeException{
	
	private String message= "Employee Id not found in database";

	public String getMessage() {
		return message;
	}
	

}
