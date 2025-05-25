package com.project.hospital_managemnet_system_E4.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Patient {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int patientId;
    @OneToOne(cascade = CascadeType.ALL)
    private Report report;
	public Report getReport() {
		return report;
	}
	public void setReport(Report report) {
		this.report = report;
	}
	@OneToOne(cascade = CascadeType.ALL)
	public Room room;
	
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Encounter> encounters;
	public List<Encounter> getEncounters() {
		return encounters;
	}
	public void setEncounters(List<Encounter> encounters) {
		this.encounters = encounters;
	}
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Payment> payments;
	public List<Payment> getPayments() {
		return payments;
	}
	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Medicine> medicines;
	public List<Medicine> getMedicines() {
		return medicines;
	}
	public void setMedicines(List<Medicine> medicines) {
		this.medicines = medicines;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public int getPatientAge() {
		return patientAge;
	}
	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}
	public String getPatientGender() {
		return patientGender;
	}
	public void setPatientGender(String patientGender) {
		this.patientGender = patientGender;
	}
	public String getPatientEmail() {
		return patientEmail;
	}
	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}
	public long getPatientPhone() {
		return patientPhone;
	}
	public void setPatientPhone(long patientPhone) {
		this.patientPhone = patientPhone;
	}
	private String patientName;
	private int patientAge;
	private String patientGender;
	private String patientEmail;
	private long patientPhone;

}
