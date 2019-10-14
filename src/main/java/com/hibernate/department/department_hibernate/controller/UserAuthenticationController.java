package com.hibernate.department.department_hibernate.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.department.department_hibernate.Model.User;
import com.hibernate.department.department_hibernate.service.UserAuthenticationService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@CrossOrigin(origins="*")
public class UserAuthenticationController {
	
	@Autowired
	UserAuthenticationService userAuthenticationService;
	
	@PostMapping(value = "/register")
	public String addNewUser(User user) {
		userAuthenticationService.addNewUser(user);
		return "Saved successfully";
	}
	
	@PostMapping(value = "/login")
	public ResponseEntity<Map<String, String>> loginUser(@RequestBody User user){
		String token=null;
		Map<String, String> response=null;
		try {
			User u=userAuthenticationService.findByUsernameAndPassword(user.getUsername(), user.getPassword());
			System.out.println(u.getPassword());
			
			token=getToken(user.getId(), user.getPassword());
			response=new HashMap<String, String>();
			response.put("token", token);
			System.out.println("Found"+token);
			return new ResponseEntity<Map<String, String>>(response, HttpStatus.OK);
		}catch(Exception e) {
			response = new HashMap<>();
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String, String>>(response, HttpStatus.CONFLICT);
		}
		
	}
	
	public String getToken(Integer userId, String password) throws Exception {
		return Jwts.builder().setId(userId.toString()).setSubject(password).setIssuedAt(new Date())
				.signWith(SignatureAlgorithm.HS256, "secretkey").compact();

	}
	
	@GetMapping(value = "/isAuthenticated")
	public ResponseEntity<Map<String, Boolean>> authenticateUser(HttpServletRequest request, @RequestHeader("Authentication") String token){
		Map<String, Boolean> response=new HashMap<String, Boolean>();
		System.out.println("ssssssss"+request.toString());
		try {
			if(token !=null && token.contains("Bearer") && token.contains(".")) {
				response.put("isAuthenticated", true);
			}else {
				response.put("isAuthenticated", false);
			}
		}catch(Exception e) {
			response.put("isAuthenticated", false);
		}
		return new ResponseEntity<Map<String,Boolean>>(response,HttpStatus.OK);
	}

}
