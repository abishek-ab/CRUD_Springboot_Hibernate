package com.hibernate.department.department_hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.department.department_hibernate.Model.Employee;
import com.hibernate.department.department_hibernate.service.EmployeeService;

@RestController
@CrossOrigin
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping(value = "/update" ,produces = { "application/json" })
	public @ResponseBody List<Employee> createEmployee(@RequestBody List<Employee> employee) {
		for(Employee emp:employee) {
			employeeService.insertOrUpdateEmployeeById(emp);
		}
		return employee;
	}
	
	@PostMapping(value = "/create",produces = { "application/json" })
	public @ResponseBody Employee addNewEmployee(@RequestBody Employee employee) {
			employeeService.insertOrUpdateEmployeeById(employee);
		return employee;
	}
	
	@PostMapping("/read")
	public Employee readEmpById(@RequestParam int id) {
		Employee emp=employeeService.readEmpById(id);
		return emp;
	}
	
	@GetMapping("/delete")
	public @ResponseBody String deleteById(@RequestParam int id) {
		employeeService.deleteById(id);
		return "Deleted successfully";
	}
	
	@GetMapping("/getall")
	public List<Employee> getAll(){
		return employeeService.getAllEmployees();
	}
	

}
