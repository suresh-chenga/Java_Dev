package com.klm.springCrudApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.klm.springCrudApp.model.Employee;

/**
 * 
 * @author Suresh Chenga
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private static List<Employee> employees;
	
	static{
		employees= createDummyEmployees();
	}

	public List<Employee> getAllEmployess() {		
		return employees;
	}

	public Employee getByEId(int eid) {
		Employee employee = null;
		if(null != employees){
			for(Employee emp : employees) {
				if(emp.getEid() == eid) {
					employee = new Employee();
					employee = emp;
				}
			}
		}
		
		return employee;
	}

	public List<Employee> getByEName(String ename) {
		List<Employee> empList = new ArrayList<Employee>();
		if(null != employees){
			empList = employees.stream().filter(emp -> emp.getEname().equalsIgnoreCase(ename)).collect(Collectors.toList());
		}
		return empList;
	}
	
	public List<Employee> empSearchCriteria(String value) {
		List<Employee> empList = new ArrayList<Employee>();
		if(null != employees){
			empList = employees.stream()
					.filter(emp -> emp.getEname().contains(value) || emp.getDesignation().contains(value)).collect(Collectors.toList());
		}
		return empList;
	}
	
	private static List<Employee> createDummyEmployees(){
		List<Employee> emps = new ArrayList<Employee>();
		emps.add(new Employee(1,"Sam",70000,"ITA"));
		emps.add(new Employee(2,"Tom",50000,"AST"));
		emps.add(new Employee(3,"Jerome",30000,"SE"));
		emps.add(new Employee(4,"Silvia",40000,"SSE"));
		emps.add(new Employee(5,"Sam",60000,"SSE"));
		return emps;
	}

}
