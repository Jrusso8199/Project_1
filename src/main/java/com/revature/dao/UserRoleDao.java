package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.UserRole;
import com.revature.utils.HibernateUtil;

public class UserRoleDao {
	
	public void createUser(UserRole u) {
		Session ses = HibernateUtil.getSession();
		Transaction tran = ses.beginTransaction();
		//.save will save the object to the database for you
		ses.save(u);
		tran.commit();
		//ses.close();
	}

}
