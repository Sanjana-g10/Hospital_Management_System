package com.project.hospital_managemnet_system_E4.exception;

public class ReportIdNotFound extends RuntimeException {
	private String message= "Report Id not found in data base";

	public String getMessage() {
		return message;
	}
	

}
