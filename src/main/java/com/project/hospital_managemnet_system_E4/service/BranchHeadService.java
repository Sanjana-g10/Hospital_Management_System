package com.project.hospital_managemnet_system_E4.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.hospital_managemnet_system_E4.dao.BranchHeadDao;
import com.project.hospital_managemnet_system_E4.dto.BranchHead;
import com.project.hospital_managemnet_system_E4.exception.BranchHeadIdNotFound;
import com.project.hospital_managemnet_system_E4.exception.BranchIdNotFound;
import com.project.hospital_managemnet_system_E4.util.ResponseStructure;
@Service
public class BranchHeadService {
	@Autowired
	BranchHeadDao branchHeadDao;
	
	@Autowired
	ResponseStructure<BranchHead> responseStructure;
	
	   public ResponseEntity<ResponseStructure<BranchHead>> saveBranchHead(BranchHead branchHead) {
		   responseStructure.setMessage("Successfully Branch Head created");
		   responseStructure.setStatusCode(HttpStatus.CREATED.value());
		   responseStructure.setData(branchHeadDao.saveBranchHead(branchHead));
		return new ResponseEntity<ResponseStructure<BranchHead>>(responseStructure, HttpStatus.CREATED);
		   
	   }
	   
	   
	   
	   public ResponseEntity<ResponseStructure<BranchHead>> updateBranchHeadById(int oldBranchHeadId, BranchHead newBranchHead ) {
		   BranchHead branchHead = branchHeadDao.fetchBranchHeadById(oldBranchHeadId);
		   if ( branchHead != null) {
			   responseStructure.setMessage("Successfully Branch Head updated by ID");
			   responseStructure.setStatusCode(HttpStatus.OK.value());
			   responseStructure.setData(branchHeadDao.updateBranchHeadById(oldBranchHeadId, newBranchHead));
		   	return new ResponseEntity<ResponseStructure<BranchHead>>(responseStructure, HttpStatus.OK);
		   }else {
			   throw new BranchHeadIdNotFound();
		   }
		  
	   }
	   
		public ResponseEntity<ResponseStructure<BranchHead>> fetchBranchHeadById(int BranchHeadId) {
			BranchHead branchHead = branchHeadDao.fetchBranchHeadById(BranchHeadId);
			if (branchHead != null) {
				responseStructure.setMessage("Successfully Branch Head fetched by ID");
				responseStructure.setStatusCode(HttpStatus.FOUND.value());
				responseStructure.setData(branchHeadDao.fetchBranchHeadById(BranchHeadId));
				return new ResponseEntity<ResponseStructure<BranchHead>>(responseStructure, HttpStatus.FOUND);
			}else {
				throw new BranchHeadIdNotFound();
			}
			
		}
		
		
		
		public ResponseEntity<ResponseStructure<BranchHead>> deleteBranchHeadById(int branchHeadId) {
			BranchHead branchHead = branchHeadDao.fetchBranchHeadById(branchHeadId);
			if (branchHead != null) {
				responseStructure.setMessage("Successfully Branch Head deleted by ID");
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setData(branchHeadDao.deleteBranchHeadById(branchHeadId));
				return new ResponseEntity<ResponseStructure<BranchHead>>(responseStructure, HttpStatus.OK);
			}else {
				throw new BranchHeadIdNotFound();
			}
			
			
		}
		
	    
		public List<BranchHead> fetchAllBranchHead() {
			return branchHeadDao.fetchAllBranchHead();
		}
}
