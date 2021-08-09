package com.revature.control;

import com.revature.dao.ReimbursementDao;
import com.revature.dao.UserDao;
import com.revature.models.User;

public class ExpenseMain {


	public static void main(String[] args) {

		
//		UserDao.createUser("Jason", "Russo", "jrusso", "password", "stuopid@dkfjdkj.com", 2);
//		UserDao.createUser("April", "Russo", "arusso", "password", "stuopid@dkfjdkj.com", 1);
//		UserDao.createUser("Bob", "Smashface", "dface", "password", "stuopid@dkfjdkj.com", 1);
//		UserDao.createUser("Goon", "Derpson", "myname", "password", "stuopid@dkfjdkj.com", 1);
//		UserDao.createUser("Bill", "Gates", "bgate", "password", "bgates@microsoft.com", 1);
//		User temp = UserDao.getUserById(7);
//		ReimbursementDao.createReimbursement(502, "Lodging", temp);
//		ReimbursementDao.createReimbursement(83, "Food", temp);
//		System.out.println(ReimbursementDao.getReimbursementById(9).toString());
//	
//		for (User users: UserDao.getAllUsers()) {
//			System.out.println(users.toString());
//		}
		
//		System.out.println(UserDao.getUserByUserName("jrusso").toString());
		ReimbursementDao.updateReimbursement(3, 2);

	}
}
