package com.hibernate.department.department_hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernate.department.department_hibernate.DAO.EmployeeDaoImpl;
import com.hibernate.department.department_hibernate.Model.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDaoImpl employeeDao;

	public void insertEmployeeById(Employee emp) {
		employeeDao.updateEmployeeById(emp);

	}

	public Employee readEmpById(int id) {
		return employeeDao.getEmployeeById(id);
	}

	public void deleteById(int id) {
		employeeDao.deleteEmployeeById(id);
	}

	public void updateEmployeeById(Employee emp) {
		employeeDao.updateEmployeeById(emp);
	}

	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

}
