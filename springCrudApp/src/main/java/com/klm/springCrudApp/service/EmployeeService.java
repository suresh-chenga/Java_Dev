package com.klm.springCrudApp.service;

import java.util.List;

import com.klm.springCrudApp.model.Employee;

public interface EmployeeService {
	
	List<Employee> getAllEmployess();
	Employee getByEId(int eid);	
	List<Employee> getByEName(String ename);
	List<Employee> empSearchCriteria(String value);
}
