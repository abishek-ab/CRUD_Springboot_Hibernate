package com.hibernate.department.department_hibernate.DAO;

import java.util.List;

import com.hibernate.department.department_hibernate.Model.Employee;

public interface EmployeeDAO {
	
	public Employee getEmployeeById(int id);
	public void updateEmployeeById(Employee employee);
	public void deleteEmployeeById(int id);
	List<Employee> getAllEmployees();
	

}
