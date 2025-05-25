package com.project.hospital_managemnet_system_E4.exception;

public class RoomIdNotFound extends RuntimeException {
	private String message= "Room id not found in data base";

	public String getMessage() {
		return message;
	}
	

}
