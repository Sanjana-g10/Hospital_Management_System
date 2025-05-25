package com.project.hospital_managemnet_system_E4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.hospital_managemnet_system_E4.dao.PaymentDao;
import com.project.hospital_managemnet_system_E4.dto.Payment;
import com.project.hospital_managemnet_system_E4.exception.PaymentIdNotFound;
import com.project.hospital_managemnet_system_E4.util.ResponseStructure;


@Service
public class PaymentService {

	
	
	
	@Autowired
	PaymentDao paymentDao;
	
	@Autowired
	ResponseStructure<Payment> responseStructure;

	public ResponseEntity<ResponseStructure<Payment>> savePayment(Payment payment) {
		responseStructure.setMessage("Successfully payment created");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(paymentDao.savePayment(payment));
		return new ResponseEntity<ResponseStructure<Payment>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Payment>> updatePaymentById(int oldPaymentId, Payment newPayment) {
		Payment payment = paymentDao.fetchPaymentById(oldPaymentId);
		if (payment!= null) {
			responseStructure.setMessage("Successfully payment updated by Id");
	        responseStructure.setStatusCode(HttpStatus.OK.value());
	        responseStructure.setData(paymentDao.updatePaymentById(oldPaymentId, newPayment));
			return new ResponseEntity<ResponseStructure<Payment>>(responseStructure, HttpStatus.OK);
		}else {
			throw new PaymentIdNotFound();
		}
        
	}

	public ResponseEntity<ResponseStructure<Payment>> fetchPaymentById(int paymentId) {
		Payment payment = paymentDao.fetchPaymentById(paymentId);
		if (payment != null) {
			responseStructure.setMessage("Successfully payment fetched by Id");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(paymentDao.fetchPaymentById(paymentId));
			return new ResponseEntity<ResponseStructure<Payment>>(responseStructure, HttpStatus.FOUND);
		}else {
			throw new PaymentIdNotFound();
		}
		
	}

	public ResponseEntity<ResponseStructure<Payment>> deletePaymentById(int paymentId) {
		Payment payment = paymentDao.fetchPaymentById(paymentId);
		if(payment != null) {
			  responseStructure.setMessage("Successfully payement deleted by ID");
		         responseStructure.setStatusCode(HttpStatus.OK.value());
		         responseStructure.setData(paymentDao.deletePaymentById(paymentId));
				return new ResponseEntity<ResponseStructure<Payment>>(responseStructure, HttpStatus.OK);
		}else {
			throw new PaymentIdNotFound();
		}
       
	}

	public List<Payment> fetchAllPayment() {
		return paymentDao.fetchAllPayment();
	}
}

