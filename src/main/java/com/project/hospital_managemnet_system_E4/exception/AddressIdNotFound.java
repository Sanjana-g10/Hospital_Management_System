package com.project.hospital_managemnet_system_E4.exception;

public class AddressIdNotFound  extends RuntimeException{
	
	private String message= "Address Id not found";

	public String getMessage() {
		return message;
	}
	

}
