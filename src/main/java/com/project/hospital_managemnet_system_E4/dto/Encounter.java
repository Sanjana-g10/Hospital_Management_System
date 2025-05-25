package com.project.hospital_managemnet_system_E4.dto;

import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Date;
@Entity
public class Encounter {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int encounterId;
	public int getEncounterId() {
		return encounterId;
	}
	public void setEncounterId(int encounterId) {
		this.encounterId = encounterId;
	}
	public String getEncounterType() {
		return encounterType;
	}
	public void setEncounterType(String encounterType) {
		this.encounterType = encounterType;
	}
	public Date getEncounterDate() {
		return encounterDate;
	}
	public void setEncounterDate(Date encounterDate) {
		this.encounterDate = encounterDate;
	}
	public Time getEncounterTime() {
		return encounterTime;
	}
	public void setEncounterTime(Time encounterTime) {
		this.encounterTime = encounterTime;
	}
	public String getEncounterStatus() {
		return encounterStatus;
	}
	public void setEncounterStatus(String encounterStatus) {
		this.encounterStatus = encounterStatus;
	}
	private String encounterType;
	private Date encounterDate;
	private Time encounterTime;
	private String encounterStatus;

}
