package com.hibernate.department.department_hibernate.DAO;

import org.springframework.data.repository.CrudRepository;

import com.hibernate.department.department_hibernate.Model.User;

public interface UserAuthentication extends CrudRepository<User, String> {
	
	User findByUsernameAndPassword(String username,String password);

}
