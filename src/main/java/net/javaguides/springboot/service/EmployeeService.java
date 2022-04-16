package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee); //for post method we have define this.
	List<Employee> getAllEmployees(); // For get method we have define i.e to get all the employees.
	Employee getEmployeeById(long id); //For getting employee with particular id we have define this.
	Employee updateEmployee(Employee employee, long id); // For put method we are defining this. 
	void deleteEmployee(long id); // For delete method we are defining this.
	
	

	
	
	

}
