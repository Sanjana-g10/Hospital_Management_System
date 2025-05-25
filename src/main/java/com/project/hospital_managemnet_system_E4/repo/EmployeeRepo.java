package com.project.hospital_managemnet_system_E4.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.hospital_managemnet_system_E4.dto.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
