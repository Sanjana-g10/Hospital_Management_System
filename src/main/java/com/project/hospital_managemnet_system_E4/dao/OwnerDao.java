package com.project.hospital_managemnet_system_E4.dao;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.project.hospital_managemnet_system_E4.dto.Hospital;
import com.project.hospital_managemnet_system_E4.dto.Owner;
import com.project.hospital_managemnet_system_E4.exception.OwnerIdNotFound;
import com.project.hospital_managemnet_system_E4.repo.OwnerRepo;
@Repository
public class OwnerDao {
	
	@Autowired
	OwnerRepo ownerRepo;
	
	@Autowired
	HospitalDao hospitalDao;
	
	
	public Owner saveOwner(Owner owner) {
		return ownerRepo.save(owner);
	}
	
	public Owner updateOwnerById(int oldOwnerId, Owner newOwner) {
		Optional<Owner> owner = ownerRepo.findById(oldOwnerId);
		if(owner.isEmpty()) {
			return null;
		}else {
			return owner.get();
		}
//		newOwner.setOwnerId(oldOwnerId);
//	//	return ownerRepo.save(newOwner);
//		return saveOwner(newOwner);
	}
	
	public Owner fetchOwnerById(int ownerId) {
		Optional<Owner> owner= ownerRepo.findById(ownerId);
		if(owner.isEmpty()) {
			return null;
		}else {
			return owner.get();
		}
		
	}
	

	
	
	public Owner deleteOwnerById(int ownerId) {
	    Optional<Owner> optionalOwner = ownerRepo.findById(ownerId);
	    if (optionalOwner.isPresent()) {
	        Owner owner = optionalOwner.get();
	        ownerRepo.delete(owner);
	        return owner;
	    } else {
	        throw new OwnerIdNotFound();
	    }
	}
	
	public List<Owner> fetchAllOwner(){
		return ownerRepo.findAll();
	}
 
	public Owner addExistingHospitalToExistingOwner(int hospitalId, int ownerId) {
		Owner owner =fetchOwnerById(ownerId);
		Hospital hospital=hospitalDao.fetchHospitalById(hospitalId);
		owner.setHospital(hospital);
		return ownerRepo.save(owner);
				
	}
	

	


}
