package com.project.hospital_managemnet_system_E4.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.hospital_managemnet_system_E4.dao.AddressDao;
import com.project.hospital_managemnet_system_E4.dao.BranchDao;
import com.project.hospital_managemnet_system_E4.dao.BranchHeadDao;
import com.project.hospital_managemnet_system_E4.dao.PatientDao;
import com.project.hospital_managemnet_system_E4.dto.Address;
import com.project.hospital_managemnet_system_E4.dto.Branch;
import com.project.hospital_managemnet_system_E4.dto.BranchHead;
import com.project.hospital_managemnet_system_E4.dto.Hospital;
import com.project.hospital_managemnet_system_E4.dto.Owner;
import com.project.hospital_managemnet_system_E4.dto.Patient;
import com.project.hospital_managemnet_system_E4.exception.AddressIdNotFound;
import com.project.hospital_managemnet_system_E4.exception.BranchHeadIdNotFound;
import com.project.hospital_managemnet_system_E4.exception.BranchIdNotFound;
import com.project.hospital_managemnet_system_E4.exception.HospitalIdNotFound;
import com.project.hospital_managemnet_system_E4.exception.OwnerIdNotFound;
import com.project.hospital_managemnet_system_E4.exception.PatientIdNotFound;
import com.project.hospital_managemnet_system_E4.util.ResponseStructure;

@Service
public class BranchService {

	@Autowired
	BranchDao branchDao;
	
	
	@Autowired
	AddressDao addressDao;
	
	@Autowired
	BranchHeadDao branchHeadDao;
	
	@Autowired
	PatientDao patientDao;
	
	
	@Autowired
	ResponseStructure<Branch> responseStructure;
	
	   public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch) {
		   responseStructure.setMessage("Successfully branch saved");
		   responseStructure.setStatusCode(HttpStatus.CREATED.value());
		   responseStructure.setData(branchDao.saveBranch(branch));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.CREATED);
		   
	   }
   
   public ResponseEntity<ResponseStructure<Branch>> updateBranchById(int oldBranchId, Branch newBranch ) {
	   Branch branch = branchDao.fetchBranchById(oldBranchId);
	   if (branch != null) {

		   responseStructure.setMessage("Successfully branch updated by id");
		   responseStructure.setStatusCode(HttpStatus.OK.value());
		   responseStructure.setData(branchDao.saveBranch(newBranch));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
	   }else {
		   throw new BranchIdNotFound();
	   }
		   
	  
   }
   
  
   
   
	public ResponseEntity<ResponseStructure<Branch>> fetchBranchById(int BranchId) {
		Branch branch = branchDao.fetchBranchById(BranchId);
		if(branch != null) {
			 responseStructure.setMessage("Successfully branch fetched by id");
			   responseStructure.setStatusCode(HttpStatus.OK.value());
			   responseStructure.setData(branchDao.fetchBranchById(BranchId));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		} else {
			throw new BranchIdNotFound();
		}
			  
	}
	

	
	
	public ResponseEntity<ResponseStructure<Branch>> deleteBranchById(int branchId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if( branch!= null) {
			responseStructure.setMessage("Successfully branch deleted by id");
			   responseStructure.setStatusCode(HttpStatus.OK.value());
			   responseStructure.setData(branchDao.deleteBranchById(branchId));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		}else {
			throw new BranchIdNotFound();
		}
			   
	}
	
    
	public List<Branch> fetchAllBranch() {
		return branchDao.fetchAllBranch();
	}

	
	public ResponseEntity<ResponseStructure<Branch>> addExistingAddressToExistingBranch(int addressId, int branchId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		Address address = addressDao.fetchAddressById(addressId);
		if (branch != null) {
			if(address != null) {
			 responseStructure.setMessage("Successfully added existing address to existing branch");
			   responseStructure.setStatusCode(HttpStatus.OK.value());
			   responseStructure.setData(branchDao.addExistingAddressToExistingBranch(addressId, branchId));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		}
		else {
			throw new AddressIdNotFound();
		}
		}
	else {
		 throw new BranchIdNotFound ();	
		}
}

	
	

	
	
	
	
	public ResponseEntity<ResponseStructure<Branch>> addExistingBranchHeadToExistingBranch(int branchHeadId, int branchId) {
		Branch branch= branchDao.fetchBranchById(branchId);
		BranchHead branchHead = branchHeadDao.fetchBranchHeadById(branchHeadId);
		if( branch != null ) {
			if ( branchHead != null) {
				responseStructure.setMessage("Successfully added existing branch head to existing branch");
				   responseStructure.setStatusCode(HttpStatus.OK.value());
				   responseStructure.setData(branchDao.addExistingBranchHeadToExistingBranch(branchHeadId, branchId));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
			}else {
				throw new BranchHeadIdNotFound();
			}
			
		}else {
			throw new BranchIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Branch>> addExistingBranchToExistingPatient(int branchId, int patientId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		Patient patient = patientDao.fetchPatientById(patientId);
		if ( branch != null) {
			if( patient != null) {

				   responseStructure.setMessage("Successfully added existing branch to existing patient");
				   responseStructure.setStatusCode(HttpStatus.OK.value());
				   responseStructure.setData(branchDao.addExistingBranchToExistingPatient(branchId, patientId));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
			}else {
				throw new PatientIdNotFound();
			}
		}
		else {
			throw new BranchIdNotFound();
		}
	}
	
	
	
	
	public ResponseEntity<ResponseStructure<Branch>> addNewPatientToExistingBranch(int branchId, Patient newPatient) {
		Branch branch = branchDao.fetchBranchById(branchId);
		Patient patient= patientDao.savePatient(newPatient);
		if( branch != null) {
			if (patient != null) {
				   responseStructure.setMessage("Successfully added new patient to existing branch");
				   responseStructure.setStatusCode(HttpStatus.OK.value());
				   responseStructure.setData(branchDao.addNewPatientToExistingBranch(branchId, newPatient));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
			}else {
				throw new PatientIdNotFound();
			}
		}else {
			throw new BranchIdNotFound();
		}
		
	}
}
