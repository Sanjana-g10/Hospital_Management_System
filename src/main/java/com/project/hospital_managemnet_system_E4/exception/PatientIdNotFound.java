package com.project.hospital_managemnet_system_E4.exception;

public class PatientIdNotFound  extends RuntimeException{
	 private String message= "patient Id not found in data base";

	public String getMessage() {
		return message;
	}
	 

}
