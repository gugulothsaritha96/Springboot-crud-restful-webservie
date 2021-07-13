package com.telusko.springboot.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.springboot.model.Employee;
import com.telusko.springboot.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	private EmployeeService empService;

	public EmployeeController(EmployeeService empService) {
		super();
		this.empService = empService;
	}
	
	//build create employee rest api
	@PostMapping()
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee)
	{
		return new ResponseEntity<Employee>(empService.saveEmployee(employee),HttpStatus.CREATED);
	}
	//built get all employees Rest Api
	@GetMapping
	public List<Employee> getAllEmployees()
	{
		return empService.getAllEmployees();
	
	}
	//http:localhost:8080/api/employee/1
	//Responseentity is a generic class
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id)
	{
		return new ResponseEntity<Employee>(empService.getEmployeeById(id),HttpStatus.CREATED);
		
	}
	//http:localhost:8080/api/employee/1
	//update employee Rest API
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id ,@RequestBody Employee employee)
	{
		return new ResponseEntity<Employee>(empService.updateEmployee(employee, id),HttpStatus.OK);
	}
	
	//built delete Rest Api
	@DeleteMapping("/{id}")
	public ResponseEntity<String>  deleteEmployee(@PathVariable("id") long id) {
		empService.deleteEmployee(id);
		return new ResponseEntity<String>("Employee deleted sucessfully!.",HttpStatus.OK);
	}
	

}
