package com.project.hospital_managemnet_system_E4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.hospital_managemnet_system_E4.dao.ReportDao;
import com.project.hospital_managemnet_system_E4.dto.Report;
import com.project.hospital_managemnet_system_E4.exception.ReportIdNotFound;
import com.project.hospital_managemnet_system_E4.util.ResponseStructure;


@Service
public class ReportService {

	
	@Autowired
	ReportDao reportDao;
	
	@Autowired
	ResponseStructure<Report> responseStructure;

	public ResponseEntity<ResponseStructure<Report>> saveReport(Report report) {
		responseStructure.setMessage("Successfully report created");
	     responseStructure.setStatusCode(HttpStatus.CREATED.value());
	     responseStructure.setData(reportDao.saveReport(report));
		return new ResponseEntity<ResponseStructure<Report>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Report>> updateReportById(int oldReportId, Report newReport) {
		Report report = reportDao.fetchReportById(oldReportId);
		if (report != null) {
			responseStructure.setMessage("Successfully report updated by ID");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(reportDao.updateReportById(oldReportId, newReport));
	      return new ResponseEntity<ResponseStructure<Report>>(responseStructure, HttpStatus.OK);
		}else {
			throw new ReportIdNotFound();
		}
	
	}

	public ResponseEntity<ResponseStructure<Report>> fetchReportById(int reportId) {
		Report report = reportDao.fetchReportById(reportId);
		if (report != null) {
			  responseStructure.setMessage("Successfully report fetched by ID");
			   responseStructure.setStatusCode(HttpStatus.FOUND.value());
			   responseStructure.setData(reportDao.fetchReportById(reportId));
				return new ResponseEntity<ResponseStructure<Report>>(responseStructure, HttpStatus.FOUND);
		}else {
			throw new ReportIdNotFound();
		}
	 
	}

	public ResponseEntity<ResponseStructure<Report>> deleteReportById(int reportId) {
		Report report = reportDao.fetchReportById(reportId);
		if (report != null) {
			responseStructure.setMessage("Successfully report deleted by Id");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(reportDao.deleteReportById(reportId));
	       return new ResponseEntity<ResponseStructure<Report>>(responseStructure, HttpStatus.OK);
		}else {
			throw new ReportIdNotFound();
		}

    		   
	}

	public List<Report> fetchAllReport() {
		return reportDao.fetchAllReport();
	}
}
