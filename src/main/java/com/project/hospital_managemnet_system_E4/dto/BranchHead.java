package com.project.hospital_managemnet_system_E4.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class BranchHead {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int branchHeadId;
	public int getBranchHeadId() {
		return branchHeadId;
	}
	public void setBranchHeadId(int branchHeadId) {
		this.branchHeadId = branchHeadId;
	}
	public String getBranchHeadName() {
		return branchHeadName;
	}
	public void setBranchHeadName(String branchHeadName) {
		this.branchHeadName = branchHeadName;
	}
	public String getBranchHeadEmail() {
		return branchHeadEmail;
	}
	public void setBranchHeadEmail(String branchHeadEmail) {
		this.branchHeadEmail = branchHeadEmail;
	}
	public long getBranchHeadPhone() {
		return branchHeadPhone;
	}
	public void setBranchHeadPhone(long branchHeadPhone) {
		this.branchHeadPhone = branchHeadPhone;
	}
	public double getBranchHeadSalary() {
		return branchHeadSalary;
	}
	public void setBranchHeadSalary(double branchHeadSalary) {
		this.branchHeadSalary = branchHeadSalary;
	}
	private String branchHeadName;
	private String branchHeadEmail;
	private long branchHeadPhone;
	private double branchHeadSalary;

}
