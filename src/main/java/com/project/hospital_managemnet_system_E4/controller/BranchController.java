package com.project.hospital_managemnet_system_E4.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.project.hospital_managemnet_system_E4.dto.Branch;
import com.project.hospital_managemnet_system_E4.dto.Patient;
import com.project.hospital_managemnet_system_E4.service.BranchService;
import com.project.hospital_managemnet_system_E4.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class BranchController {

	@Autowired
	BranchService branchService;
	

	@Operation(summary = "Save Branch", description = "API is used to save  the branch")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Branch not found for the given id") })
	@PostMapping("/saveBranch")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody Branch branch) {
		return branchService.saveBranch(branch);
	}
	
	@Operation(summary = "Update Branch", description = "API is used to update the branch")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully updated"),
			@ApiResponse(responseCode = "404", description = "Branch not found for the given id") })
	@PutMapping("/updateBranchById")
	public ResponseEntity<ResponseStructure<Branch>> updateBranchById(@RequestParam  int oldBranchId, @RequestBody Branch newBranch) {
		return branchService.updateBranchById(oldBranchId, newBranch);
	}
	
	@Operation(summary = "Fetch Branch", description = "API is used to fetch the branch")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully fetched"),
			@ApiResponse(responseCode = "404", description = "Branch not found for the given id") })
	@GetMapping("/fetchBranchById")
	public ResponseEntity<ResponseStructure<Branch>> fetchBranchById(@RequestParam int branchId) {
		return branchService.fetchBranchById(branchId);
	}
	@Operation(summary = "Delete Branch", description = "API is used to delete the branch")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully deleted"),
			@ApiResponse(responseCode = "404", description = "Branch not found for the given id") })
	@DeleteMapping("/deleteBranchById")
	public ResponseEntity<ResponseStructure<Branch>> deleteBranchById(int branchId) {
		return branchService.deleteBranchById(branchId);
	}
	@Operation(summary = "Fetch all Branch", description = "API is used to fetch alln the branch")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully fetched all"),
			@ApiResponse(responseCode = "404", description = "Branch not found for the given id") })
	@GetMapping("/fetchAllBranch")
	public List<Branch> fetchAllBranch() {
		return branchService.fetchAllBranch();
	}
	
	@Operation(summary = "Add existing address to existing Branch", description = "API is used to add existing address to existing branch")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully added"),
			@ApiResponse(responseCode = "404", description = "Branch not found for the given id") })
	@PutMapping("/addExistingAddressToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addExistingAddressToExistingBranch(@RequestParam int addressId, @RequestParam int branchId) {
	return branchService.addExistingAddressToExistingBranch(addressId, branchId);
}
	
	
	@Operation(summary = "Adding existing branch head to the Existing Branch", description = "API is used to add existing branch head to existing branch")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully added"),
			@ApiResponse(responseCode = "404", description = "Branch not found for the given id") })
	@PutMapping("/addExistingBranchHeadToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addExistingBranchHeadToExistingBranch(@RequestParam int branchHeadId, @RequestParam int branchId) {
		return branchService.addExistingBranchHeadToExistingBranch(branchHeadId, branchId);
	}
	
	
	@Operation(summary = "Adding existing branch to existing Patient", description = "API is used to add existing branch to existing patient")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully added"),
			@ApiResponse(responseCode = "404", description = "Branch not found for the given id") })
	@PutMapping("/addExistingBranchToExistingPatient")
	public ResponseEntity<ResponseStructure<Branch>> addExistingBranchToExistingPatient(@RequestParam int branchId, @RequestParam int patientId) {
		return branchService.addExistingBranchToExistingPatient(branchId, patientId);
	}
	
	@Operation(summary = "Adding new patient to existing branch", description = "API is used to add new patient to the existing branch")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Branch not found for the given id") })
    
	@PutMapping("/addNewPatientToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addNewPatientToExistingBranch(@RequestParam int branchId, @RequestBody Patient newPatient) {
		return branchService.addNewPatientToExistingBranch(branchId, newPatient);
	}
}
