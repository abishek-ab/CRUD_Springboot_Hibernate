package com.hibernate.department.department_hibernate;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.hibernate.department.department_hibernate.Model.Employee;
import com.hibernate.department.department_hibernate.controller.EmployeeController;

@SpringBootApplication
@CrossOrigin
@ComponentScan(basePackages = {"com.hibernate.department.department_hibernate.controller","com.hibernate.department.department_hibernate.service","com.hibernate.department.department_hibernate.DAO",
             "com.hibernate.department.department_hibernate.Model"})
public class DepartmentHibernateApplication {
	
	@Autowired
	EmployeeController employeeController;

	public static void main(String[] args) {
		SpringApplication.run(DepartmentHibernateApplication.class, args);
	}
	
	 @PostConstruct
	    private void init() {
		 employeeController.addNewEmployee(new Employee(0, "SPIVA", "SPIVA"));
	    }

}
