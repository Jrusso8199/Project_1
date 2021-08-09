package com.revature.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Status {
	@Id
	private int statusId;
	@Column(name="reimbursement_status")
	private String reimbursementStatus;
	@OneToMany(mappedBy="status")
	private List<Reimbursement> Reimbursements;
	
	
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public void setReimbursementStatus(String reimbursementStatus) {
		this.reimbursementStatus = reimbursementStatus;
	}
	
	public String getReimbursementStatus() {
		return reimbursementStatus;
	}
	@Override
	public String toString() {
		return "Status [statusId=" + statusId + ", reimbursementStatus=" + reimbursementStatus + "]";
	}
	
	
	
	
}
