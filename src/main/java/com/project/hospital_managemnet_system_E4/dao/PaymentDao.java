package com.project.hospital_managemnet_system_E4.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hospital_managemnet_system_E4.dto.Payment;
import com.project.hospital_managemnet_system_E4.exception.PaymentIdNotFound;
import com.project.hospital_managemnet_system_E4.repo.PaymentRepo;


@Repository
public class PaymentDao {
		
		@Autowired
		PaymentRepo paymentRepo;
		
		
		public Payment savePayment(Payment payment) {
			return paymentRepo.save(payment);
		}
		
		public Payment updatePaymentById(int oldPaymentId, Payment newPayment) {
			Optional<Payment> payment = paymentRepo.findById(oldPaymentId);
			if (payment.isEmpty()) {
				return null;
			}else {
				return payment.get();
			
//			newPayment.setPaymentId(oldPaymentId);
//		//	return PaymentRepo.save(newPayment);
//			return savePayment(newPayment);
		}
		}
		public Payment fetchPaymentById(int paymentId) {
			Optional<Payment> payment = paymentRepo.findById(paymentId);
			if (payment.isEmpty()) {
				return null;
			}else {
//			return paymentRepo.findById(paymentId).get();
				return payment.get();
		}
}
		public Payment deletePaymentById(int paymentId) {
			Optional<Payment> optionalPayment = paymentRepo.findById(paymentId);
			if(optionalPayment.isPresent()) {
				Payment payment =optionalPayment.get();
				paymentRepo.delete(payment);
				return payment;
			}else {
				throw new PaymentIdNotFound();
			
//		//	Payment Payment=PaymentRepo.findById(PaymentId).get();
//			Payment payment=fetchPaymentById(paymentId);
//			paymentRepo.delete(payment);
//			return payment;
		}
}
		public List<Payment> fetchAllPayment(){
			return paymentRepo.findAll();
		}
}
