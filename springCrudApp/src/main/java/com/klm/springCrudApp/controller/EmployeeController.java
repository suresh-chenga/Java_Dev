package com.klm.springCrudApp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.klm.springCrudApp.model.Employee;
import com.klm.springCrudApp.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	/**
	 * Method is used to get the list of employees
	 * 
	 * @return List<Employee>
	 */
	@RequestMapping(value="/EmployeeDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>> getEmpDetails(){

		// Service call to get all employee details
		List<Employee> empList = empService.getAllEmployess();
		
		return new ResponseEntity<List<Employee>>(empList, HttpStatus.OK);
	}
	
	/**
	 * Method is used to get employee detail by eid
	 * 
	 * @return Employee
	 */
	@RequestMapping(value="/EmployeeDetailByID/{eid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getEmpDetailByID(@PathVariable("eid") int eid) {
		Employee emp = null;
		try {
			emp = new Employee();
			// Service call to get employee detail by eid
			emp = empService.getByEId(eid);
			
			if (emp == null) {			
				return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
			}
			
		} catch(Exception ex) {
		}
		
		
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}
	
	/**
	 * Method is used to get employee detail by ename
	 * 
	 * @return List<Employee>
	 */
	@RequestMapping(value="/EmployeeDetailByName/{ename}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>> getEmpDetailByName(@PathVariable("ename") String ename){

		// Service call to get employee detail by ename
		List<Employee> empList = empService.getByEName(ename);
		
		return new ResponseEntity<List<Employee>>(empList, HttpStatus.OK);
	}
	
	/**
	 * Method is used to get employee detail by ename and designation
	 * 
	 * @return List<Employee>
	 */
	@RequestMapping(value="/EmployeeSearch/{value}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>> getEmpDeatilsBySearchCriteria(@PathVariable("value") String value){

		// Service call to get employee detail by search value
		List<Employee> empList = empService.empSearchCriteria(value);
		
		return new ResponseEntity<List<Employee>>(empList, HttpStatus.OK);
	}
}
