package com.project.hospital_managemnet_system_E4.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hospital_managemnet_system_E4.dto.Branch;
import com.project.hospital_managemnet_system_E4.dto.Hospital;
import com.project.hospital_managemnet_system_E4.dto.Owner;
import com.project.hospital_managemnet_system_E4.exception.HospitalIdNotFound;
import com.project.hospital_managemnet_system_E4.exception.OwnerIdNotFound;
import com.project.hospital_managemnet_system_E4.repo.HospitalRepo;

@Repository
public class HospitalDao {
    @Autowired
    HospitalRepo hospitalRepo;
    
    @Autowired
    BranchDao branchDao;
  public Hospital saveHospital(Hospital hospital) {
	  return hospitalRepo.save(hospital);
  }
	
  public Hospital updateHospitalById(int oldHospitalId, Hospital newHospital) {
	  Optional<Hospital> hospital = hospitalRepo.findById(oldHospitalId);
	  if(hospital.isEmpty()) {
		  return null;
	  }else {
		  return hospital.get();
	  }
  }
  
  
  
	public Hospital fetchHospitalById(int hospitalId) {
		Optional<Hospital> hospital= hospitalRepo.findById(hospitalId);
		if(hospital.isEmpty()) {
			return null;
		}else {
			return hospital.get();
		}
	}
  
	public Hospital deleteHospitalById(int hospitalId) {
		Optional<Hospital> optionalHospital= hospitalRepo.findById(hospitalId);
		if(optionalHospital.isPresent()) {
			Hospital hospital= optionalHospital.get();
		    hospitalRepo.delete(hospital);	
		    return hospital;
		}
		else {
			throw new HospitalIdNotFound();
		}
	}
  
	
	
	
	
	
	public List<Hospital> fetchAllHospital(){
		return hospitalRepo.findAll();
	}
	
    public Hospital addExistingHospitalToExistingBranch(int hospitalId, int branchId) {
    	Hospital hospital = fetchHospitalById(hospitalId);
    	Branch branch = branchDao.fetchBranchById(branchId);
    	List<Branch> list= hospital.getBranches();
    	list.add(branch);
    	hospital.setBranches(list);
    	return saveHospital(hospital);
    }
 
    public Hospital addNewBranchToExistingHospital(int hospitalId, Branch newBranch) {
    	Hospital hospital = fetchHospitalById(hospitalId);
    	List<Branch> list= hospital.getBranches();
    	list.add(newBranch);
    	hospital.setBranches(list);
    	return saveHospital(hospital);
    }




}
