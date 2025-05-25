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
import com.project.hospital_managemnet_system_E4.dto.Hospital;
import com.project.hospital_managemnet_system_E4.service.HospitalService;
import com.project.hospital_managemnet_system_E4.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class HospitalController {
	
	@Autowired
	HospitalService hospitalService;
	
	@Operation(summary = "Save Hospital", description = "API is used to save the Hospital")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Hospital not found for the given id") })
	@PostMapping("/saveHospital")
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(@RequestBody Hospital hospital) {
		return hospitalService.saveHospital(hospital);
	}

	
	@Operation(summary = "Update Hospital", description = "API is used to update the Hospital")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully updated"),
			@ApiResponse(responseCode = "404", description = "Hospital not found for the given id") })
	@PutMapping("/updateHospitalById")
	public ResponseEntity<ResponseStructure<Hospital>> updateHospitalById(@RequestParam  int oldHospitalId, @RequestBody Hospital newHospital) {
		return hospitalService.updateHospitalById(oldHospitalId, newHospital);
	}
	

	@Operation(summary = "Fetch Hospital", description = "API is used to fetch the Hospital")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully fetched"),
			@ApiResponse(responseCode = "404", description = "Hospital not found for the given id") })
	@GetMapping("/fetchHospitalById")
	public ResponseEntity<ResponseStructure<Hospital>> fetchHospitalById(@RequestParam int hospitalId) {
		return hospitalService.fetchHospitalById(hospitalId);
	}
	
	

	@Operation(summary = "Deleted Hospital", description = "API is used to delete the Hospital")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully deleted"),
			@ApiResponse(responseCode = "404", description = "Hospital not found for the given id") })
	@DeleteMapping("/deleteHospitalById")
	public ResponseEntity<ResponseStructure<Hospital>> deleteHospitalById(int hospitalId) {
		return hospitalService.deleteHospitalById(hospitalId);
	}
    

	@Operation(summary = "Fetch all Hospital", description = "API is used to fetch all the Hospital")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully fetched all"),
			@ApiResponse(responseCode = "404", description = "Hospital not found for the given id") })
	@GetMapping("/fetchAllHospital")
	public List<Hospital> fetchAllHospital() {
		return hospitalService.fetchAllHospital();
	}
 
	

	@Operation(summary = "Adding Existing Hospital to Existing branch", description = "API is used to add existing Hospital to existing branch")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully added"),
			@ApiResponse(responseCode = "404", description = "Hospital not found for the given id") })
	@PutMapping("/addExistingHospitalToExistingBranch")
	public ResponseEntity<ResponseStructure<Hospital>> addExistingHospitalToExistingBranch(@RequestParam int hospitalId,@RequestParam int branchId) {
		return hospitalService.addExistingHospitalToExistingBranch(hospitalId, branchId);
	}
	
	

	@Operation(summary = "Adding new branch to existing Hospital", description = "API is used to add new branch to the existing Hospital")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully updated"),
			@ApiResponse(responseCode = "404", description = "Hospita not found for the given id") })
	@PutMapping("/addNewBranchToExistingHospital")
	public ResponseEntity<ResponseStructure<Hospital>> addNewBranchToExistingHospital(@RequestParam int hospitalId,@RequestBody Branch newBranch) {
		return hospitalService.addNewBranchToExistingHospital(hospitalId, newBranch);
	}
}
