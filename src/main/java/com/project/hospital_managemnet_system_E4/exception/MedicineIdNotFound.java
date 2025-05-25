package com.project.hospital_managemnet_system_E4.exception;

public class MedicineIdNotFound extends RuntimeException {
	
	private String message= "medicine id not found in data base";

	public String getMessage() {
		return message;
	}
	

}
