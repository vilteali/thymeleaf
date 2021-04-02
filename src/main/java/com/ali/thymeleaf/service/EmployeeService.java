package com.ali.thymeleaf.service;

import java.util.List;

import com.ali.thymeleaf.entity.Employee;

public interface EmployeeService {

	List<Employee> findAll();
	
	Employee findById(Integer id);
	
	void save(Employee employee);
	
	void deleteById(Integer id);
	
}
