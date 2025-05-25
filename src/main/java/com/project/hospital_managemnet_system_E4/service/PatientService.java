package com.project.hospital_managemnet_system_E4.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.hospital_managemnet_system_E4.dao.EncounterDao;
import com.project.hospital_managemnet_system_E4.dao.MedicineDao;
import com.project.hospital_managemnet_system_E4.dao.PatientDao;
import com.project.hospital_managemnet_system_E4.dao.PaymentDao;
import com.project.hospital_managemnet_system_E4.dao.ReportDao;
import com.project.hospital_managemnet_system_E4.dao.RoomDao;
import com.project.hospital_managemnet_system_E4.dto.Employee;
import com.project.hospital_managemnet_system_E4.dto.Encounter;
import com.project.hospital_managemnet_system_E4.dto.Hospital;
import com.project.hospital_managemnet_system_E4.dto.Medicine;
import com.project.hospital_managemnet_system_E4.dto.Owner;
import com.project.hospital_managemnet_system_E4.dto.Patient;
import com.project.hospital_managemnet_system_E4.dto.Payment;
import com.project.hospital_managemnet_system_E4.dto.Report;
import com.project.hospital_managemnet_system_E4.dto.Room;
import com.project.hospital_managemnet_system_E4.exception.EncounterIdNotFound;
import com.project.hospital_managemnet_system_E4.exception.HospitalIdNotFound;
import com.project.hospital_managemnet_system_E4.exception.MedicineIdNotFound;
import com.project.hospital_managemnet_system_E4.exception.OwnerIdNotFound;
import com.project.hospital_managemnet_system_E4.exception.PatientIdNotFound;
import com.project.hospital_managemnet_system_E4.exception.PaymentIdNotFound;
import com.project.hospital_managemnet_system_E4.exception.ReportIdNotFound;
import com.project.hospital_managemnet_system_E4.exception.RoomIdNotFound;
import com.project.hospital_managemnet_system_E4.util.ResponseStructure;

@Service
public class PatientService {

	
	
	@Autowired
	PatientDao patientDao;
	
	
	@Autowired
	ReportDao reportDao;
	
	@Autowired 
	RoomDao roomDao;
	
	@Autowired
	EncounterDao encounterDao;
	
	@Autowired
	PaymentDao paymentDao;
	
	
	@Autowired
	MedicineDao medicineDao;
	
	@Autowired
	ResponseStructure<Patient> responseStructure;

