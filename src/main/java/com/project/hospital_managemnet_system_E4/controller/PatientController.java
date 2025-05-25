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

import com.project.hospital_managemnet_system_E4.dto.Encounter;
import com.project.hospital_managemnet_system_E4.dto.Medicine;
import com.project.hospital_managemnet_system_E4.dto.Patient;
import com.project.hospital_managemnet_system_E4.dto.Payment;
import com.project.hospital_managemnet_system_E4.service.PatientService;
import com.project.hospital_managemnet_system_E4.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;




@RestController
public class PatientController {
	@Autowired
     PatientService patientService;

	@Operation(summary = "Save Patient", description = "API is used to save  the patient")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Patient not found for the given id") })
	@PostMapping("/savePatient")
	public ResponseEntity<ResponseStructure<Patient>> savePatient(@RequestBody Patient patient) {
		return patientService.savePatient(patient);
	}
	
	
	@Operation(summary = "Update Patient", description = "API is used to Update the patient")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully updated"),
			@ApiResponse(responseCode = "404", description = "Patient not found for the given id") })

	@PutMapping("/updatePatientById")
	public ResponseEntity<ResponseStructure<Patient>> updatePatientById (@RequestParam int oldPatientId,@RequestBody Patient newPatient) {

		return patientService.updatePatientById(oldPatientId, newPatient);
	}
	
	@Operation(summary = "Fetch Patient", description = "API is used to fetch the patient")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully fetched"),
			@ApiResponse(responseCode = "404", description = "Patient not found for the given id") })

	@GetMapping("/fetchPatientById")
	public ResponseEntity<ResponseStructure<Patient>> fetchPatientById(@RequestParam int patientId) {
		return patientService.fetchPatientById(patientId);
	}
	
	@Operation(summary = "Delete Patient", description = "API is used to delete the patient")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully deleted"),
			@ApiResponse(responseCode = "404", description = "Patient not found for the given id") })

	@DeleteMapping("/deletePatientById")
	public ResponseEntity<ResponseStructure<Patient>> deletePatientById(@RequestParam int patientId) {
		return patientService.deletePatientById(patientId);
	}

	@Operation(summary = "Fetch all Patients", description = "API is used to fetch all the patients")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully fetched"),
			@ApiResponse(responseCode = "404", description = "Patient not found for the given id") })
	@GetMapping("/fetchAllPatient")
	public List<Patient> fetchAllPatient() {
		return patientService.fetchAllPatient();
	}
	
	
	@Operation(summary = "Adding existing report to existing Patient", description = "API is used to add existing report to existing patient")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully added"),
			@ApiResponse(responseCode = "404", description = "Patient not found for the given id") })
	@PutMapping("/addExistingReportToExistingPatient")
	public ResponseEntity<ResponseStructure<Patient>> addExistingReportToExistingPatient(@RequestParam int reportId, @RequestParam int patientId) {
		return patientService.addExistingReportToExistingPatient(reportId, patientId);
	

}
	@Operation(summary = "Adding existing Room to existing Patient", description = "API is used to add existing room to existing patient")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully added"),
			@ApiResponse(responseCode = "404", description = "Patient not found for the given id") })
	@PutMapping("/addExistingRoomToExistingPatient")
	public ResponseEntity<ResponseStructure<Patient>> addExistingRoomToExistingPatient(@RequestParam int roomId, @RequestParam int patientId) {
		return patientService.addExistingRoomToExistingPatient(roomId, patientId);
	}
	
	@Operation(summary = "Adding Existing patient to existing Encounter", description = "API is used to add existing patient to existing encounter")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully added"),
			@ApiResponse(responseCode = "404", description = "Patient not found for the given id") })
	@PutMapping("/addExistingPatientToExistingEncounter")
	public ResponseEntity<ResponseStructure<Patient>> addExistingPatientToExistingEncounter(@RequestParam int patientId, @RequestParam int encounterId) {
		return patientService.addExistingPatientToExistingEncounter(patientId, encounterId);
	}
	
	@Operation(summary = "Adding new Encounter to existing patient", description = "API is used to add new encounter to existing patient")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully added"),
			@ApiResponse(responseCode = "404", description = "Patient not found for the given id") })
	@PutMapping("/addNewEncounterToExistingPatient")
	public ResponseEntity<ResponseStructure<Patient>> addNewEncounterToExistingPatient(@RequestParam int patientId, @RequestBody Encounter newEncounter) {
		return patientService.addNewEncounterToExistingPatient(patientId, newEncounter);
	}
	
	
	@Operation(summary = "Adding Existing patient to existing payment", description = "API is used to add existing patient to existing payment")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully added"),
			@ApiResponse(responseCode = "404", description = "Patient not found for the given id") })
	@PutMapping("/addExistingPatientToExistingPayment")
	public ResponseEntity<ResponseStructure<Patient>> addExistingPatientToExistingPayment(@RequestParam int patientId, @RequestParam int paymentId) {
		return patientService.addExistingPatientToExistingPayment(patientId, paymentId);
		
	}
	
	@Operation(summary = "Adding New Payment to Existing patient", description = "API is used to add new payment to existing patient")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully added"),
			@ApiResponse(responseCode = "404", description = "Patient not found for the given id") })
	
	@PutMapping("/addNewPaymentToExistingPatient")
	public ResponseEntity<ResponseStructure<Patient>> addNewPaymentToExistingPatient(@RequestParam int patientId, @RequestBody Payment newPayment) {
		return patientService.addNewPaymentToExistingPatient(patientId, newPayment);
	}
	
	
	@Operation(summary = "Adding Existing patient to existing medicine", description = "API is used to add existing patient to existing medicine")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully added"),
			@ApiResponse(responseCode = "404", description = "Patient not found for the given id") })
	@PutMapping("/addExistingPatientToExistingMedicine")
	public ResponseEntity<ResponseStructure<Patient>> addExistingPatientToExistingMedicine(@RequestParam int patientId, @RequestParam int medicineId) {
		return patientService.addExistingPatientToExistingMedicine(patientId,medicineId);
	}
	
	
	@Operation(summary = "Adding new medicine to Existing patient", description = "API is used to add new medicine to existing patient")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully added"),
			@ApiResponse(responseCode = "404", description = "Patient not found for the given id") })
	@PutMapping("/addNewMedicineToExistingPatient")
	public ResponseEntity<ResponseStructure<Patient>> addNewMedicineToExistingPatient(@RequestParam int patientId, @RequestBody Medicine newMedicine) {
		return patientService.addNewMedicineToExistingPatient(patientId, newMedicine);
	}
}
