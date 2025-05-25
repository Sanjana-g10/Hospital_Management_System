package com.project.hospital_managemnet_system_E4.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.hospital_managemnet_system_E4.dao.BranchDao;
import com.project.hospital_managemnet_system_E4.dao.HospitalDao;
import com.project.hospital_managemnet_system_E4.dto.Branch;
import com.project.hospital_managemnet_system_E4.dto.Hospital;
import com.project.hospital_managemnet_system_E4.dto.Owner;
import com.project.hospital_managemnet_system_E4.exception.BranchIdNotFound;
import com.project.hospital_managemnet_system_E4.exception.HospitalIdNotFound;
import com.project.hospital_managemnet_system_E4.exception.OwnerIdNotFound;
import com.project.hospital_managemnet_system_E4.util.ResponseStructure;

@Service
public class HospitalService {
    @Autowired
	HospitalDao hospitalDao;
    
    @Autowired
    BranchDao branchDao;
    
    @Autowired
    ResponseStructure<Hospital> responseStructure;
	
    
    public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital) {
    	responseStructure.setMessage("Successfully hospital created");
    	responseStructure.setStatusCode(HttpStatus.CREATED.value());
    	responseStructure.setData(hospitalDao.saveHospital(hospital));
		return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure, HttpStatus.CREATED);
    	
    }
    
    public ResponseEntity<ResponseStructure<Hospital>> updateHospitalById(int oldHospitalId, Hospital newHospital ) {
    	Hospital hospital= hospitalDao.fetchHospitalById(oldHospitalId);
    	if( hospital !=null) {
    	     responseStructure.setMessage("Successfully hospital updated by ID");
    	        responseStructure.setStatusCode(HttpStatus.OK.value());
    	        responseStructure.setData(hospitalDao.updateHospitalById(oldHospitalId, newHospital));
    	   		return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure, HttpStatus.OK);
    	}else {
    		throw new HospitalIdNotFound();
    	}
    		
    	}
    

	public ResponseEntity<ResponseStructure<Hospital>> fetchHospitalById(int hospitalId) {
		Hospital hospital = hospitalDao.fetchHospitalById(hospitalId);
		if(hospital != null) {
			responseStructure.setMessage("Successfully hospital fetched by Id");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(hospitalDao.fetchHospitalById(hospitalId));
			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure, HttpStatus.FOUND);
			
		}else {
			throw new HospitalIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Hospital>> deleteHospitalById(int hospitalId) {
		Hospital hospital= hospitalDao.fetchHospitalById(hospitalId);
		if( hospital != null) {
			responseStructure.setMessage("Successfully hospital deleted by ID");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(hospitalDao.deleteHospitalById(hospitalId));
			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure, HttpStatus.OK);
		}
		else {
			throw new HospitalIdNotFound();
		}
	}
	

    
	public List<Hospital> fetchAllHospital() {
		return hospitalDao.fetchAllHospital();
	}
	
	public ResponseEntity<ResponseStructure<Hospital>> addExistingHospitalToExistingBranch(int hospitalId, int branchId) {
		Hospital hospital= hospitalDao.fetchHospitalById(hospitalId);
		Branch branch = branchDao.fetchBranchById(branchId);
		if( hospital != null) {
			if(branch != null) {
				
			responseStructure.setMessage("Successfully added existing hospital to existing branch");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(hospitalDao.addExistingHospitalToExistingBranch(hospitalId, branchId));
			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure, HttpStatus.OK);
		}else {
			throw new BranchIdNotFound();
		}
	}
	else {
		throw new HospitalIdNotFound();
	}
}



		
	 public ResponseEntity<ResponseStructure<Hospital>> addNewBranchToExistingHospital(int hospitalId, Branch newBranch) {
		Hospital hospital= hospitalDao.addNewBranchToExistingHospital(hospitalId, newBranch);
		Branch branch= branchDao.saveBranch(newBranch); 
		if (hospital != null) {
			if( branch!= null) {
				responseStructure.setMessage("Successfully added new Branch to Existing Hospital");
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setData(hospitalDao.addNewBranchToExistingHospital(hospitalId, newBranch));
				return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure, HttpStatus.OK);
			}else {
				throw new BranchIdNotFound();
			}} else {
				throw new HospitalIdNotFound();
			}
		}
		
	}
    
