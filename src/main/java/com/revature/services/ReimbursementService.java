package com.revature.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.utils.HibernateUtil;

public class ReimbursementService {
	
	public static List<Reimbursement> getAllUserReimbursements(User u){
		int uid = u.getId();
		Session ses = HibernateUtil.getSession();
		List<Reimbursement> r = ses.createQuery("from Reimbursement where author_id=" + uid, Reimbursement.class).list();
		return r;
	}
	
	
}