package com.thir.employeemngmt.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thir.employeemngmt.dto.Employee;
import com.thir.employeemngmt.service.IEmployeeService;

@RestController
@CrossOrigin("*")
public class EmployeeController {
	
	@Autowired
	private IEmployeeService empServiceRef;
	
	@RequestMapping("/welcome")
	public String welcomeEmployee() {
		return "Hello Employee";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/employees")
	public List<Employee> getAllEmployees() {
		return empServiceRef.getAllEmployee();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/employees/{empId}")
	public Optional<Employee> getEmployeeById(@PathVariable int empId) {
		return empServiceRef.getEmployeeById(empId);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/employees")
	public void addEmployee(@RequestBody Employee employee) {
		empServiceRef.addEmployee(employee);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/employees/{empId}")
	public void updateEmployee(@RequestBody Employee employee, @PathVariable int empId) {
		empServiceRef.updateEmployee(employee, empId);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/employees/{empId}")
	public void addEmployee(@PathVariable int empId) {
		empServiceRef.deleteEmployee(empId);
	}



}
