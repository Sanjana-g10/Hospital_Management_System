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
import com.project.hospital_managemnet_system_E4.dto.Owner;
import com.project.hospital_managemnet_system_E4.service.OwnerService;
import com.project.hospital_managemnet_system_E4.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;


@RestController
public class OwnerController {

	@Autowired
	OwnerService ownerService;
 
	

	@Operation(summary = "Save Owner", description = "API is used to save the Owner")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Owner not found for the given id") })
   @PostMapping("/saveOwner")
	public ResponseEntity<ResponseStructure<Owner>> saveOwner(@RequestBody Owner owner) {
		return ownerService.saveOwner(owner);
	}

	
	@Operation(summary = "Update Owner", description = "API is used to update the Owner")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully updated"),
			@ApiResponse(responseCode = "404", description = "Owner not found for the given id") })
	@PutMapping("/updateOwnerById")
	public ResponseEntity<ResponseStructure<Owner>> updateOwnerById (@RequestParam int oldOwnerId,@RequestBody Owner newOwner) {

		return ownerService.updateOwnerById(oldOwnerId, newOwner);
	}

	@Operation(summary = "Fetch Owner", description = "API is used to fetch the Owner")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully fetched"),
			@ApiResponse(responseCode = "404", description = "Owner not found for the given id") })	
	@GetMapping("/fetchOwnerById")
	public ResponseEntity<ResponseStructure<Owner>> fetchOwnerById(@RequestParam int ownerId) {
		return ownerService.fetchOwnerById(ownerId);
	}
	@Operation(summary = "Delete Owner", description = "API is used to delete  the Owner")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully deleted"),
			@ApiResponse(responseCode = "404", description = "Owner not found for the given id") })
	@DeleteMapping("/deleteOwnerById")
	public ResponseEntity<ResponseStructure<Owner>> deleteOwnerById(@RequestParam int ownerId) {

		return ownerService.deleteOwnerById(ownerId);
	}
    
	@Operation(summary = "FetchAll Owner", description = "API is used to fetch all the Owner")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully fectched all "),
			@ApiResponse(responseCode = "404", description = "Owner not found for the given id") })
	@GetMapping("/fetchAllOwner")
	public List<Owner> fetchAllOwner() {
		return ownerService.fetchAllOwner();
	}
  
	@Operation(summary = "Adding Existing Hospital to existing Owner", description = "API is used to add existing hospital to existing owner")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully added"),
			@ApiResponse(responseCode = "404", description = "Owner not found for the given id") })
	@PutMapping("/addExistingHospitalToExistingOwner")
	public ResponseEntity<ResponseStructure<Owner>> addExistingHospitalToExistingOwner(@RequestParam int hospitalId, @RequestParam int ownerId) {
	return ownerService.addExistingHospitalToExistingOwner(hospitalId, ownerId);
}
}
	
	

