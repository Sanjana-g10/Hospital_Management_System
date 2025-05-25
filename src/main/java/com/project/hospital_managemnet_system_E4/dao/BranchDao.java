package com.project.hospital_managemnet_system_E4.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.project.hospital_managemnet_system_E4.dto.Address;
import com.project.hospital_managemnet_system_E4.dto.Branch;
import com.project.hospital_managemnet_system_E4.dto.BranchHead;
import com.project.hospital_managemnet_system_E4.dto.Owner;
import com.project.hospital_managemnet_system_E4.dto.Patient;
import com.project.hospital_managemnet_system_E4.exception.BranchIdNotFound;
import com.project.hospital_managemnet_system_E4.exception.OwnerIdNotFound;
import com.project.hospital_managemnet_system_E4.repo.BranchRepo;

@Repository
public class BranchDao {

	@Autowired
	BranchRepo branchRepo;
	
	@Autowired
	AddressDao addressDao;

	@Autowired
	BranchHeadDao branchHeadDao;
	
	@Autowired
	PatientDao patientDao;
	
	  public Branch saveBranch(Branch branch) {
		  return branchRepo.save(branch);
	  }
	  
	  
	  public Branch updateBranchById(int oldBranchId, Branch newBranch) {
		  Optional<Branch> branch = branchRepo.findById(oldBranchId);
	  if ( branch.isEmpty()) {
		  return null;
	  }else {
		  return branch.get();
	  }

		  }
	  
	  
	
	  
	  
		public Branch fetchBranchById(int branchId) {
			Optional<Branch> branch = branchRepo.findById(branchId);
			if( branch.isEmpty()) {
				return null;
			}else {
				return branch.get();
			}
		
}

		  
		
		public Branch deleteBranchById(int branchId) {
		    Optional<Branch> optionalBranch = branchRepo.findById(branchId);
		    if (optionalBranch.isPresent()) {
		        Branch branch = optionalBranch.get();
		        branchRepo.delete(branch);
		        return branch;
		    } else {
		        throw new BranchIdNotFound();
		    }
		}
		
		
		public List<Branch> fetchAllBranch(){
			return branchRepo.findAll();
		}

		public Branch addExistingAddressToExistingBranch(int addressId, int branchId) {
			Branch branch =fetchBranchById(branchId);
			Address address=addressDao.fetchAddressById(addressId);
			branch.setAddress(address);
			return branchRepo.save(branch);
					
		}
		
		public Branch addExistingBranchHeadToExistingBranch(int branchHeadId, int branchId) {
			Branch branch=fetchBranchById(branchId);
			BranchHead branchHead=branchHeadDao.fetchBranchHeadById(branchHeadId);
			branch.setBranchHead(branchHead);
			return branchRepo.save(branch);
		}
		
	    public Branch addExistingBranchToExistingPatient(int branchId, int patientId) {
	    	Branch branch = fetchBranchById(branchId);
	    	Patient patient = patientDao.fetchPatientById(patientId);
	    	List<Patient> list= branch.getPatients();
	    	list.add(patient);
	    	branch.setPatients(list);
	    	return saveBranch(branch);
	    }
	 
	    public Branch addNewPatientToExistingBranch(int BranchId, Patient newPatient) {
	    	Branch branch= fetchBranchById(BranchId);
	        List<Patient> list= branch.getPatients();
	        list.add(newPatient);
	        branch.setPatients(list);
	        return saveBranch(branch);
	    }
		
		
}