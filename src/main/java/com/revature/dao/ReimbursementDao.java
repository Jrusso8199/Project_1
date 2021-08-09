package com.revature.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.models.Reimbursement;
import com.revature.models.Status;
import com.revature.models.User;
//import com.example.models.PostDisplay;
//import com.revature.models.User;
import com.revature.utils.HibernateUtil;

public class ReimbursementDao{
	
	
	public static void createReimbursement(int amount, String description, User u) {
		Date d = new Date();
		Reimbursement r = new Reimbursement(amount, d, description, u );
		Session ses = HibernateUtil.getSession();
		Transaction tran = ses.beginTransaction();
		ses.save(r);
		tran.commit();
	}
	
	public static Reimbursement getReimbursementById(int id) {
		Session ses = HibernateUtil.getSession();
		Query q = ses.createQuery("from Reimbursement where id =:id");
		q.setInteger("id", id);
		Reimbursement r = (Reimbursement) q.uniqueResult();
		return r;
		
	}
	
	public static void updateReimbursement(int id, int status) {
		Session ses = HibernateUtil.getSession();
		Query q = ses.createQuery("from Reimbursement where id =:id");
		q.setInteger("id", id);
		Reimbursement r = (Reimbursement) q.uniqueResult();
		Query st = ses.createQuery("from Status where statusid=:status");
		st.setInteger("status", status);		
		Status s = (Status) st.uniqueResult();
		
		Date d = new Date();
		r.setResovedDate(d);
		r.setStatus(s);
		Transaction tran = ses.beginTransaction();
		ses.update(r);
		tran.commit();
	}
	
	public static List<Reimbursement> getAllReimbursements(User u) {
		int uid = u.getId();
		Session ses = HibernateUtil.getSession();
		Query q = ses.createQuery("from  where id =:id");
		q.setInteger("id", uid);
		
		List<Reimbursement>  r = (List<Reimbursement>) ses.createQuery("select * from reimbursement where id =:id");
		//ses.close();
		return r;
	}
}
