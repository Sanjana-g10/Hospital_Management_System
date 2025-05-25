package com.project.hospital_managemnet_system_E4.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hospital_managemnet_system_E4.dto.Encounter;
import com.project.hospital_managemnet_system_E4.dto.Owner;
import com.project.hospital_managemnet_system_E4.exception.EncounterIdNotFound;
import com.project.hospital_managemnet_system_E4.exception.OwnerIdNotFound;
import com.project.hospital_managemnet_system_E4.repo.EncounterRepo;


@Repository
public class EncounterDao {

	
	@Autowired
	EncounterRepo encounterRepo;
	
	
	public Encounter saveEncounter(Encounter encounter) {
		return encounterRepo.save(encounter);
	}
	
	public Encounter updateEncounterById(int oldEncounterId, Encounter newEncounter) {
		Optional<Encounter> encounter = encounterRepo.findById(oldEncounterId);
		if (encounter.isEmpty()) {
			return null;
		}else {
			return encounter.get();
		}
//		newEncounter.setEncounterId(oldEncounterId);
//	//	return EncounterRepo.save(newEncounter);
//		return saveEncounter(newEncounter);
	}
	
	public Encounter fetchEncounterById(int encounterId) {
		Optional<Encounter> encounter = encounterRepo.findById(encounterId);
		if (encounter.isEmpty()) {
			return null;
		}else
//		return encounterRepo.findById(encounterId).get();
			return encounter.get();
	}
	
	public Encounter deleteEncounterById(int encounterId) {
		Optional<Encounter> optionalEncounter = encounterRepo.findById(encounterId);
		if (optionalEncounter.isPresent()) {
			Encounter encounter =optionalEncounter.get();
			encounterRepo.delete(encounter);
			return encounter;
		}else {
			throw new EncounterIdNotFound();
		}
	//	Encounter Encounter=EncounterRepo.findById(EncounterId).get();
//		Encounter encounter=fetchEncounterById(encounterId);
//		encounterRepo.delete(encounter);
//		return encounter;
	}
	

	
	public List<Encounter> fetchAllEncounter(){
		return encounterRepo.findAll();
	}
}
