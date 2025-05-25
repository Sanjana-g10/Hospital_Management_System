package com.project.hospital_managemnet_system_E4.exception;

public class OwnerIdNotFound extends RuntimeException {
 private String message = "owner Id not found in the database";

public String getMessage() {
	return message;
}
 
}
