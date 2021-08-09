package com.revature.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Reimbursement {
	@Id()
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int reimbursmentAmount;
	private Date submittedDate;
	private Date resovedDate;
	private String description;
	@ManyToOne
	private User author;
	@ManyToOne
	private Status status;
	
	
	public Reimbursement() {
		
	}
	
	
	public Reimbursement(int reimbursmentAmount, Date submittedDate, String description, User author, int status) {
		super();
		
		Status ur1 = new Status();
		ur1.setStatusId(1);
		ur1.setReimbursementStatus("PENDING");
//		urDao.createUser(ur1);
		
		Status ur2 = new Status();
		ur2.setStatusId(2);
		ur2.setReimbursementStatus("APPROVED");
//		urDao.createUser(ur2);
		
		Status ur3 = new Status();
		ur3.setStatusId(3);
		ur3.setReimbursementStatus("DENIED");
		
		Status ur150;
		if(status == 1) {
			ur150 = ur1;
		} else if (status==2) {
			ur150 = ur2;
		} else {
			ur150 = ur3;
		}
		this.reimbursmentAmount = reimbursmentAmount;
		this.submittedDate = submittedDate;
		this.description = description;
		this.author = author;		
		this.status = ur150;
	}


	public Reimbursement(int reimbursmentAmount, Date submittedDate, String description, User author) {
		super();
		this.reimbursmentAmount = reimbursmentAmount;
		this.submittedDate = submittedDate;
		this.description = description;
		this.author = author;
	}
	
	
	public Reimbursement(Date resovedDate, int status) {
		super();
		this.resovedDate = resovedDate;
		Status ur1 = new Status();
		ur1.setStatusId(1);
		ur1.setReimbursementStatus("PENDING");
//		urDao.createUser(ur1);
		
		Status ur2 = new Status();
		ur2.setStatusId(2);
		ur2.setReimbursementStatus("APPROVED");
//		urDao.createUser(ur2);
		
		Status ur3 = new Status();
		ur3.setStatusId(3);
		ur3.setReimbursementStatus("DENIED");
		
		Status ur150;
		if(status == 1) {
			ur150 = ur1;
		} else if (status==2) {
			ur150 = ur2;
		} else {
			ur150 = ur3;
		}

		this.status = ur150;
	}


	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public int getId() {
		return id;
	}
	public int getReimbursmentAmount() {
		return reimbursmentAmount;
	}
	public void setReimbursmentAmount(int reimbursmentAmount) {
		this.reimbursmentAmount = reimbursmentAmount;
	}
	public Date getSubmittedDate() {
		return submittedDate;
	}
	public void setSubmittedDate(Date submittedDate) {
		this.submittedDate = submittedDate;
	}
	public Date getResovedDate() {
		return resovedDate;
	}
	public void setResovedDate(Date resovedDate) {
		this.resovedDate = resovedDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", reimbursmentAmount=" + reimbursmentAmount + ", submittedDate="
				+ submittedDate + ", resovedDate=" + resovedDate + ", description=" + description + ", author=" + author
				+ ", status=" + status + "]";
	}

	
	
	
	
}
