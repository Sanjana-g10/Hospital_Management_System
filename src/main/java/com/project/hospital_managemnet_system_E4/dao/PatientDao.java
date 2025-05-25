package com.project.hospital_managemnet_system_E4.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hospital_managemnet_system_E4.dto.Encounter;
import com.project.hospital_managemnet_system_E4.dto.Medicine;
import com.project.hospital_managemnet_system_E4.dto.Owner;
import com.project.hospital_managemnet_system_E4.dto.Patient;
import com.project.hospital_managemnet_system_E4.dto.Payment;
import com.project.hospital_managemnet_system_E4.dto.Report;
import com.project.hospital_managemnet_system_E4.dto.Room;
import com.project.hospital_managemnet_system_E4.exception.OwnerIdNotFound;
import com.project.hospital_managemnet_system_E4.exception.PatientIdNotFound;
import com.project.hospital_managemnet_system_E4.repo.PatientRepo;

@Repository
public class PatientDao {

	
	@Autowired
    PatientRepo patientRepo;
	
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
	
	
	public Patient savePatient(Patient patient) {
		return patientRepo.save(patient);
	}
	
	public Patient updatePatientById(int oldPatientId, Patient newPatient) {
	   Optional<Patient> patient = patientRepo.findById(oldPatientId);
	   if (patient.isEmpty()) {
		   return null;
	   }
	   else {
		   return patient.get();
	   }
	}
	
	public Patient fetchPatientById(int patientId) {
		Optional<Patient> patient = patientRepo.findById(patientId);
		if ( patient.isEmpty()) {
			return null;
		}
		else {
			return patient.get();
		}
	}
	
	public Patient deletePatientById(int patientId) {
		Optional<Patient> optionalPatient = patientRepo.findById(patientId);
		if(optionalPatient.isPresent()) {
			Patient patient= optionalPatient.get();
			patientRepo.delete(patient);
			return patient;
		}
		else {
			throw new PatientIdNotFound();
		}
	}
	

	
	
	public List<Patient> fetchAllPatient(){
		return patientRepo.findAll();
	}
	
	
	public Patient addExistingReportToExistingPatient(int reportId, int patientId) {
	Patient patient =fetchPatientById(patientId);
	 Report report=reportDao.fetchReportById(reportId);
		patient.setReport(report);
		return patientRepo.save(patient);
				
	}

	
	public Patient addExistingRoomToExistingPatient(int roomId, int patientId) {
		Patient patient=fetchPatientById(patientId);
		Room room= roomDao.fetchRoomById(roomId);
		patient.setRoom(room);
		return patientRepo.save(patient);
	}
	
	public Patient addExistingPatientToExistingEncounter(int patientId, int encounterId) {
		Patient patient=fetchPatientById(patientId);
		Encounter encounter=encounterDao.fetchEncounterById(encounterId);
		List<Encounter> list=patient.getEncounters();
		list.add(encounter);
		patient.setEncounters(list);
		return savePatient(patient);
	}
	
	public Patient addNewEncounterToExistingPatient(int patientId, Encounter newEncounter) {
		Patient patient=fetchPatientById(patientId);
		List<Encounter> list=patient.getEncounters();
		list.add(newEncounter);
		patient.setEncounters(list);
		return savePatient(patient);
	}
	
	public Patient addExistingPatientToExistingPayment(int patientId, int paymentId) {
		Patient patient =fetchPatientById(patientId);
		Payment payment=paymentDao.fetchPaymentById(paymentId);
		List<Payment> list=patient.getPayments();
		list.add(payment);
		patient.setPayments(list);
		return savePatient(patient);
	}
	
	public Patient addNewPaymentToExistingPatient(int patientId, Payment newPayment) {
		Patient patient= fetchPatientById(patientId);
		List<Payment> list=patient.getPayments();
		list.add(newPayment);
		patient.setPayments(list);
		return savePatient(patient);
	}
	
	public Patient addExistingPatientToExistingMedicine(int patientId, int medicineId) {
		Patient patient =fetchPatientById(patientId);
		Medicine medicine=medicineDao.fetchMedicineById(medicineId);
		List<Medicine> list= patient.getMedicines();
		list.add(medicine);
		patient.setMedicines(list);
		return savePatient(patient);
	}
	
	public Patient addNewMedicineToExistingPatient(int patientId, Medicine newMedicine) {
		Patient patient =fetchPatientById(patientId);
		List<Medicine> list=patient.getMedicines();
		list.add(newMedicine);
		patient.setMedicines(list);
		return savePatient(patient);
	}
}
