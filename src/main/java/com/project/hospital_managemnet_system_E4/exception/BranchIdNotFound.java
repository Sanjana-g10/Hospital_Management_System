package com.project.hospital_managemnet_system_E4.exception;

public class BranchIdNotFound extends RuntimeException {
	private String message = "Branch Id not found in database";

	public String getMessage() {
		return message;
	}
	

}
