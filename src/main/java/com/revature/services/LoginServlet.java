package com.revature.services;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.revature.exceptions.InvalidCredentialsException;
import com.revature.exceptions.UserDoesNotExistException;
import com.revature.models.User;


public class LoginServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
	
		
		
//		String username = req.getParameter("username");
//		String password = req.getParameter("password");
		
		
		StringBuilder buffer = new StringBuilder();
		BufferedReader reader = req.getReader();
		
		String line;
		while((line = reader.readLine()) != null) {
			buffer.append(line);
			buffer.append(System.lineSeparator());
		}
		String data = buffer.toString();
		System.out.println(data);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode parsedObj = mapper.readTree(data);
		
		String username = parsedObj.get("username").asText();
		String password = parsedObj.get("password").asText();
		
		
		try {
			System.out.println("In the post handler");
			User u = UserService.signIn(username, password);
			ObjectNode user = mapper.createObjectNode();
			user.put("id", u.getId());
			user.put("username", u.getUsername());
			System.out.println(u);
			//We will keep track of if the user is logged in by storing their id in the session
			req.getSession().setAttribute("id", u.getId());
			res.setStatus(HttpServletResponse.SC_OK);
			res.addHeader("Access-Control-Allow-Origin", "*");
			res.setHeader("Access-Control-Allow-Methods", "POST");
			res.getWriter().write(new ObjectMapper().writeValueAsString(u));
		}
		catch(Exception e) {
			e.printStackTrace();
			res.setStatus(HttpServletResponse.SC_FORBIDDEN);
			res.getWriter().println("Username or password incorrect");
		}
		
//		try {
//			User u = UserService.signIn(username, password);
//		} catch (UserDoesNotExistException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvalidCredentialsException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			System.out.println("In the post handler");
//			User u = UserService.signIn(username, password);
//			ObjectNode user = mapper.createObjectNode();
//			user.put("id", u.getId());
//			user.put("username", u.getUsername());
//			System.out.println(u);
//			//We will keep track of if the user is logged in by storing their id in the session
//			req.getSession().setAttribute("id", u.getId());
//			res.setStatus(HttpServletResponse.SC_OK);
//			res.addHeader("Access-Control-Allow-Origin", "*");
//			res.setHeader("Access-Control-Allow-Methods", "POST");
//			res.getWriter().write(new ObjectMapper().writeValueAsString(u));
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//			res.setStatus(HttpServletResponse.SC_FORBIDDEN);
//			res.getWriter().println("Username or password incorrect");
//		}
		
//		String username = req.getParameter("username");
//		String password = req.getParameter("password");
//		
//		PrintWriter out = res.getWriter();
//		
//		User u = UserDao.getUserByUserName(username);
//		if(u.getPassword().equals(password)) {
//			out.println("Logged in");
//			out.println( u.getFirstName() + " " + u.getLastName() + "\n" + u.getUserRole().getType());
//			
//			List<Reimbursement> r = ReimbursementService.getAllUserReimbursements(u);
//			
//			for (Reimbursement reimbursement : r) {
//				out.println(reimbursement.toString());
//			}
//			
//			
//					
//		} else {
//			out.println("<h1>You suck!</h1>");
//		}
		
		
		
	}
	

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		
		System.out.println("REQ" + req.toString());
	}

}
