package com.project.hospital_managemnet_system_E4.exception;

public class HospitalIdNotFound  extends RuntimeException{
	private String message="Hospital Id not found in database";

	public String getMessage() {
		return message;
	}
	 

}
