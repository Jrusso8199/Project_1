package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.revature.models.User;
import com.revature.models.UserRole;
import com.revature.utils.HibernateUtil;

public class UserDao{
	private static UserRoleDao urDao = new UserRoleDao();	
	//Native SQL will allow us to execute plain old SQL queries on the table itself
	//It is not recommeded because this tightly couples your code to the database itself
	
	public static List<User> getAllUsers() {
		Session ses = HibernateUtil.getSession();
		List<User> users = ses.createNativeQuery("select * from user_table", User.class).list();
		//ses.close();
		return users;
	}
	
	//Criteria API allows you to create complex queries programaticaly using OOP principles rather than sql
	//It targets the objects rather than the tables

	public static User getUserByUserName(String username) {
		
		Session ses = HibernateUtil.getSession();
		System.out.println("In get user by username");
		User user = ses.createQuery("from User where username=:username", User.class).setString("username", username).uniqueResult();
//		System.out.println(user);
		//ses.close();
		return user;
	}
	
	//HQL allows you to create queries based on the object rather than the table
	public static User getUserById(int id) {
		Session ses = HibernateUtil.getSession();
		User user = ses.createQuery("from User where id=" + id, User.class).uniqueResult();
		return user;
	}
	
	//Sessions have built in methods that help you achieve basic crud operations
	
	public static void createUser(String firstName, String lastName, String username, String password, String email, int roleId) {
		
		UserRole ur1 = new UserRole();
		UserRole ur2 = new UserRole();
		ur1.setId(1);
		ur1.setType("EMPLOYEE");
//		urDao.createUser(ur1);
		
		ur2.setId(2);
		ur2.setType("MANAGER");
//		urDao.createUser(ur2);
		UserRole ur150;
		if(roleId == 1) {
			ur150 = ur1;
		} else {
			ur150 = ur2;
		}
		
		User u = new User(firstName, lastName, username, password , email, ur150);
		Session ses = HibernateUtil.getSession();
		Transaction tran = ses.beginTransaction();
		//.save will save the object to the database for you
		ses.save(u);
		tran.commit();
		//ses.close();
	}
	
public static void createUser(String firstName, String lastName, String username, String password, String email) {
		
		
		
		User u = new User(firstName, lastName, username, password , email);
		Session ses = HibernateUtil.getSession();
		Transaction tran = ses.beginTransaction();
		//.save will save the object to the database for you
		ses.save(u);
		tran.commit();
		//ses.close();
	}

	
	public static void updateUser(User u) {
		Session ses = HibernateUtil.getSession();
		Transaction tran = ses.beginTransaction();
		//.update will update a specific record for you
		ses.update(u);
		tran.commit();
		//ses.close();
	}
	
	public static void updateUserType(int userId,int roleId) {
		Session ses = HibernateUtil.getSession();
		Transaction tran = ses.beginTransaction();
		User u = UserDao.getUserById(userId);
		UserRole ur1 = new UserRole();
		ur1.setId(1);
		ur1.setType("EMPLOYEE");
//		urDao.createUser(ur1);
		
		UserRole ur2 = new UserRole();
		ur2.setId(2);
		ur2.setType("MANAGER");
//		urDao.createUser(ur2);
		UserRole ur150;
		if(roleId == 1) {
			ur150 = ur1;
		} else {
			ur150 = ur2;
		}
		u.setUserRole(ur150);
		ses.update(ur150);
		tran.commit();
	}


	public static void deleteUser(User u) {
		Session ses = HibernateUtil.getSession();
		Transaction tran = ses.beginTransaction();
		//.update delete will delete an entity from the table for you
		ses.delete(u);
		tran.commit();
		//ses.close();
	}

}
