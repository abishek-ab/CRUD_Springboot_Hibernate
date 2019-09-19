package com.hibernate.department.department_hibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.hibernate.department.department_hibernate.controller","com.hibernate.department.department_hibernate.service","com.hibernate.department.department_hibernate.DAO",
             "com.hibernate.department.department_hibernate.Model"})
public class DepartmentHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentHibernateApplication.class, args);
	}

}
