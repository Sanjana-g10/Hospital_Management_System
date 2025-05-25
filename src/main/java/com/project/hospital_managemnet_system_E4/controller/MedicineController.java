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

import com.project.hospital_managemnet_system_E4.dto.Medicine;
import com.project.hospital_managemnet_system_E4.service.MedicineService;
import com.project.hospital_managemnet_system_E4.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
public class MedicineController {

	
	@Autowired
	MedicineService medicineService;

	
	
	@Operation(summary = "Save Medicine", description = "API is used to save  the medicine")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Medicine not found for the given id") })
	@PostMapping("/saveMedicine")
	public ResponseEntity<ResponseStructure<Medicine>> saveMedicine(@RequestBody Medicine medicine) {
		return medicineService.saveMedicine(medicine);
	}

	
	@Operation(summary = "Update Medicine", description = "API is used to update the medicine")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully updated"),
			@ApiResponse(responseCode = "404", description = "Medicine not found for the given id") })
	@PutMapping("/updateMedicineById")
	public ResponseEntity<ResponseStructure<Medicine>> updateMedicineById (@RequestParam int oldMedicineId,@RequestBody Medicine newMedicine) {
       return medicineService.updateMedicineById(oldMedicineId, newMedicine);
	}

	
	@Operation(summary = "Fetch Medicine", description = "API is used to fetch  the medicine")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully fetched"),
			@ApiResponse(responseCode = "404", description = "Medicine not found for the given id") })
	@GetMapping("/fetchMedicineById")
	public ResponseEntity<ResponseStructure<Medicine>> fetchMedicineById(@RequestParam int medicineId) {
		return medicineService.fetchMedicineById(medicineId);
	}

	@Operation(summary = "Delete Medicine", description = "API is used to delete  the medicine")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully deleted"),
			@ApiResponse(responseCode = "404", description = "Medicine not found for the given id") })
	@DeleteMapping("/deleteMedicineById")
	public ResponseEntity<ResponseStructure<Medicine>> deleteMedicineById(@RequestParam int medicineId) {

		return medicineService.deleteMedicineById(medicineId);
	}

	
	@Operation(summary = "Fetch all Medicines", description = "API is used to fetch all the medicines")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully fetched all"),
			@ApiResponse(responseCode = "404", description = "Medicine not found for the given id") })
	@GetMapping("/fetchAllMedicine")
	public List<Medicine> fetchAllMedicine() {
		return medicineService.fetchAllMedicine();
	}
}
