package com.project.hospital_managemnet_system_E4.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.hospital_managemnet_system_E4.dto.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Integer> {

}
