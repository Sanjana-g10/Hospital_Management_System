package com.project.hospital_managemnet_system_E4.exception;

public class EncounterIdNotFound  extends RuntimeException{
	private String message= "Encounter id not found in data base";

	public String getMessage() {
		return message;
	}
	

}
