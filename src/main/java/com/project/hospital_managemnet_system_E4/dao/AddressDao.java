package com.project.hospital_managemnet_system_E4.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.project.hospital_managemnet_system_E4.dto.Address;
import com.project.hospital_managemnet_system_E4.exception.AddressIdNotFound;
import com.project.hospital_managemnet_system_E4.repo.AddressRepo;
@Repository
public class AddressDao {

	@Autowired
	AddressRepo addressRepo;
	
	
	
	  public Address saveAddress(Address address) {
		  return addressRepo.save(address);
	  }
	  
	  public Address updateAddressById(int oldAddressId, Address newAddress) {
		  Optional<Address> address = addressRepo.findById(oldAddressId);
		  if(address.isEmpty()) {
			  return null;
		  }else {
			  return address.get();
		  }

		  }
	  
		public Address fetchAddressById(int addressId) {
			Optional<Address> address = addressRepo.findById(addressId);
			if (address.isEmpty()) {
				return null;
			}else {
				return address.get();
			}
}
		
		public Address deleteAddressById(int addressId) {
			Optional<Address> optionalAddress = addressRepo.findById(addressId);
			if (optionalAddress.isPresent()) {
				Address address = optionalAddress.get();
				addressRepo.delete(address);
				return address;
				
			}else {
				throw new AddressIdNotFound();
			}
			}
		  
		public List<Address> fetchAllAddress(){
			return addressRepo.findAll();
		}
}
