package com.project.hospital_managemnet_system_E4.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hospital_managemnet_system_E4.dto.Report;
import com.project.hospital_managemnet_system_E4.exception.ReportIdNotFound;
import com.project.hospital_managemnet_system_E4.repo.ReportRepo;

@Repository
public class ReportDao {

	
	
	@Autowired
	ReportRepo reportRepo;
	
	
	public Report saveReport(Report report) {
		return reportRepo.save(report);
	}
	
	public Report updateReportById(int oldReportId, Report newReport) {
		Optional<Report> report = reportRepo.findById(oldReportId);
		if (report.isEmpty()) {
			return null;
		}else {
			return report.get();
		
//		newReport.setReportId(oldReportId);
//	//	return ReportRepo.save(newReport);
//		return saveReport(newReport);
	}}
	
	public Report fetchReportById(int reportId) {
		Optional<Report> report = reportRepo.findById(reportId);
		if (report.isEmpty()) {
			return null;
		}else {
			return report.get();
		}
//		return reportRepo.findById(reportId).get();
	}
	
	public Report deleteReportById(int reportId) {
		Optional<Report> optionalReport = reportRepo.findById(reportId);
		if (optionalReport.isPresent()) {
			Report report = optionalReport.get();
			reportRepo.delete(report);
			return report;
		}else {
			
		throw new ReportIdNotFound();
//	//	Report Report=ReportRepo.findById(ReportId).get();
//		Report report=fetchReportById(reportId);
//		reportRepo.delete(report);
//		return report;
	}
	}
	public List<Report> fetchAllReport(){
		return reportRepo.findAll();
	}
}
