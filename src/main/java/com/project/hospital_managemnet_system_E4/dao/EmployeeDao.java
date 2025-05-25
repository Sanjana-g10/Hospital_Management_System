package com.project.hospital_managemnet_system_E4.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.project.hospital_managemnet_system_E4.dto.Employee;
import com.project.hospital_managemnet_system_E4.exception.EmployeeIdNotFound;
import com.project.hospital_managemnet_system_E4.repo.EmployeeRepo;
@Repository
public class EmployeeDao {

	
	@Autowired
	EmployeeRepo employeeRepo;
	
	
	public Employee saveEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}
	
	public Employee updateEmployeeById(int oldEmployeeId, Employee newEmployee) {
		Optional<Employee> employee = employeeRepo.findById(oldEmployeeId);
		if (employee.isEmpty()) {
			return null;
		}else {
			return employee.get();
		}
//		newEmployee.setEmployeeId(oldEmployeeId);
//	//	return EmployeeRepo.save(newEmployee);
//		return saveEmployee(newEmployee);
	}
	
	public Employee fetchEmployeeById(int EmployeeId) {
		Optional<Employee> employee = employeeRepo.findById(EmployeeId);
		if (employee.isEmpty()) {
			return null;
		}else {
			return employee.get();
		}

	}
	
	public Employee deleteEmployeeById(int EmployeeId) {
		Optional<Employee> optionalEmployee = employeeRepo.findById(EmployeeId);
		if(optionalEmployee.isPresent()) {
			return null;
		}else {
		  throw new EmployeeIdNotFound();
		}
	}
	
	public List<Employee> fetchAllEmployee(){
		return employeeRepo.findAll();
	}

}
