package com.thir.employeemngmt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thir.employeemngmt.dto.Employee;
import com.thir.employeemngmt.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	/*public List<Employee> empList = new ArrayList<>(Arrays.asList(
			  new Employee(1,"tairou","Bignona"),
			  new Employee(2, "Robi","Seatelle"),
			  new Employee(3,"Jackson","PCF")));*/
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@Override
	public List<Employee> getAllEmployee() {
		//return empList;
		return employeeRepository.findAll();
	}
	// methode qui retourne un employee par son Id avec les streams
	@Override
	public Optional<Employee> getEmployeeById(int empId) {
		//return empList.stream().filter(e->e.getEmpId() == empId).findFirst().get();
		return employeeRepository.findById(empId);
	}
	@Override
	public void addEmployee(Employee employee) {
		//empList.add(employee);
		employeeRepository.save(employee);
		
	}
	@Override
	public void updateEmployee(Employee employee, int empId) {
		/*for (int i = 0; i<empList.size(); i++) {
			Employee e = empList.get(i);
			if(e.getEmpId()==empId) {
				empList.set(i, employee);
				return;
			}
		}*/
		employeeRepository.save(employee);
	}
	@Override
	public void deleteEmployee(int empId) {
		//empList.removeIf(e->e.getEmpId() == empId);
		employeeRepository.deleteById(empId);
	}


}
