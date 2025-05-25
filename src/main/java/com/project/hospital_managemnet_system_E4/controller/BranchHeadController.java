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
import com.project.hospital_managemnet_system_E4.dto.BranchHead;
import com.project.hospital_managemnet_system_E4.service.BranchHeadService;
import com.project.hospital_managemnet_system_E4.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class BranchHeadController {

	@Autowired
	BranchHeadService branchHeadService;
	
	@Operation(summary = "Save BranchHead", description = "API is used to save  the branchHead")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Branch Head not found for the given id") })
	@PostMapping("/saveBranchHead")
	public ResponseEntity<ResponseStructure<BranchHead>> saveBranchHead(@RequestBody BranchHead branchHead) {
		return branchHeadService.saveBranchHead(branchHead);
	}
	
	
	@Operation(summary = "Update BranchHead", description = "API is used to update the branchHead")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully updated"),
			@ApiResponse(responseCode = "404", description = "Branch Head not found for the given id") })
	@PutMapping("/updateBranchHeadById")
	public ResponseEntity<ResponseStructure<BranchHead>> updateBranchById(@RequestParam  int oldBranchHeadId, @RequestBody BranchHead newBranchHead) {
		return branchHeadService.updateBranchHeadById(oldBranchHeadId, newBranchHead);
	}
	
	@Operation(summary = "Fetch BranchHead", description = "API is used to fetch the branchHead")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully fetched"),
			@ApiResponse(responseCode = "404", description = "Branch Head not found for the given id") })
	@GetMapping("/fetchBranchHeadById")
	public ResponseEntity<ResponseStructure<BranchHead>> fetchBranchHeadById(@RequestParam int branchHeadId) {
		return branchHeadService.fetchBranchHeadById(branchHeadId);
	}
	
	@Operation(summary = "Delete BranchHead", description = "API is used to delete  the branchHead")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully deleted"),
			@ApiResponse(responseCode = "404", description = "Branch Head not found for the given id") })
	@DeleteMapping("/deleteBranchHeadById")
	public ResponseEntity<ResponseStructure<BranchHead>> deleteBranchHeadById(int branchHeadId) {
		return branchHeadService.deleteBranchHeadById(branchHeadId);
	}
	
	@Operation(summary = "Fetch all BranchHead", description = "API is used to fetch all the branchHead")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully fetched all"),
			@ApiResponse(responseCode = "404", description = "Branch Head not found for the given id") })
	@GetMapping("/fetchAllBranchHead")
	public List<BranchHead> fetchAllBranchHead() {
		return branchHeadService.fetchAllBranchHead();
	}
}
