package com.hibernate.department.department_hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.department.department_hibernate.Model.Employee;
import com.hibernate.department.department_hibernate.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping("/create")
	public String createEmployee(@RequestParam String firstName, @RequestParam String department) {
		employeeService.insertEmployeeById(new Employee(0,firstName,department));
		return "User created successfully !";
	}
	
	@GetMapping("/read")
	public Employee readEmpById(@RequestParam int id) {
		Employee emp=employeeService.readEmpById(id);
		return emp;
	}
	
	@GetMapping("/update")
	public String updateEmpById(@RequestParam int id,@RequestParam String firstName,@RequestParam String department) {
		Employee emp=new Employee();
		emp.setId(id);
		emp.setFirstName(firstName);
		emp.setDepartment(department);
		employeeService.updateEmployeeById(emp);
		return "User updated successfully !";
	}
	
	@GetMapping("/delete")
	public String deleteById(@RequestParam int id) {
		employeeService.deleteById(id);
		return "Deleted successfully";
	}
	
	@GetMapping("/getall")
	public List<Employee> getAll(){
		return employeeService.getAllEmployees();
	}
	

}