	public ResponseEntity<ResponseStructure<Patient>> savePatient(Patient patient) {
		responseStructure.setMessage("Successfully patient created");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(patientDao.savePatient(patient));
		return new ResponseEntity<ResponseStructure<Patient>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Patient>> updatePatientById(int oldPatientId, Patient newPatient) {
		Patient patient = patientDao.fetchPatientById(oldPatientId);
		if(patient != null) {
			responseStructure.setMessage("Successfully patient updated by ID");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(patientDao.updatePatientById(oldPatientId, newPatient));
			return new ResponseEntity<ResponseStructure<Patient>>(responseStructure, HttpStatus.OK);
		}
		else {
			throw new PatientIdNotFound();
		}
				}
	

	public ResponseEntity<ResponseStructure<Patient>> fetchPatientById(int patientId) {
		Patient patient = patientDao.fetchPatientById(patientId);
		if (patient != null) {
			responseStructure.setMessage("Successfully patient fetched by ID");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(patientDao.fetchPatientById(patientId));
			return new ResponseEntity<ResponseStructure<Patient>>(responseStructure, HttpStatus.FOUND);
		}else {
			throw new PatientIdNotFound();
		}
		
	}

	public ResponseEntity<ResponseStructure<Patient>> deletePatientById(int patientId) {
		Patient patient = patientDao.fetchPatientById(patientId);
		if (patient != null) {
			responseStructure.setMessage("Successfully patient deleted by ID");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(patientDao.deletePatientById(patientId));
			return new ResponseEntity<ResponseStructure<Patient>>(responseStructure, HttpStatus.OK);
		}else {
			throw new PatientIdNotFound();
		}
		
      
	}

	public List<Patient> fetchAllPatient() {
		return patientDao.fetchAllPatient();
	}
	
	
	public ResponseEntity<ResponseStructure<Patient>> addExistingReportToExistingPatient(int reportId, int patientId) {
			Patient patient = patientDao.fetchPatientById(patientId);
			Report report = reportDao.fetchReportById(reportId);
			if (patient != null) {
				if (report != null) {
					responseStructure.setMessage("Successfully addes existing report to existing patient");
					responseStructure.setStatusCode(HttpStatus.OK.value());
					responseStructure.setData(patientDao.addExistingReportToExistingPatient(reportId, patientId));
					return new ResponseEntity<ResponseStructure<Patient>>(responseStructure, HttpStatus.OK);

				}else {
					throw new ReportIdNotFound();
				}
			}
			else {
				throw new PatientIdNotFound();
			}
			}
 
	
	
	
	
	public ResponseEntity<ResponseStructure<Patient>> addExistingRoomToExistingPatient(int roomId, int patientId) {
		Patient patient = patientDao.fetchPatientById(patientId);
		Room room = roomDao.fetchRoomById(roomId);
		if ( patient != null) {
			if (room != null) {
				responseStructure.setMessage("Successfully added existing room to existing patient");
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setData(patientDao.addExistingRoomToExistingPatient(roomId, patientId));
				return new ResponseEntity<ResponseStructure<Patient>>(responseStructure, HttpStatus.OK);
			}else {
				throw new RoomIdNotFound();
			}
		}else {
			throw new PatientIdNotFound();
		}
		
	}
	
	public ResponseEntity<ResponseStructure<Patient>> addExistingPatientToExistingEncounter(int patientId, int encounterId) {
		Patient patient = patientDao.fetchPatientById(patientId);
		Encounter encounter = encounterDao.fetchEncounterById(encounterId);
		if (patient != null) {
			if (encounter != null) {
				responseStructure.setMessage("Successfully addded existing patient to exosting encounter ");
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setData(patientDao.addExistingPatientToExistingEncounter(patientId, encounterId));
				return new ResponseEntity<ResponseStructure<Patient>>(responseStructure, HttpStatus.OK);
			}else {
				throw new EncounterIdNotFound();
			}
		}else {
			throw new PatientIdNotFound();
		}
		
	}
	
	public ResponseEntity<ResponseStructure<Patient>> addNewEncounterToExistingPatient(int patientId,Encounter newEncounter) {
		Patient patient = patientDao.fetchPatientById(patientId);
		Encounter encounter= encounterDao.saveEncounter(newEncounter);
		if (patient != null) {
			if (encounter != null) {
				responseStructure.setMessage("Successfully added new encounter to existing patient");
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setData(patientDao.addNewEncounterToExistingPatient(patientId, newEncounter));
				return new ResponseEntity<ResponseStructure<Patient>>(responseStructure, HttpStatus.OK);
			}else {
				throw new EncounterIdNotFound();
			}
		}else {
			throw new PatientIdNotFound();
		}
		
	}
	
	public ResponseEntity<ResponseStructure<Patient>> addExistingPatientToExistingPayment(int patientId, int paymentId) {
		Patient patient = patientDao.fetchPatientById(patientId);
		Payment payment = paymentDao.fetchPaymentById(paymentId);
		if(patient != null) {
			if (payment != null) {
				responseStructure.setMessage("Successfully  added existing patient to existing payment");
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setData(patientDao.addExistingPatientToExistingPayment(patientId, paymentId));
				return new ResponseEntity<ResponseStructure<Patient>>(responseStructure, HttpStatus.OK);
			}else {
				throw new PaymentIdNotFound();
			}
		}else {
			throw new PatientIdNotFound();
		}
		
	}
	
	public ResponseEntity<ResponseStructure<Patient>> addNewPaymentToExistingPatient(int patientId, Payment newPayment) {
		Patient patient = patientDao.fetchPatientById(patientId);
		Payment payment = paymentDao.savePayment(newPayment);
		if (patient != null) {
			if (payment != null) {
				responseStructure.setMessage("Successfully added new payment to existing patient");
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setData(patientDao.addNewPaymentToExistingPatient(patientId, newPayment));
				return new ResponseEntity<ResponseStructure<Patient>>(responseStructure, HttpStatus.OK);
			}else {
				throw new PaymentIdNotFound();
			}
		}else {
			throw new PatientIdNotFound();
		}
		
	}
	
	public ResponseEntity<ResponseStructure<Patient>> addExistingPatientToExistingMedicine(int patientId, int medicineId) {
		Patient patient = patientDao.fetchPatientById(patientId);
		Medicine medicine = medicineDao.fetchMedicineById(medicineId);
		if (patient != null) {
			if (medicine != null) {
				responseStructure.setMessage("Successfully addes existing patient to existing medicine");
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setData(patientDao.addExistingPatientToExistingMedicine(patientId, medicineId));
				return new ResponseEntity<ResponseStructure<Patient>>(responseStructure, HttpStatus.OK);
			}else {
				throw new MedicineIdNotFound();
			}
		}else {
			throw new PatientIdNotFound();
		}
	
	}
	public ResponseEntity<ResponseStructure<Patient>> addNewMedicineToExistingPatient(int patientId, Medicine newMedicine) {
		Patient patient = patientDao.fetchPatientById(patientId);
		Medicine medicine = medicineDao.saveMedicine(newMedicine);
		if (patient != null) {
			if (medicine != null) {
				responseStructure.setMessage("Successfully added new medicine to existing patient ");
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setData(patientDao.addNewMedicineToExistingPatient(patientId, newMedicine));
				return new ResponseEntity<ResponseStructure<Patient>>(responseStructure, HttpStatus.OK);
			}else {
				throw new MedicineIdNotFound();
			}
		}else {
			throw new PatientIdNotFound();
		}
		
	}
}
