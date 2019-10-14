package com.hibernate.department.department_hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernate.department.department_hibernate.DAO.UserAuthentication;
import com.hibernate.department.department_hibernate.Model.User;

@Service
public class UserAuthenticationService {
	
	@Autowired
	UserAuthentication userAuthentication;
	
	public String addNewUser(User user) {
		userAuthentication.save(user);
		return "Saved successfully";
	}
	
	public User findByUsernameAndPassword(String username, String password){
		
		return userAuthentication.findByUsernameAndPassword(username, password);
		
	}

}
