package com.project.hospital_managemnet_system_E4.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.hospital_managemnet_system_E4.dao.AddressDao;
import com.project.hospital_managemnet_system_E4.dto.Address;
import com.project.hospital_managemnet_system_E4.exception.AddressIdNotFound;
import com.project.hospital_managemnet_system_E4.util.ResponseStructure;
@Service
public class AddressService {

	@Autowired
	AddressDao addressDao;
	
	@Autowired
	ResponseStructure<Address> responseStructure;
	
	   public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address) {
		   responseStructure.setMessage("Successfully address saved");
		   responseStructure.setStatusCode(HttpStatus.CREATED.value());
		   responseStructure.setData(addressDao.saveAddress(address));
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.CREATED);
		   
	   }
	   
	   
	   
	   public ResponseEntity<ResponseStructure<Address>> updateAddressById(int oldAddressId, Address newAddress ) {
		   Address address = addressDao.fetchAddressById(oldAddressId);
		   if ( address != null) {
			   responseStructure.setMessage("Successfully address updated by ID");
			   responseStructure.setStatusCode(HttpStatus.OK.value());
			   responseStructure.setData(addressDao.updateAddressById(oldAddressId, newAddress));
			   return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.OK);
		   }else {
			   throw new AddressIdNotFound();
		   }

	   
	   
	   }
	   
		public ResponseEntity<ResponseStructure<Address>> fetchAddressById(int addressId) {
			Address address= addressDao.fetchAddressById(addressId);
			if ( address != null) {
				responseStructure.setMessage("Successfully address fetched By id");
				responseStructure.setStatusCode(HttpStatus.FOUND.value());
				responseStructure.setData(addressDao.fetchAddressById(addressId));
	            return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.OK);
			}else {
				throw new AddressIdNotFound();
			}
			
		}
		
		
		public ResponseEntity<ResponseStructure<Address>> deleteAddressById(int addressId) {
			Address address = addressDao.fetchAddressById(addressId);
			if (address != null) {
				responseStructure.setMessage("Successfully address deleted by ID");
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setData(addressDao.deleteAddressById(addressId));
				return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.OK);
			}else {
				throw new AddressIdNotFound();
			}
			
		}
		
	    
		public List<Address> fetchAllAddress() {
			return addressDao.fetchAllAddress();
		}
	
	
	
	

}
