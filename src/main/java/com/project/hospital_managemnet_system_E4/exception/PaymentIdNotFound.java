package com.project.hospital_managemnet_system_E4.exception;

public class PaymentIdNotFound extends RuntimeException {
	 private String message= "Payment id not found in data base";

	public String getMessage() {
		return message;
	}
	 

}
