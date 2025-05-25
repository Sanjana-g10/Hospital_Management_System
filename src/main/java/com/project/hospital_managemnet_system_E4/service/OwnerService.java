package com.project.hospital_managemnet_system_E4.service;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.hospital_managemnet_system_E4.dao.HospitalDao;
import com.project.hospital_managemnet_system_E4.dao.OwnerDao;
import com.project.hospital_managemnet_system_E4.dto.Hospital;
import com.project.hospital_managemnet_system_E4.dto.Owner;
import com.project.hospital_managemnet_system_E4.exception.HospitalIdNotFound;
import com.project.hospital_managemnet_system_E4.exception.OwnerIdNotFound;
import com.project.hospital_managemnet_system_E4.util.ResponseStructure;

@Service
public class OwnerService {

	@Autowired
	OwnerDao ownerDao;
	
    @Autowired
    HospitalDao hospitalDao;

	
    @Autowired
    ResponseStructure<Owner> responseStructure;
    
    public  ResponseEntity<ResponseStructure<Owner>>saveOwner(Owner owner){
    	responseStructure.setMessage("successfully owner created in DB");
    	responseStructure.setStatusCode(HttpStatus.CREATED.value());
    	responseStructure.setData(ownerDao.saveOwner(owner));
	     return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.CREATED);   	
    }

	public ResponseEntity<ResponseStructure<Owner>> updateOwnerById(int oldOwnerId, Owner newOwner) {
		Owner owner = ownerDao.fetchOwnerById(oldOwnerId);
		if(owner!= null) {
		     responseStructure.setMessage("Successfully owner updated by ID");
		     responseStructure.setStatusCode(HttpStatus.OK.value());
		     responseStructure.setData(ownerDao.updateOwnerById(oldOwnerId, newOwner));
				return new ResponseEntity<ResponseStructure<Owner>>(responseStructure,HttpStatus.OK);
		}else {
			throw new OwnerIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Owner>> fetchOwnerById(int ownerId) {
		Owner owner =ownerDao.fetchOwnerById(ownerId);
		if(owner != null) {
			responseStructure.setMessage("Successfully owner fetched By ID");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(ownerDao.fetchOwnerById(ownerId));
			return new ResponseEntity<ResponseStructure<Owner>>(responseStructure,HttpStatus.FOUND);
			
		}else {
		 throw new OwnerIdNotFound();
		}
	
	}

	public ResponseEntity<ResponseStructure<Owner>> deleteOwnerById(int ownerId) {
		Owner owner = ownerDao.fetchOwnerById(ownerId);
		if (owner != null) {
		    responseStructure.setMessage("Successfully owner deleted by ID");
	        responseStructure.setStatusCode(HttpStatus.OK.value());
	        responseStructure.setData(ownerDao.deleteOwnerById(ownerId));
	        return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.OK);
		}else {
			throw new OwnerIdNotFound();
		}
		
	}
	
	


	public List<Owner> fetchAllOwner() {
		return ownerDao.fetchAllOwner();
	}

	
	
	public ResponseEntity<ResponseStructure<Owner>> addExistingHospitalToExistingOwner(int hospitalId, int ownerId){
		Owner owner = ownerDao.fetchOwnerById(ownerId);
		Hospital hospital= hospitalDao.fetchHospitalById(hospitalId);
		if(owner!=null) {
			if(hospital!=null) {
				responseStructure.setMessage("Successfully added existing hospital to existing owner");
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setData(ownerDao.addExistingHospitalToExistingOwner(hospitalId, ownerId));
				return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.OK);
			}

			
		else {
			throw new HospitalIdNotFound();
		}
		}
		else {
		 throw new OwnerIdNotFound();	
		}
	}}
	
	


