package net.javaguides.springboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;
import net.javaguides.springboot.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	//Creating reference of EmployeeRepository.
	private EmployeeRepository employeeRepository;
	
	

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}


//This we are using for creating new employee in table i.e it is for post method.
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}


// These we are using for get method i.e getting all the employees.
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}



	@Override
	public Employee getEmployeeById(long id) {
		// TODO Auto-generated method stub
		/*Optional<Employee> employee =employeeRepository.findById(id);
		if(employee.isPresent())
		{
			return employee.get();
		}
		else {
			throw new ResourceNotFoundException("Employee", "Id", id);
		}*/
		return employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee", "Id", id));	
		}



	@Override
	public Employee updateEmployee(Employee employee, long id) {
		
		//Here we are checking wheather employee with given id is exist in DB or not.
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow
				( ()-> new ResourceNotFoundException("Employee", "Id", id));
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		
		// Here we are saving existing employee to DB.
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}



	@Override
	public void deleteEmployee(long id) {
		
		//check wheather a employee exist with particular id or not in DB.
		employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id) );
		
		employeeRepository.deleteById(id);
	}
	
	

}
