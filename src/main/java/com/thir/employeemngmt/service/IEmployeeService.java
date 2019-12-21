package com.thir.employeemngmt.service;

import java.util.List;
import java.util.Optional;

import com.thir.employeemngmt.dto.Employee;

public interface IEmployeeService {

	List<Employee> getAllEmployee();
	Optional<Employee> getEmployeeById(int empId);
	void addEmployee(Employee employee);
	void updateEmployee(Employee employee, int empId);
	void deleteEmployee(int empId);

}
