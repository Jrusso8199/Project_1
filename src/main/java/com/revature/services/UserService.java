package com.revature.services;

import java.util.ArrayList;
import java.util.List;

//import com.example.dao.PostDao;
import com.revature.dao.UserDao;
import com.revature.dao.UserDao;
import com.revature.exceptions.InvalidCredentialsException;
import com.revature.exceptions.UserDoesNotExistException;
import com.revature.exceptions.UserNameAlreadyExistsException;
//import com.example.fileio.FileIO;
import com.revature.logging.Logging;
import com.revature.models.Role;
import com.revature.models.User;

public class UserService {
	
	private UserDao uDao;
	
	public UserService(UserDao u) {
		this.uDao = u;
	}
	
	public User signUp(String firstName, String lastName, String username, String password, String email) throws UserNameAlreadyExistsException{
		User u = new User(firstName, lastName, username, password, email);
		uDao.createUser(firstName, lastName, username, password, email);
		u = (uDao.getUserByUserName(u.getUsername()));
		if(u == null) {
			Logging.logger.warn("Username created that already exists in the database");
			throw new UserNameAlreadyExistsException();
		}
		return u;
	}
	
//	public User signUp(String firstName, String lastName, String username, String password, String email) throws UserNameAlreadyExistsException{
//		
//		UserDao.createUser(firstName, lastName, username, password, email);
//		User u = new User(firstName, lastName, username, password, email);
//		u = (uDao.getUserByUserName(u.getUsername()));
//		if(u == null) {
//			Logging.logger.warn("Username created that already exists in the database");
//			throw new UserNameAlreadyExistsException();
//		}
//		return u;
//	}
	
	
	public static User signIn(String username, String password) throws UserDoesNotExistException, InvalidCredentialsException{
		System.out.println("In uServ");
		System.out.println(username);
		System.out.println(password);
		User u = UserDao.getUserByUserName(username);
		System.out.println(u);
//		if(u.getId() == 0) {
		if(u == null) {
			Logging.logger.warn("User tried logging in that does not exist");
			throw new UserDoesNotExistException();
		}
		if(!u.getPassword().equals(password)) {
			Logging.logger.warn("User tried to login with invalid credentials");
			throw new InvalidCredentialsException();
		}
		else {
			Logging.logger.info("User was logged in");
			return u;
		}
	}
//	
//	public User getUserById(int id) {
//		return uDao.getUserById(id);
//	}

	
	
}