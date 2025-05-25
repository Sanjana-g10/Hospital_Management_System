package com.project.hospital_managemnet_system_E4.exception;

public class BranchHeadIdNotFound extends RuntimeException{
	private String message= "Branch Head Id not found in data base";

	public String getMessage() {
		return message;
	}
	

}
