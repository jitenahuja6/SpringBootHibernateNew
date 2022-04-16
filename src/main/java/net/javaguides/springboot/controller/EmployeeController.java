//Here we are defining all rest endpoints.
package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	//Creating reference of employeeService
	private EmployeeService employeeService;

	//Creating Parameterized constructor of EmployeeController
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	// build create employee restapi, below is the post request.
	@PostMapping() //Here requestbody will bind the parameter with http response i.e key with value.
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) 
	{
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED); 
	}
	
	//Build get all employee rest api.
	@GetMapping()
	public List<Employee> getAllEmployees()
	{
		return employeeService.getAllEmployees();
	}
	
	//Build get employee by id rest api.
	
	@GetMapping("{id}")
	
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id")long employeeId)
	{
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
		
	}
	// For updating we are taking two thing in parameter one is employee and another is id because from employee we will get all the details of prerequistic and with particular id it will get update there.
	//Build update employee rest api.
	@PutMapping("{id}")
		public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id,
			@RequestBody Employee employee)
	{
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
		
	}
	
	//Build Delete employee rest api.
	// If we are dealing with one particular id then we are using @Path variable.
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id)
	{
		employeeService.deleteEmployee(id);
		return new ResponseEntity<String>("Employee deleted successfully!", HttpStatus.OK);
	}
	
	
	
}
