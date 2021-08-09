package com.revature.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.ReimbursementDao;
import com.revature.dao.UserDao;
import com.revature.models.Reimbursement;
import com.revature.models.User;


public class LoginServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		PrintWriter out = res.getWriter();
		
		User u = UserDao.getUserByUserName(username);
		if(u.getPassword().equals(password)) {
			out.println("Logged in");
			out.println( u.getFirstName() + " " + u.getLastName() + "\n" + u.getUserRole().getType());
			
			List<Reimbursement> r = ReimbursementService.getAllUserReimbursements(u);
			
			for (Reimbursement reimbursement : r) {
				out.println(reimbursement.toString());
			}
			
			
					
		} else {
			out.println("<h1>You suck!</h1>");
		}
		
		
		
	}

}
